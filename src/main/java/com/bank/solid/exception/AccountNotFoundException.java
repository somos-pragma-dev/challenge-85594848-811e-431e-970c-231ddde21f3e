package com.bank.solid.exception;

public class AccountNotFoundException extends RuntimeException {

    private final String accountNumber;
    private final Long customerId;

    public AccountNotFoundException(String message) {
        super(message);
        this.accountNumber = null;
        this.customerId = null;
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.accountNumber = null;
        this.customerId = null;
    }

    public AccountNotFoundException(String accountNumber, boolean byAccountNumber) {
        super(String.format("Cuenta con número '%s' no encontrada", accountNumber));
        this.accountNumber = accountNumber;
        this.customerId = null;
    }

    public AccountNotFoundException(Long customerId) {
        super(String.format("Cuenta para el cliente con ID '%d' no encontrada", customerId));
        this.accountNumber = null;
        this.customerId = customerId;
    }

    public AccountNotFoundException(String message, String accountNumber, Long customerId) {
        super(message);
        this.accountNumber = accountNumber;
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public boolean hasAccountNumber() {
        return accountNumber != null && !accountNumber.isBlank();
    }

    public boolean hasCustomerId() {
        return customerId != null;
    }
}