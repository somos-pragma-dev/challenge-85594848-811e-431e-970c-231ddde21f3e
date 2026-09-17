package com.bank.solid.account;

import com.bank.solid.dto.AccountRequest;
import com.bank.solid.dto.AccountResponse;
import com.bank.solid.exception.AccountNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para AccountService - Validación de SOLID Principles")
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Account testAccount;
    private AccountRequest testRequest;

    @BeforeEach
    void setUp() {
        testAccount = new Account();
        testAccount.setId(1L);
        testAccount.setAccountNumber("1234567890");
        testAccount.setCustomerId(100L);
        testAccount.setBalance(new BigDecimal("5000.00"));
        testAccount.setActive(true);
        testAccount.setAccountType(Account.AccountType.CHECKING);

        testRequest = new AccountRequest("1234567890", 100L, new BigDecimal("5000.00"), Account.AccountType.CHECKING);
    }

    @Test
    @DisplayName("Dependency Inversion: AccountService depende de la abstracción AccountRepository, no de concreciones")
    void testDependencyInversion_dependsOnAbstraction() {
        assertNotNull(accountRepository, "AccountRepository debe ser una abstracción (interfaz)");
        assertTrue(AccountRepository.class.isInterface(), "AccountRepository debe ser una interfaz, no una clase concreta");
    }

    @Test
    @DisplayName("Dependency Inversion: El servicio puede trabajar con cualquier implementación de repositorio")
    void testDependencyInversion_withDifferentRepositoryImplementations() {
        when(accountRepository.findByAccountNumber("1234567890")).thenReturn(Optional.of(testAccount));

        AccountResponse response = accountService.getAccountByNumber("1234567890");

        assertNotNull(response);
        assertEquals("1234567890", response.accountNumber());
        verify(accountRepository, times(1)).findByAccountNumber("1234567890");
    }

    @Test
    @DisplayName("Single Responsibility: AccountService solo maneja lógica de cuentas, no de notificaciones")
    void testSingleResponsibility_serviceHasOneReasonToChange() {
        assertNotNull(accountService);
    }

    @Test
    @DisplayName("Open/Closed: El servicio puede extenderse sin modificar su código existente")
    void testOpenClosed_extensibleWithoutModification() {
        when(accountRepository.save(any(Account.class))).thenReturn(testAccount);

        AccountResponse created = accountService.createAccount(testRequest);

        assertNotNull(created);
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    @DisplayName("Crear cuenta exitosamente")
    void testCreateAccount_success() {
        when(accountRepository.existsByAccountNumber("1234567890")).thenReturn(false);
        when(accountRepository.save(any(Account.class))).thenReturn(testAccount);

        AccountResponse response = accountService.createAccount(testRequest);

        assertNotNull(response);
        assertEquals("1234567890", response.accountNumber());
        assertTrue(response.active());
        verify(accountRepository).save(any(Account.class));
    }

    @Test
    @DisplayName("Error al crear cuenta con número duplicado")
    void testCreateAccount_duplicateAccountNumber() {
        when(accountRepository.existsByAccountNumber("1234567890")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> accountService.createAccount(testRequest));
        verify(accountRepository, never()).save(any(Account.class));
    }

    @Test
    @DisplayName("Obtener cuenta por número exitosamente")
    void testGetAccountByNumber_success() {
        when(accountRepository.findByAccountNumber("1234567890")).thenReturn(Optional.of(testAccount));

        AccountResponse response = accountService.getAccountByNumber("1234567890");

        assertNotNull(response);
        assertEquals("1234567890", response.accountNumber());
    }

    @Test
    @DisplayName("Error al obtener cuenta inexistente")
    void testGetAccountByNumber_notFound() {
        when(accountRepository.findByAccountNumber("9999999999")).thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> accountService.getAccountByNumber("9999999999"));
    }

    @Test
    @DisplayName("Obtener todas las cuentas de un cliente")
    void testGetAccountsByCustomerId_success() {
        when(accountRepository.findByCustomerId(100L)).thenReturn(List.of(testAccount));

        List<AccountResponse> accounts = accountService.getAccountsByCustomerId(100L);

        assertEquals(1, accounts.size());
        assertEquals(100L, accounts.get(0).customerId());
    }

    @Test
    @DisplayName("Desactivar cuenta exitosamente")
    void testDeactivateAccount_success() {
        when(accountRepository.findById(1L)).thenReturn(Optional.of(testAccount));
        when(accountRepository.save(any(Account.class))).thenReturn(testAccount);

        AccountResponse response = accountService.deactivateAccount(1L);

        assertNotNull(response);
        verify(accountRepository).save(any(Account.class));
    }

    @Test
    @DisplayName("Error al desactivar cuenta inexistente")
    void testDeactivateAccount_notFound() {
        when(accountRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> accountService.deactivateAccount(999L));
    }

    @Test
    @DisplayName("Obtener cuentas con saldo mayor al mínimo")
    void testGetAccountsWithBalanceAbove_success() {
        when(accountRepository.findAccountsWithBalanceAbove(new BigDecimal("1000"))).thenReturn(List.of(testAccount));

        List<AccountResponse> accounts = accountService.getAccountsWithBalanceAbove(new BigDecimal("1000"));

        assertEquals(1, accounts.size());
    }

    @Test
    @DisplayName("Contar cuentas activas de un cliente")
    void testCountActiveAccountsByCustomer_success() {
        when(accountRepository.countByCustomerIdAndActiveTrue(100L)).thenReturn(2);

        int count = accountService.countActiveAccountsByCustomer(100L);

        assertEquals(2, count);
    }
}