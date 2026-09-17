package com.bank.solid.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

/**
 * DTO para recibir datos de creación o actualización de cuentas.
 * Aplica el principio de Separación de Responsabilidades (SRP) al mantener
 * la responsabilidad exclusiva de representar los datos de entrada de la capa de presentación.
 * No contiene lógica de negocio ni conocimiento de la capa de dominio.
 */
public record AccountRequest(

    @NotBlank(message = "El número de cuenta es obligatorio")
    @Size(min = 10, max = 20, message = "El número de cuenta debe tener entre 10 y 20 caracteres")
    String accountNumber,

    @NotNull(message = "El ID del cliente es obligatorio")
    @Positive(message = "El ID del cliente debe ser positivo")
    Long customerId,

    @NotNull(message = "El tipo de cuenta es obligatorio")
    @Pattern(regexp = "^(AHORRO|CORRIENTE|PLAZO_FIJO)$", 
             message = "El tipo de cuenta debe ser AHORRO, CORRIENTE o PLAZO_FIJO")
    String accountType,

    @NotNull(message = "El saldo inicial es obligatorio")
    @DecimalMin(value = "0.0", inclusive = true, message = "El saldo no puede ser negativo")
    @Digits(integer = 15, fraction = 2, message = "El saldo debe tener máximo 15 dígitos enteros y 2 decimales")
    BigDecimal initialBalance,

    @NotBlank(message = "El nombre del titular es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre del titular debe tener entre 3 y 100 caracteres")
    String holderName,

    @Email(message = "El correo electrónico debe tener un formato válido")
    String email,

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "El teléfono debe tener entre 10 y 15 dígitos")
    String phone
) {
    /**
     * Constructor compacto que permite validación adicional si es necesario.
     */
    public AccountRequest {
        if (initialBalance != null && initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
    }
}