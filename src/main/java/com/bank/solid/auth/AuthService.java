package com.bank.solid.auth;

import com.bank.solid.account.Account;
import com.bank.solid.account.AccountRepository;
import com.bank.solid.exception.AccountNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthService {
    private final AccountRepository accountRepository;
    private final Map<String, AuthSession> activeSessions;
    private static final int SESSION_TIMEOUT_MINUTES = 30;

    public AuthService(AccountRepository accountRepository) {
        if (accountRepository == null) {
            throw new IllegalArgumentException("AccountRepository no puede ser null");
        }
        this.accountRepository = accountRepository;
        this.activeSessions = new ConcurrentHashMap<>();
    }

    public AuthResult login(String accountNumber, String pin) {
        if (accountNumber == null || accountNumber.isBlank()) {
            return AuthResult.failure("El número de cuenta es requerido");
        }
        if (pin == null || pin.isBlank()) {
            return AuthResult.failure("El PIN es requerido");
        }

        Account account = accountRepository.findByAccountNumber(accountNumber)
            .orElseThrow(() -> new AccountNotFoundException("Cuenta no encontrada: " + accountNumber));

        if (!account.isActive()) {
            return AuthResult.failure("La cuenta está inactiva");
        }

        String storedPin = account.getPin();
        if (storedPin == null || !storedPin.equals(pin)) {
            return AuthResult.failure("PIN incorrecto");
        }

        String sessionToken = generateSessionToken();
        AuthSession session = new AuthSession(
            sessionToken,
            account.getId(),
            accountNumber,
            LocalDateTime.now(),
            LocalDateTime.now().plusMinutes(SESSION_TIMEOUT_MINUTES)
        );
        activeSessions.put(sessionToken, session);

        return AuthResult.success(sessionToken, account.getCustomerId());
    }

    public boolean validateSession(String sessionToken) {
        if (sessionToken == null || sessionToken.isBlank()) {
            return false;
        }
        AuthSession session = activeSessions.get(sessionToken);
        if (session == null) {
            return false;
        }
        if (session.isExpired()) {
            activeSessions.remove(sessionToken);
            return false;
        }
        return true;
    }

    public void logout(String sessionToken) {
        if (sessionToken != null) {
            activeSessions.remove(sessionToken);
        }
    }

    public AuthSession getSession(String sessionToken) {
        return activeSessions.get(sessionToken);
    }

    private String generateSessionToken() {
        return UUID.randomUUID().toString();
    }

    public int getActiveSessionCount() {
        return activeSessions.size();
    }

    public void cleanExpiredSessions() {
        LocalDateTime now = LocalDateTime.now();
        activeSessions.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }

    public record AuthSession(
        String token,
        Long accountId,
        String accountNumber,
        LocalDateTime createdAt,
        LocalDateTime expiresAt
    ) {
        public boolean isExpired() {
            return LocalDateTime.now().isAfter(expiresAt);
        }
    }

    public record AuthResult(
        boolean success,
        String message,
        String sessionToken,
        Long customerId
    ) {
        public static AuthResult success(String sessionToken, Long customerId) {
            return new AuthResult(true, "Autenticación exitosa", sessionToken, customerId);
        }

        public static AuthResult failure(String message) {
            return new AuthResult(false, message, null, null);
        }
    }
}