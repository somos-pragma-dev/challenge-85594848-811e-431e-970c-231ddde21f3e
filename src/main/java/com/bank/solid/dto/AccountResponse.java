package com.bank.solid.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public record AccountResponse(
    Long id,
    String accountNumber,
    Long customerId,
    BigDecimal balance,
    com.bank.solid.account.Account.AccountType accountType,
    boolean active,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

    public static AccountResponse success(AccountResponse response) {
        return response;
    }

    public static AccountResponse inactive(AccountResponse response) {
        return new AccountResponse(
            response.id(),
            response.accountNumber(),
            response.customerId(),
            response.balance(),
            response.accountType(),
            false,
            response.createdAt(),
            response.updatedAt()
        );
    }

    public boolean hasBalance() {
        return balance != null && balance.compareTo(BigDecimal.ZERO) > 0;
    }

    public String getFormattedBalance() {
        return balance != null ? balance.toString() : "0.00";
    }

    public Long id() {
        return id;
    }

    public String accountNumber() {
        return accountNumber;
    }

    public Long customerId() {
        return customerId;
    }

    public BigDecimal balance() {
        return balance;
    }

    public com.bank.solid.account.Account.AccountType accountType() {
        return accountType;
    }

    public boolean active() {
        return active;
    }
}