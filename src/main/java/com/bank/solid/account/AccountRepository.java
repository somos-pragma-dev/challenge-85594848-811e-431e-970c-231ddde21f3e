package com.bank.solid.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio para operaciones de persistencia de cuentas bancarias.
 * Extiende JpaRepository para heredar operaciones CRUD básicas.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> findByCustomerId(Long customerId);

    @Query("SELECT a FROM Account a WHERE a.balance >= :minBalance")
    List<Account> findAccountsWithBalanceAbove(@Param("minBalance") BigDecimal minBalance);

    boolean existsByAccountNumber(String accountNumber);

    List<Account> findByAccountType(Account.AccountType accountType);

    List<Account> findByActiveFalse();

    int countByCustomerIdAndActiveTrue(Long customerId);
}