# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Fundamentos de los principios SOLID en el desarrollo de software**.

| | |
|---|---|
| Tema | SOLID principles |
| Nivel | junior-l1 |
| Chapter | Generico |
| Especialidad | Inferido del contexto |
| Stack | Java / Spring Boot 3.4 |
| Patron arquitectonico | capas estándar (controller-service-repository) |
| Tiempo estimado | 2 horas |

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `el comando de build o arranque canonico del stack elegido` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `el comando de build o arranque canonico del stack elegido` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Introducción a los principios SOLID**: Resumen de los principios SOLID con ejemplos y soluciones.
- **Fase 2 — Aplicación de los principios SOLID en un sistema de gestión de cuentas**: Diagrama de clases que muestra la aplicación de los principios SOLID en el sistema de gestión de cuentas.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Boilerplate del stack (1)

Sin esto el proyecto no compila ni arranca. **Es tu trabajo crearlo**, y no toca nada de lo pedagogico: es andamiaje del stack.

- [ ] **Punto de entrada del stack elegido** — Sin un punto de entrada reconocible, el runtime no tiene por donde arrancar la aplicacion.

### 2. Referencias colgando (15)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/bank/solid/dto/AccountResponse.java` — `Account`
      Account se usa en el cuerpo del archivo pero no esta importado. El proyecto lo declara en com.bank.solid.account.Account.
- [ ] `src/main/java/com/bank/solid/dto/AccountResponse.java` — `AccountType`
      AccountType se usa en el cuerpo del archivo pero no esta importado. El proyecto lo declara en com.bank.solid.account.AccountType.
- [ ] `src/main/java/com/bank/solid/dto/AccountResponse.java` — `AccountResponse.createdAt`
      Se invoca `createdAt` sobre `AccountResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/solid/dto/AccountResponse.java` — `AccountResponse.updatedAt`
      Se invoca `updatedAt` sobre `AccountResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/solid/account/AccountService.java` — `AccountRepository.save`
      Se invoca `save` sobre `AccountRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/solid/account/AccountService.java` — `AccountRepository.findById`
      Se invoca `findById` sobre `AccountRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/solid/auth/AuthService.java` — `Account.getPin`
      Se invoca `getPin` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/solid/auth/AuthService.java` — `AuthSession.isExpired`
      Se invoca `isExpired` sobre `AuthSession`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/solid/notification/EmailNotificationService.java` — `NotificationRequest.recipient`
      Se invoca `recipient` sobre `NotificationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/solid/notification/EmailNotificationService.java` — `NotificationRequest.subject`
      Se invoca `subject` sobre `NotificationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/solid/notification/EmailNotificationService.java` — `NotificationRequest.message`
      Se invoca `message` sobre `NotificationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/solid/notification/EmailNotificationService.java` — `NotificationResult.success`
      Se invoca `success` sobre `NotificationResult`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bank/solid/notification/EmailNotificationService.java` — `NotificationResult.message`
      Se invoca `message` sobre `NotificationResult`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/solid/account/AccountServiceTest.java` — `AccountRepository.save`
      Se invoca `save` sobre `AccountRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bank/solid/account/AccountServiceTest.java` — `AccountRepository.findById`
      Se invoca `findById` sobre `AccountRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (18)

- `pom.xml`
- `src/main/java/com/bank/solid/SolidApplication.java`
- `src/main/resources/application.properties`
- `src/main/java/com/bank/solid/account/AccountRepository.java`
- `src/main/java/com/bank/solid/dto/AccountRequest.java`
- `src/main/java/com/bank/solid/dto/AccountResponse.java`
- `src/main/java/com/bank/solid/account/Account.java`
- `src/main/java/com/bank/solid/account/AccountService.java`
- `src/main/java/com/bank/solid/account/AccountController.java`
- `src/main/java/com/bank/solid/auth/AuthService.java`
- `src/main/java/com/bank/solid/notification/NotificationService.java`
- `src/main/java/com/bank/solid/notification/EmailNotificationService.java`
- `src/main/java/com/bank/solid/notification/SmsNotificationService.java`
- `src/main/java/com/bank/solid/exception/AccountNotFoundException.java`
- `src/main/java/com/bank/solid/exception/GlobalExceptionHandler.java`
- `src/test/java/com/bank/solid/account/AccountServiceTest.java`
- `src/test/java/com/bank/solid/notification/NotificationServiceTest.java`
- `src/main/java/com/bank/solid/notification/NotificationServiceImpl.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/bank/solid/account`
- `src/main/java/com/bank/solid/auth`
- `src/main/java/com/bank/solid/notification`
- `src/main/java/com/bank/solid/exception`
- `src/main/java/com/bank/solid/dto`
- `src/main/resources`
- `src/test/java/com/bank/solid`

## Verificacion

```bash
el comando de build o arranque canonico del stack elegido
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar (controller-service-repository)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Brecha que el reto ataca: Learn SOLID principles applied to Spring Boot

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
