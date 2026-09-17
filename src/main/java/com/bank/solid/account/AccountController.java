package com.bank.solid.account;

import com.bank.solid.dto.AccountRequest;
import com.bank.solid.dto.AccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST que expone los endpoints para la gestión de cuentas bancarias.
 * Implementa la capa de presentación del patrón arquitectónico MVC, recibiendo
 * las peticiones HTTP y devolviendo las respuestas apropiadas.
 * Este controlador aplica el principio de separación de responsabilidades al
 * delegar toda la lógica de negocio al servicio correspondiente.
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    /**
     * Constructor con inyección de dependencias del servicio de cuentas.
     * Spring Boot inyecta automáticamente el bean de AccountService.
     * @param accountService Servicio que contiene la lógica de negocio de cuentas
     */
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Crea una nueva cuenta bancaria en el sistema.
     * Endpoint: POST /api/accounts
     * @param request DTO con los datos de la cuenta a crear
     * @return ResponseEntity con la cuenta creada y código HTTP 201 (Created)
     */
    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest request) {
        AccountResponse response = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Recupera una cuenta bancaria por su identificador único.
     * Endpoint: GET /api/accounts/{id}
     * @param id Identificador de la cuenta
     * @return ResponseEntity con los datos de la cuenta o 404 si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable Long id) {
        AccountResponse response = accountService.getAccount(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Actualiza los datos de una cuenta existente.
     * Endpoint: PUT /api/accounts/{id}
     * @param id Identificador de la cuenta a actualizar
     * @param request DTO con los nuevos datos
     * @return ResponseEntity con los datos actualizados
     */
    @PutMapping("/{id}")
    public ResponseEntity<AccountResponse> updateAccount(
            @PathVariable Long id,
            @RequestBody AccountRequest request) {
        AccountResponse response = accountService.updateAccount(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * Desactiva una cuenta bancaria, impidiendo operaciones futuras.
     * Endpoint: DELETE /api/accounts/{id}
     * @param id Identificador de la cuenta a desactivar
     * @return ResponseEntity con los datos de la cuenta desactivada
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<AccountResponse> deactivateAccount(@PathVariable Long id) {
        AccountResponse response = accountService.deactivateAccount(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Reactiva una cuenta bancaria previamente desactivada.
     * Endpoint: PUT /api/accounts/{id}/activate
     * @param id Identificador de la cuenta a reactivar
     * @return ResponseEntity con los datos de la cuenta reactivada
     */
    @PutMapping("/{id}/activate")
    public ResponseEntity<AccountResponse> activateAccount(@PathVariable Long id) {
        AccountResponse response = accountService.activateAccount(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Busca una cuenta por su número único.
     * Endpoint: GET /api/accounts/number/{accountNumber}
     * @param accountNumber Número de cuenta a buscar
     * @return ResponseEntity con los datos de la cuenta o 404 si no existe
     */
    @GetMapping("/number/{accountNumber}")
    public ResponseEntity<AccountResponse> findByAccountNumber(@PathVariable String accountNumber) {
        return accountService.findByAccountNumber(accountNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Recupera todas las cuentas de un cliente específico.
     * Endpoint: GET /api/accounts/customer/{customerId}
     * @param customerId Identificador del cliente
     * @return ResponseEntity con la lista de cuentas del cliente
     */
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<AccountResponse>> findByCustomerId(@PathVariable Long customerId) {
        List<AccountResponse> accounts = accountService.findByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }

    /**
     * Busca cuentas con saldo superior a un monto mínimo.
     * Endpoint: GET /api/accounts/balance-above?minBalance=1000
     * @param minBalance Saldo mínimo a filtrar
     * @return ResponseEntity con la lista de cuentas que cumplen el criterio
     */
    @GetMapping("/balance-above")
    public ResponseEntity<List<AccountResponse>> findAccountsWithBalanceAbove(
            @RequestParam java.math.BigDecimal minBalance) {
        List<AccountResponse> accounts = accountService.findAccountsWithBalanceAbove(minBalance);
        return ResponseEntity.ok(accounts);
    }

    /**
     * Busca cuentas por tipo específico.
     * Endpoint: GET /api/accounts/type/{accountType}
     * @param accountType Tipo de cuenta a buscar (CHECKING, SAVINGS, BUSINESS)
     * @return ResponseEntity con la lista de cuentas del tipo especificado
     */
    @GetMapping("/type/{accountType}")
    public ResponseEntity<List<AccountResponse>> findByAccountType(@PathVariable Account.AccountType accountType) {
        List<AccountResponse> accounts = accountService.findByAccountType(accountType);
        return ResponseEntity.ok(accounts);
    }

    /**
     * Recupera todas las cuentas inactivas del sistema.
     * Endpoint: GET /api/accounts/inactive
     * @return ResponseEntity con la lista de cuentas inactivas
     */
    @GetMapping("/inactive")
    public ResponseEntity<List<AccountResponse>> findInactiveAccounts() {
        List<AccountResponse> accounts = accountService.findInactiveAccounts();
        return ResponseEntity.ok(accounts);
    }

    /**
     * Cuenta las cuentas activas de un cliente específico.
     * Endpoint: GET /api/accounts/customer/{customerId}/count
     * @param customerId Identificador del cliente
     * @return ResponseEntity con el número de cuentas activas
     */
    @GetMapping("/customer/{customerId}/count")
    public ResponseEntity<Integer> countActiveAccountsByCustomer(@PathVariable Long customerId) {
        int count = accountService.countActiveAccountsByCustomer(customerId);
        return ResponseEntity.ok(count);
    }
}