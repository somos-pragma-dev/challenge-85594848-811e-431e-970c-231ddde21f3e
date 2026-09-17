package com.bank.solid.account;

import com.bank.solid.dto.AccountRequest;
import com.bank.solid.dto.AccountResponse;
import com.bank.solid.exception.AccountNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse createAccount(AccountRequest request) {
        if (accountRepository.existsByAccountNumber(request.accountNumber())) {
            throw new IllegalArgumentException("Ya existe una cuenta con el número: " + request.accountNumber());
        }

        Account account = new Account(
            request.accountNumber(),
            request.customerId(),
            request.balance(),
            request.accountType()
        );

        Account saved = accountRepository.save(account);
        logger.info("Cuenta creada exitosamente: {}", saved.getAccountNumber());
        return mapToResponse(saved);
    }

    public AccountResponse getAccount(Long id) {
        Account account = findAccountById(id);
        return mapToResponse(account);
    }

    public AccountResponse updateAccount(Long id, AccountRequest request) {
        Account account = findAccountById(id);

        if (request.balance() != null) {
            account.setBalance(request.balance());
        }
        if (request.accountType() != null) {
            account.setAccountType(request.accountType());
        }

        Account updated = accountRepository.save(account);
        logger.info("Cuenta actualizada: {}", updated.getAccountNumber());
        return mapToResponse(updated);
    }

    public AccountResponse deactivateAccount(Long id) {
        Account account = findAccountById(id);
        account.setActive(false);
        Account saved = accountRepository.save(account);
        logger.info("Cuenta desactivada: {}", saved.getAccountNumber());
        return mapToResponse(saved);
    }

    public AccountResponse activateAccount(Long id) {
        Account account = findAccountById(id);
        account.setActive(true);
        Account saved = accountRepository.save(account);
        logger.info("Cuenta activada: {}", saved.getAccountNumber());
        return mapToResponse(saved);
    }

    public Optional<AccountResponse> findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
            .map(this::mapToResponse);
    }

    public List<AccountResponse> findByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId).stream()
            .map(this::mapToResponse)
            .toList();
    }

    public List<AccountResponse> findAccountsWithBalanceAbove(BigDecimal minBalance) {
        return accountRepository.findAccountsWithBalanceAbove(minBalance).stream()
            .map(this::mapToResponse)
            .toList();
    }

    public List<AccountResponse> findByAccountType(Account.AccountType accountType) {
        return accountRepository.findByAccountType(accountType).stream()
            .map(this::mapToResponse)
            .toList();
    }

    public List<AccountResponse> findInactiveAccounts() {
        return accountRepository.findByActiveFalse().stream()
            .map(this::mapToResponse)
            .toList();
    }

    public int countActiveAccountsByCustomer(Long customerId) {
        return accountRepository.countByCustomerIdAndActiveTrue(customerId);
    }

    public AccountResponse getAccountByNumber(String accountNumber) {
        return findByAccountNumber(accountNumber)
            .orElseThrow(() -> new AccountNotFoundException(accountNumber, true));
    }

    public List<AccountResponse> getAccountsByCustomerId(Long customerId) {
        return findByCustomerId(customerId);
    }

    public List<AccountResponse> getAccountsWithBalanceAbove(BigDecimal minBalance) {
        return findAccountsWithBalanceAbove(minBalance);
    }

    private Account findAccountById(Long id) {
        return accountRepository.findById(id)
            .orElseThrow(() -> new AccountNotFoundException(id));
    }

    private AccountResponse fromEntity(Account account) {
        return mapToResponse(account);
    }

    private AccountResponse mapToResponse(Account account) {
        return new AccountResponse(
            account.getId(),
            account.getAccountNumber(),
            account.getCustomerId(),
            account.getBalance(),
            account.getAccountType(),
            account.isActive(),
            account.getCreatedAt(),
            account.getUpdatedAt()
        );
    }
}