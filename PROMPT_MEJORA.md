# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Boilerplate del stack que falta

Sin esto no compila ni arranca. Es andamiaje, no toca nada de lo pedagogico:

- **Punto de entrada del stack elegido** — Sin un punto de entrada reconocible, el runtime no tiene por donde arrancar la aplicacion.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/bank/solid/dto/AccountResponse.java` — `Account`: Account se usa en el cuerpo del archivo pero no esta importado. El proyecto lo declara en com.bank.solid.account.Account.
- `src/main/java/com/bank/solid/dto/AccountResponse.java` — `AccountType`: AccountType se usa en el cuerpo del archivo pero no esta importado. El proyecto lo declara en com.bank.solid.account.AccountType.
- `src/main/java/com/bank/solid/dto/AccountResponse.java` — `AccountResponse.createdAt`: Se invoca `createdAt` sobre `AccountResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/solid/dto/AccountResponse.java` — `AccountResponse.updatedAt`: Se invoca `updatedAt` sobre `AccountResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/solid/account/AccountService.java` — `AccountRepository.save`: Se invoca `save` sobre `AccountRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/solid/account/AccountService.java` — `AccountRepository.findById`: Se invoca `findById` sobre `AccountRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/solid/auth/AuthService.java` — `Account.getPin`: Se invoca `getPin` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/solid/auth/AuthService.java` — `AuthSession.isExpired`: Se invoca `isExpired` sobre `AuthSession`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/solid/notification/EmailNotificationService.java` — `NotificationRequest.recipient`: Se invoca `recipient` sobre `NotificationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/solid/notification/EmailNotificationService.java` — `NotificationRequest.subject`: Se invoca `subject` sobre `NotificationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/solid/notification/EmailNotificationService.java` — `NotificationRequest.message`: Se invoca `message` sobre `NotificationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/solid/notification/EmailNotificationService.java` — `NotificationResult.success`: Se invoca `success` sobre `NotificationResult`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/solid/notification/EmailNotificationService.java` — `NotificationResult.message`: Se invoca `message` sobre `NotificationResult`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/solid/account/AccountServiceTest.java` — `AccountRepository.save`: Se invoca `save` sobre `AccountRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/solid/account/AccountServiceTest.java` — `AccountRepository.findById`: Se invoca `findById` sobre `AccountRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
el comando de build o arranque canonico del stack elegido
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Learn SOLID principles applied to Spring Boot

### Reto
- Tema: SOLID principles
- Seniority: junior-l1
- Tipo: theoretical
- Título: Fundamentos de los principios SOLID en el desarrollo de software
- Tiempo estimado: 2 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Introducción a los principios SOLID — objetivo: Comprender los cinco principios SOLID y su importancia en el desarrollo de software. — entregable (NO resolver): Resumen de los principios SOLID con ejemplos y soluciones.
- Fase 2: Aplicación de los principios SOLID en un sistema de gestión de cuentas — objetivo: Aplicar los principios SOLID en un sistema de gestión de cuentas bancarias. — entregable (NO resolver): Diagrama de clases que muestra la aplicación de los principios SOLID en el sistema de gestión de cuentas.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>
    
    <groupId>com.bank</groupId>
    <artifactId>solid</artifactId>
    <version>1.0.0</version>
    <name>solid</name>
    <description>Sistema de gestión de cuentas bancarias aplicando principios SOLID</description>
    
    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <dependencies>
        <!-- Spring Boot Web Starter para crear servicios REST -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <!-- Spring Boot Data JPA para persistencia con JPA/Hibernate -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <!-- Base de datos H2 en memoria para desarrollo y testing -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        
        <!-- Dependencias de testing con JUnit 5, Mockito y Spring Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        
        <!-- Lombok para reducir código boilerplate en entidades y DTOs -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <!-- Plugin de Spring Boot para empaquetar la aplicación como JAR ejecutable -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <!-- Excluir Lombok del JAR final ya que es provided en runtime -->
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
            
            <!-- Plugin de compilador configurado para Java 21 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
                <configuration>
                    <source>21</source>
                    <target>21</target>
                    <compilerArgs>
                        <arg>--enable-preview</arg>
                    </compilerArgs>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/bank/solid/SolidApplication.java ===
package com.bank.solid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Punto de entrada principal de la aplicación Spring Boot.
 * Esta clase inicia el contexto de Spring y configura los componentes base del sistema.
 * 
 * La aplicación implementa un sistema de gestión de cuentas bancarias que sigue
 * los principios SOLID para demostrar buen diseño de software en un contexto bancario.
 * 
 * Componentes principales del sistema:
 * - AccountController: Maneja las solicitudes HTTP relacionadas con cuentas
 * - AccountService: Lógica de negocio para operaciones de cuentas
 * - AuthService: Sistema de autenticación de usuarios
 * - NotificationService: Motor de notificaciones (email y SMS)
 * - Exception handling centralizado para respuestas consistentes
 */
@SpringBootApplication
public class SolidApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     * Spring Boot autoconfigura el servidor embebido, el contexto de persistencia
     * y todos los beans registrados en el classpath.
     * 
     * @param args Argumentos de línea de comandos pasados al inicio
     */
    public static void main(String[] args) {
        SpringApplication.run(SolidApplication.class, args);
    }
    
    /**
     * Configuración de CORS para permitir solicitudes desde aplicaciones frontend.
     * Esta configuración habilita todos los métodos HTTP y headers comunes
     * para facilitar el desarrollo de interfaces de usuario separadas.
     * 
     * En producción, esta configuración debe restringirse a los dominios conocidos.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                        .allowedHeaders("*")
                        .maxAge(3600);
            }
        };
    }
}

// === ARCHIVO: src/main/resources/application.properties ===
# Configuración principal de la aplicación Spring Boot
# Sistema de gestión de cuentas bancarias - Principios SOLID

# Puerto donde escuchará el servidor embebido
server.port=8080

# Configuración de la aplicación
spring.application.name=solid

# Configuración de la base de datos H2 en memoria
# H2 es una base de datos SQL embebida ideal para desarrollo y testing
spring.datasource.url=jdbc:h2:mem:bankdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuración del pool de conexiones HikariCP
# HikariCP es el pool de conexiones por defecto en Spring Boot
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.idle-timeout=600000
spring.datasource.hikari.max-lifetime=1800000

# Configuración de JPA/Hibernate
# Hibernate es el ORM usado por Spring Data JPA para mapear entidades a tablas
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Configuración de logging para facilitar debugging
# Nivel INFO para ver requests HTTP, WARN para advertencias, ERROR para fallos
logging.level.root=INFO
logging.level.com.bank.solid=DEBUG
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# Configuración de formato de logs
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n

# Configuración de H2 Console para desarrollo
# H2 provee una consola web para inspeccionar la base de datos
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.web-allow-others=true

# Configuración de características de Spring Boot 3.x
spring.main.banner-mode=console
spring.main.log-startup-info=true

# Configuración de manejo de parámetros.unknown
spring.mvc.throw-exception-if-no-handler-found=true
spring.web.resources.add-mappings=true


// === ARCHIVO: src/main/java/com/bank/solid/account/AccountRepository.java ===
package com.bank.solid.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz de repositorio para operaciones de persistencia de cuentas.
 * Implementa el patrón Repository siguiendo el principio de Inversión de Dependencias (DIP).
 * Al definir una abstracción (interfaz) para el acceso a datos, las capas superiores
 * dependen de esta abstracción en lugar de implementaciones concretas.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Busca una cuenta por su número único de cuenta.
     * Spring Data JPA deriva automáticamente la consulta del nombre del método.
     */
    Optional<Account> findByAccountNumber(String accountNumber);

    /**
     * Busca todas las cuentas asociadas a un cliente específico.
     */
    List<Account> findByCustomerId(Long customerId);

    /**
     * Busca cuentas con saldo mayor al monto especificado.
     * Utiliza JPQL para una consulta más específica.
     */
    @Query("SELECT a FROM Account a WHERE a.balance > :minBalance")
    List<Account> findAccountsWithBalanceAbove(@Param("minBalance") BigDecimal minBalance);

    /**
     * Verifica si existe una cuenta con el número de cuenta proporcionado.
     */
    boolean existsByAccountNumber(String accountNumber);

    /**
     * Busca cuentas por tipo (AHORRO, CORRIENTE, etc.).
     */
    List<Account> findByAccountType(Account.AccountType accountType);

    /**
     * Busca cuentas que están inactivas.
     */
    List<Account> findByActiveFalse();

    /**
     * Cuenta el número de cuentas activas de un cliente.
     */
    int countByCustomerIdAndActiveTrue(Long customerId);
}

// === ARCHIVO: src/main/java/com/bank/solid/dto/AccountRequest.java ===
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

// === ARCHIVO: src/main/java/com/bank/solid/dto/AccountResponse.java ===
package com.bank.solid.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO para enviar datos de cuentas a los clientes.
 * Aplica el principio de Responsabilidad Única (SRP) al representar exclusivamente
 * los datos de salida de la capa de presentación. Mantiene una separación clara
 * entre la entidad de dominio (Account) y la representación que se expone al exterior.
 * Utiliza un record de Java 21 para inmutabilidad y concisión.
 */
public record AccountResponse(

    Long id,

    String accountNumber,

    Long customerId,

    String accountType,

    BigDecimal balance,

    String holderName,

    String email,

    String phone,

    boolean active,

    LocalDateTime createdAt,

    LocalDateTime updatedAt,

    String status
) {
    /**
     * Factory method para crear una respuesta exitosa.
     */
    public static AccountResponse success(AccountResponse response) {
        return response;
    }

    /**
     * Factory method para crear una respuesta con estado inactivo.
     */
    public static AccountResponse inactive(AccountResponse response) {
        return new AccountResponse(
            response.id(),
            response.accountNumber(),
            response.customerId(),
            response.accountType(),
            response.balance(),
            response.holderName(),
            response.email(),
            response.phone(),
            false,
            response.createdAt(),
            response.updatedAt(),
            "INACTIVA"
        );
    }

    /**
     * Verifica si la cuenta tiene saldo disponible.
     */
    public boolean hasBalance() {
        return balance != null && balance.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * Retorna el saldo formateado como string con símbolo de moneda.
     */
    public String getFormattedBalance() {
        return balance != null ? String.format("$%.2f", balance) : "$0.00";
    }
}

// === ARCHIVO: src/main/java/com/bank/solid/account/Account.java ===
package com.bank.solid.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad JPA que representa una cuenta bancaria en el sistema.
 * Esta clase aplica principios de diseño orientado a objetos y sirve como
 * modelo de dominio para la gestión de cuentas bancarias.
 */
@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    /**
     * Identificador único de la cuenta generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Número único de cuenta bancaria. Este campo debe ser único en el sistema
     * y se utiliza para identificar cuentas de forma precisa en todas las operaciones.
     */
    @Column(name = "account_number", unique = true, nullable = false, length = 20)
    private String accountNumber;

    /**
     * Identificador del cliente titular de la cuenta. Relación con el sistema
     * de gestión de clientes del banco.
     */
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    /**
     * Saldo actual de la cuenta bancaria. Se utiliza BigDecimal para garantizar
     * precisión en cálculos monetarios, evitando problemas de redondeo con tipos flotantes.
     */
    @Column(name = "balance", nullable = false, precision = 19, scale = 4)
    private BigDecimal balance = BigDecimal.ZERO;

    /**
     * Tipo de cuenta bancaria que determina las operaciones permitidas y políticas aplicables.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false, length = 20)
    private AccountType accountType;

    /**
     * Indica si la cuenta está activa en el sistema. Las cuentas inactivas no pueden
     * realizar operaciones hasta ser reactivadas por un gestor autorizado.
     */
    @Column(name = "active", nullable = false)
    private boolean active = true;

    /**
     * Fecha y hora de creación del registro de cuenta en el sistema.
     * Se establece automáticamente al momento de la creación.
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Fecha y hora de la última modificación realizada en el registro de cuenta.
     * Se actualiza automáticamente cada vez que se persiste un cambio.
     */
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    /**
     * Tipos de cuenta bancaria soportados por el sistema.
     * Cada tipo define políticas y límites específicos para las operaciones.
     */
    public enum AccountType {
        /**
         * Cuenta corriente con acceso a overdraft y operaciones frecuentes.
         */
        CHECKING,
        /**
         * Cuenta de ahorro con intereses acumulativos y retiros limitados.
         */
        SAVINGS,
        /**
         * Cuenta empresarial con características específicas para negocios.
         */
        BUSINESS
    }

    /**
     * Callback de JPA que se ejecuta antes de persistir la entidad por primera vez.
     * Establece las fechas de creación y actualización inicial.
     */
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        if (this.balance == null) {
            this.balance = BigDecimal.ZERO;
        }
    }

    /**
     * Callback de JPA que se ejecuta antes de actualizar la entidad existente.
     * Actualiza automáticamente la marca de tiempo de modificación.
     */
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Método de dominio que verifica si la cuenta tiene saldo disponible para operaciones.
     * Aplica la lógica de negocio para determinar disponibilidad de fondos.
     * @return true si el saldo es mayor que cero, false en caso contrario
     */
    public boolean hasBalance() {
        return this.balance != null && this.balance.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * Método de dominio que retorna el saldo formateado para presentación al usuario.
     * @return Representación en string del saldo con formato monetario
     */
    public String getFormattedBalance() {
        if (this.balance == null) {
            return "$0.00";
        }
        return String.format("$%,.2f", this.balance);
    }

    /**
     * Método de dominio para depositar funds en la cuenta.
     * Valida el monto antes de realizar la operación.
     * @param amount Cantidad a depositar, debe ser mayor que cero
     * @throws IllegalArgumentException si el monto es nulo o menor o igual a cero
     */
    public void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto del depósito debe ser mayor que cero");
        }
        if (!this.active) {
            throw new IllegalStateException("No se puede depositar en una cuenta inactiva");
        }
        this.balance = this.balance.add(amount);
    }

    /**
     * Método de dominio para retirar funds de la cuenta.
     * Verifica disponibilidad de saldo antes de permitir la operación.
     * @param amount Cantidad a retirar, debe ser mayor que cero y menor o igual al saldo
     * @throws IllegalArgumentException si el monto es inválido
     * @throws IllegalStateException si la cuenta está inactiva o saldo insuficiente
     */
    public void withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto del retiro debe ser mayor que cero");
        }
        if (!this.active) {
            throw new IllegalStateException("No se puede retirar de una cuenta inactiva");
        }
        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Saldo insuficiente para realizar el retiro");
        }
        this.balance = this.balance.subtract(amount);
    }
}

// === ARCHIVO: src/main/java/com/bank/solid/account/AccountService.java ===
package com.bank.solid.account;

import com.bank.solid.dto.AccountRequest;
import com.bank.solid.dto.AccountResponse;
import com.bank.solid.exception.AccountNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Servicio que implementa la lógica de negocio para la gestión de cuentas bancarias.
 * Este componente aplica el Principio de Responsabilidad Única (SRP) al concentrar
 * exclusivamente en operaciones relacionadas con cuentas, separándolas de otros
 * Concerns como autenticación y notificaciones.
 */
@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    /**
     * Constructor con inyección de dependencias del repositorio de cuentas.
     * Spring Boot 3.4 permite inyección por constructor sin necesidad de @Autowired explícito.
     * @param accountRepository Repositorio para operaciones de persistencia de cuentas
     */
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Crea una nueva cuenta bancaria en el sistema.
     * Valida que el número de cuenta no exista previamente antes de persistir.
     * @param request Datos de la cuenta a crear
     * @return AccountResponse con los datos de la cuenta creada
     * @throws IllegalArgumentException si los datos de entrada son inválidos
     */
    public AccountResponse createAccount(AccountRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("La solicitud de cuenta no puede ser nula");
        }
        if (request.accountNumber() == null || request.accountNumber().isBlank()) {
            throw new IllegalArgumentException("El número de cuenta es obligatorio");
        }
        if (accountRepository.existsByAccountNumber(request.accountNumber())) {
            throw new IllegalArgumentException("Ya existe una cuenta con el número: " + request.accountNumber());
        }

        Account account = new Account();
        account.setAccountNumber(request.accountNumber());
        account.setCustomerId(request.customerId());
        account.setAccountType(request.accountType());
        account.setBalance(request.initialBalance() != null ? request.initialBalance() : BigDecimal.ZERO);
        account.setActive(true);

        Account savedAccount = accountRepository.save(account);
        return AccountResponse.success(fromEntity(savedAccount));
    }

    /**
     * Recupera una cuenta por su identificador único.
     * @param id Identificador de la cuenta
     * @return AccountResponse con los datos de la cuenta
     * @throws AccountNotFoundException si la cuenta no existe
     */
    @Transactional(readOnly = true)
    public AccountResponse getAccount(Long id) {
        Account account = findAccountById(id);
        return mapToResponse(account);
    }

    /**
     * Actualiza la información de una cuenta existente.
     * Solo permite modificar el tipo de cuenta y el estado de actividad.
     * @param id Identificador de la cuenta a actualizar
     * @param request Nuevos datos para la cuenta
     * @return AccountResponse con los datos actualizados
     * @throws AccountNotFoundException si la cuenta no existe
     */
    public AccountResponse updateAccount(Long id, AccountRequest request) {
        Account account = findAccountById(id);

        if (request.accountType() != null) {
            account.setAccountType(request.accountType());
        }

        if (request.initialBalance() != null) {
            account.setBalance(request.initialBalance());
        }

        Account updatedAccount = accountRepository.save(account);
        return mapToResponse(updatedAccount);
    }

    /**
     * Desactiva una cuenta bancaria, marcándola como inactiva.
     * Las cuentas inactivas no pueden realizar operaciones hasta ser reactivadas.
     * @param id Identificador de la cuenta a desactivar
     * @return AccountResponse con los datos de la cuenta desactivada
     * @throws AccountNotFoundException si la cuenta no existe
     */
    public AccountResponse deactivateAccount(Long id) {
        Account account = findAccountById(id);
        account.setActive(false);
        Account savedAccount = accountRepository.save(account);
        return AccountResponse.inactive(fromEntity(savedAccount));
    }

    /**
     * Reactiva una cuenta bancaria previamente desactivada.
     * @param id Identificador de la cuenta a reactivar
     * @return AccountResponse con los datos de la cuenta reactivada
     * @throws AccountNotFoundException si la cuenta no existe
     */
    public AccountResponse activateAccount(Long id) {
        Account account = findAccountById(id);
        account.setActive(true);
        Account savedAccount = accountRepository.save(account);
        return AccountResponse.success(fromEntity(savedAccount));
    }

    /**
     * Busca una cuenta por su número único de cuenta.
     * @param accountNumber Número de cuenta a buscar
     * @return Optional con la cuenta si existe, vacío si no
     */
    @Transactional(readOnly = true)
    public Optional<AccountResponse> findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(this::mapToResponse);
    }

    /**
     * Recupera todas las cuentas asociadas a un cliente específico.
     * @param customerId Identificador del cliente
     * @return Lista de AccountResponse con las cuentas del cliente
     */
    @Transactional(readOnly = true)
    public List<AccountResponse> findByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId).stream()
                .map(this::mapToResponse)
                .toList();
    }

    /**
     * Busca cuentas con saldo superior a un monto mínimo especificado.
     * Útil para identificar cuentas con alto saldo disponible.
     * @param minBalance Saldo mínimo a buscar
     * @return Lista de cuentas que cumplen el criterio
     */
    @Transactional(readOnly = true)
    public List<AccountResponse> findAccountsWithBalanceAbove(BigDecimal minBalance) {
        if (minBalance == null || minBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo mínimo debe ser mayor o igual a cero");
        }
        return accountRepository.findAccountsWithBalanceAbove(minBalance).stream()
                .map(this::mapToResponse)
                .toList();
    }

    /**
     * Busca cuentas por tipo específico.
     * @param accountType Tipo de cuenta a buscar
     * @return Lista de cuentas del tipo especificado
     */
    @Transactional(readOnly = true)
    public List<AccountResponse> findByAccountType(Account.AccountType accountType) {
        return accountRepository.findByAccountType(accountType).stream()
                .map(this::mapToResponse)
                .toList();
    }

    /**
     * Recupera todas las cuentas inactivas en el sistema.
     * Útil para procesos de auditoría y revisión de cuentas.
     * @return Lista de cuentas inactivas
     */
    @Transactional(readOnly = true)
    public List<AccountResponse> findInactiveAccounts() {
        return accountRepository.findByActiveFalse().stream()
                .map(this::mapToResponse)
                .toList();
    }

    /**
     * Cuenta las cuentas activas de un cliente específico.
     * @param customerId Identificador del cliente
     * @return Número de cuentas activas del cliente
     */
    @Transactional(readOnly = true)
    public int countActiveAccountsByCustomer(Long customerId) {
        return accountRepository.countByCustomerIdAndActiveTrue(customerId);
    }

    /**
     * Método helper para buscar una cuenta por ID y lanzar excepción si no existe.
     * @param id Identificador de la cuenta
     * @return Entidad Account encontrada
     * @throws AccountNotFoundException si la cuenta no existe
     */
    private Account findAccountById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El identificador de cuenta no puede ser nulo");
        }
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Cuenta no encontrada con ID: " + id));
    }

    /**
     * Convierte una entidad Account a AccountResponse para la capa de presentación.
     * @param account Entidad del dominio
     * @return DTO de respuesta para el cliente
     */
    private AccountResponse fromEntity(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getAccountNumber(),
                account.getCustomerId(),
                account.getBalance(),
                account.getAccountType().name(),
                account.isActive(),
                account.getCreatedAt(),
                account.getUpdatedAt()
        );
    }

    /**
     * Mapea una entidad a AccountResponse con manejo de estado activo/inactivo.
     * @param account Entidad del dominio
     * @return AccountResponse con el formato apropiado según el estado
     */
    private AccountResponse mapToResponse(Account account) {
        AccountResponse response = fromEntity(account);
        return account.isActive() ? AccountResponse.success(response) : AccountResponse.inactive(response);
    }
}

// === ARCHIVO: src/main/java/com/bank/solid/account/AccountController.java ===
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

// === ARCHIVO: src/main/java/com/bank/solid/auth/AuthService.java ===
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

        if (!account.getPin().equals(pin)) {
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
        session.updateLastAccess();
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

        public void updateLastAccess() {
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

// === ARCHIVO: src/main/java/com/bank/solid/notification/NotificationService.java ===
package com.bank.solid.notification;

import java.util.List;

public interface NotificationService {
    NotificationResult send(NotificationRequest request);
    BulkNotificationResult sendBulk(List<NotificationRequest> requests);
    boolean supportsChannel(NotificationChannel channel);
    NotificationChannel getChannel();

    enum NotificationChannel {
        EMAIL, SMS, PUSH
    }

    record NotificationRequest(
        String recipient,
        String subject,
        String message,
        NotificationPriority priority
    ) {
        public NotificationRequest {
            if (recipient == null || recipient.isBlank()) {
                throw new IllegalArgumentException("El destinatario no puede ser nulo o vacío");
            }
            if (message == null || message.isBlank()) {
                throw new IllegalArgumentException("El mensaje no puede ser nulo o vacío");
            }
        }
    }

    record NotificationResult(
        boolean success,
        String messageId,
        String message,
        long sentAt
    ) {
        public static NotificationResult ok(String messageId) {
            return new NotificationResult(true, messageId, "Notificación enviada exitosamente", System.currentTimeMillis());
        }

        public static NotificationResult fail(String error) {
            return new NotificationResult(false, null, error, System.currentTimeMillis());
        }
    }

    record BulkNotificationResult(
        int total,
        int successful,
        int failed,
        List<String> errors
    ) {
        public static BulkNotificationResult empty() {
            return new BulkNotificationResult(0, 0, 0, List.of());
        }
    }

    enum NotificationPriority {
        LOW, NORMAL, HIGH, URGENT
    }
}

// === ARCHIVO: src/main/java/com/bank/solid/notification/EmailNotificationService.java ===
package com.bank.solid.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class EmailNotificationService implements NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationService.class);
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    private static final int MAX_SUBJECT_LENGTH = 200;
    private static final int MAX_MESSAGE_LENGTH = 5000;

    public EmailNotificationService() {
        logger.info("EmailNotificationService inicializado");
    }

    @Override
    public NotificationResult send(NotificationRequest request) {
        if (request == null) {
            return NotificationResult.fail("La solicitud de notificación no puede ser nula");
        }

        try {
            validateRequest(request);
            String messageId = generateMessageId();
            boolean sent = deliverEmail(request.recipient(), request.subject(), request.message());

            if (sent) {
                logger.info("Email enviado exitosamente a {} con ID: {}", request.recipient(), messageId);
                return NotificationResult.ok(messageId);
            } else {
                logger.warn("Falló el envío de email a {}", request.recipient());
                return NotificationResult.fail("Error al enviar el correo electrónico");
            }
        } catch (IllegalArgumentException e) {
            logger.error("Validación fallida para email: {}", e.getMessage());
            return NotificationResult.fail(e.getMessage());
        } catch (Exception e) {
            logger.error("Error inesperado enviando email a {}: {}", request.recipient(), e.getMessage());
            return NotificationResult.fail("Error interno al enviar la notificación");
        }
    }

    private void validateRequest(NotificationRequest request) {
        if (!isValidEmail(request.recipient())) {
            throw new IllegalArgumentException("Dirección de email inválida: " + request.recipient());
        }
        if (request.subject() != null && request.subject().length() > MAX_SUBJECT_LENGTH) {
            throw new IllegalArgumentException("El asunto excede el límite de " + MAX_SUBJECT_LENGTH + " caracteres");
        }
        if (request.message().length() > MAX_MESSAGE_LENGTH) {
            throw new IllegalArgumentException("El mensaje excede el límite de " + MAX_MESSAGE_LENGTH + " caracteres");
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    private String generateMessageId() {
        return "email-" + System.currentTimeMillis() + "-" + hashCode();
    }

    private boolean deliverEmail(String to, String subject, String body) {
        logger.debug("Enviando email a: {}, asunto: {}", to, subject);
        return true;
    }

    @Override
    public BulkNotificationResult sendBulk(List<NotificationRequest> requests) {
        if (requests == null || requests.isEmpty()) {
            return BulkNotificationResult.empty();
        }

        int total = requests.size();
        int successful = 0;
        int failed = 0;
        List<String> errors = new ArrayList<>();

        for (int i = 0; i < requests.size(); i++) {
            NotificationRequest request = requests.get(i);
            try {
                NotificationResult result = send(request);
                if (result.success()) {
                    successful++;
                } else {
                    failed++;
                    errors.add("Índice " + i + ": " + result.message());
                }
            } catch (Exception e) {
                failed++;
                errors.add("Índice " + i + ": " + e.getMessage());
            }
        }

        logger.info("Envío masivo completado: {} exitosos, {} fallidos de {} total", successful, failed, total);
        return new BulkNotificationResult(total, successful, failed, errors);
    }

    @Override
    public boolean supportsChannel(NotificationChannel channel) {
        return channel == NotificationChannel.EMAIL;
    }

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.EMAIL;
    }

    public int getMaxSubjectLength() {
        return MAX_SUBJECT_LENGTH;
    }

    public int getMaxMessageLength() {
        return MAX_MESSAGE_LENGTH;
    }
}

// === ARCHIVO: src/main/java/com/bank/solid/notification/SmsNotificationService.java ===
package com.bank.solid.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(SmsNotificationService.class);
    private static final int MAX_SMS_LENGTH = 160;
    private static final String SMS_PREFIX = "BANK: ";

    private final SmsGatewayConfig gatewayConfig;
    private final SmsRateLimiter rateLimiter;

    public SmsNotificationService(SmsGatewayConfig gatewayConfig, SmsRateLimiter rateLimiter) {
        this.gatewayConfig = gatewayConfig;
        this.rateLimiter = rateLimiter;
    }

    @Override
    public boolean send(String recipient, String message) {
        if (!validateRecipient(recipient)) {
            logger.warn("Número de teléfono inválido: {}", recipient);
            return false;
        }

        if (!rateLimiter.allowSms(recipient)) {
            logger.warn("Límite de tasa alcanzado para el destinatario: {}", recipient);
            return false;
        }

        String formattedMessage = formatMessage(message);
        
        try {
            SmsGatewayResponse response = gatewayConfig.getClient().send(
                SmsGatewayRequest.builder()
                    .to(recipient)
                    .message(formattedMessage)
                    .senderId(gatewayConfig.getSenderId())
                    .build()
            );
            
            if (response.isSuccess()) {
                logger.info("SMS enviado exitosamente a {}: {}", recipient, response.getMessageId());
                return true;
            } else {
                logger.error("Error al enviar SMS a {}: {}", recipient, response.getErrorMessage());
                return false;
            }
        } catch (Exception e) {
            logger.error("Excepción al enviar SMS a {}: {}", recipient, e.getMessage());
            return false;
        }
    }

    @Override
    public boolean sendVerificationCode(String phoneNumber, String code) {
        String message = String.format("Tu código de verificación es: %s. Válido por 5 minutos.", code);
        return send(phoneNumber, message);
    }

    @Override
    public boolean sendAccountAlert(String phoneNumber, String alertMessage) {
        String formattedAlert = String.format("ALERTA DE CUENTA: %s. Por favor contacta soporte si no reconoces esta actividad.", alertMessage);
        return send(phoneNumber, formattedAlert);
    }

    @Override
    public boolean sendTransactionNotification(String phoneNumber, String transactionDetails) {
        String notification = String.format("Transacción procesada: %s", transactionDetails);
        return send(phoneNumber, notification);
    }

    private boolean validateRecipient(String recipient) {
        if (recipient == null || recipient.isBlank()) {
            return false;
        }
        String cleanNumber = recipient.replaceAll("[\\s\\-()]", "");
        return cleanNumber.matches("^\\+?[0-9]{10,15}$");
    }

    private String formatMessage(String message) {
        String prefixed = SMS_PREFIX + message;
        if (prefixed.length() > MAX_SMS_LENGTH) {
            logger.debug("Mensaje truncado de {} a {} caracteres", prefixed.length(), MAX_SMS_LENGTH);
            return prefixed.substring(0, MAX_SMS_LENGTH);
        }
        return prefixed;
    }
}

// === ARCHIVO: src/main/java/com/bank/solid/exception/AccountNotFoundException.java ===
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

// === ARCHIVO: src/main/java/com/bank/solid/exception/GlobalExceptionHandler.java ===
package com.bank.solid.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String ERROR_ENDPOINT = "endpoint";
    private static final String ERROR_TIMESTAMP = "timestamp";
    private static final String ERROR_STATUS = "status";
    private static final String ERROR_ERROR = "error";
    private static final String ERROR_MESSAGE = "message";
    private static final String ERROR_PATH = "path";

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFound(
            AccountNotFoundException ex, WebRequest request) {
        
        logger.warn("Cuenta no encontrada: {}", ex.getMessage());
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .accountNumber(ex.getAccountNumber())
                .customerId(ex.getCustomerId())
                .build();
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElement(
            NoSuchElementException ex, WebRequest request) {
        
        logger.warn("Elemento no encontrado: {}", ex.getMessage());
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .message("El recurso solicitado no existe")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(
            IllegalArgumentException ex, WebRequest request) {
        
        logger.warn("Argumento ilegal: {}", ex.getMessage());
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        
        String message = String.format("El parámetro '%s' tiene un valor inválido: '%s'", 
                ex.getName(), ex.getValue());
        logger.warn("Tipo de argumento inválido: {}", message);
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(message)
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFound(
            NoResourceFoundException ex, WebRequest request) {
        
        logger.warn("Recurso no encontrado: {}", ex.getMessage());
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .message("El endpoint solicitado no existe")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex, WebRequest request) {
        
        logger.error("Error interno del servidor: {}", ex.getMessage(), ex);
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Internal Server Error")
                .message("Ha ocurrido un error interno. Por favor, contacte al administrador.")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    public static class ErrorResponse {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;
        private String accountNumber;
        private Long customerId;

        private ErrorResponse() {}

        public static ErrorResponseBuilder builder() {
            return new ErrorResponseBuilder();
        }

        public LocalDateTime getTimestamp() { return timestamp; }
        public int getStatus() { return status; }
        public String getError() { return error; }
        public String getMessage() { return message; }
        public String getPath() { return path; }
        public String getAccountNumber() { return accountNumber; }
        public Long getCustomerId() { return customerId; }

        public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
        public void setStatus(int status) { this.status = status; }
        public void setError(String error) { this.error = error; }
        public void setMessage(String message) { this.message = message; }
        public void setPath(String path) { this.path = path; }
        public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
        public void setCustomerId(Long customerId) { this.customerId = customerId; }

        public static class ErrorResponseBuilder {
            private LocalDateTime timestamp;
            private int status;
            private String error;
            private String message;
            private String path;
            private String accountNumber;
            private Long customerId;

            ErrorResponseBuilder() {}

            public ErrorResponseBuilder timestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public ErrorResponseBuilder status(int status) {
                this.status = status;
                return this;
            }

            public ErrorResponseBuilder error(String error) {
                this.error = error;
                return this;
            }

            public ErrorResponseBuilder message(String message) {
                this.message = message;
                return this;
            }

            public ErrorResponseBuilder path(String path) {
                this.path = path;
                return this;
            }

            public ErrorResponseBuilder accountNumber(String accountNumber) {
                this.accountNumber = accountNumber;
                return this;
            }

            public ErrorResponseBuilder customerId(Long customerId) {
                this.customerId = customerId;
                return this;
            }

            public ErrorResponse build() {
                ErrorResponse response = new ErrorResponse();
                response.timestamp = this.timestamp;
                response.status = this.status;
                response.error = this.error;
                response.message = this.message;
                response.path = this.path;
                response.accountNumber = this.accountNumber;
                response.customerId = this.customerId;
                return response;
            }
        }
    }
}


// === ARCHIVO: src/test/java/com/bank/solid/account/AccountServiceTest.java ===
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

// === ARCHIVO: src/test/java/com/bank/solid/notification/NotificationServiceTest.java ===
package com.bank.solid.notification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para NotificationService - Validación de Liskov Substitution Principle")
class NotificationServiceTest {

    @Mock
    private EmailNotificationService emailNotificationService;

    @Mock
    private SmsNotificationService smsNotificationService;

    @InjectMocks
    private NotificationService notificationService;

    private String testRecipient;
    private String testMessage;

    @BeforeEach
    void setUp() {
        testRecipient = "cliente@banco.com";
        testMessage = "Su transacción ha sido procesada exitosamente.";
    }

    @Test
    @DisplayName("Liskov Substitution: EmailNotificationService puede sustituir a NotificationService sin alterar comportamiento")
    void testLiskovSubstitution_emailCanReplaceNotification() {
        doNothing().when(emailNotificationService).send(testRecipient, testMessage);

        notificationService.setNotificationStrategy(emailNotificationService);
        notificationService.sendNotification(testRecipient, testMessage);

        verify(emailNotificationService, times(1)).send(testRecipient, testMessage);
    }

    @Test
    @DisplayName("Liskov Substitution: SmsNotificationService puede sustituir a NotificationService sin alterar comportamiento")
    void testLiskovSubstitution_smsCanReplaceNotification() {
        doNothing().when(smsNotificationService).send(testRecipient, testMessage);

        notificationService.setNotificationStrategy(smsNotificationService);
        notificationService.sendNotification(testRecipient, testMessage);

        verify(smsNotificationService, times(1)).send(testRecipient, testMessage);
    }

    @Test
    @DisplayName("Liskov Substitution: Ambas implementaciones son intercambiables en tiempo de ejecución")
    void testLiskovSubstitution_interchangeableImplementations() {
        doNothing().when(emailNotificationService).send(anyString(), anyString());
        doNothing().when(smsNotificationService).send(anyString(), anyString());

        notificationService.setNotificationStrategy(emailNotificationService);
        notificationService.sendNotification("test1@email.com", "Mensaje 1");

        notificationService.setNotificationStrategy(smsNotificationService);
        notificationService.sendNotification("+1234567890", "Mensaje 2");

        verify(emailNotificationService, times(1)).send(anyString(), anyString());
        verify(smsNotificationService, times(1)).send(anyString(), anyString());
    }

    @Test
    @DisplayName("Liskov Substitution: El contrato de la interfaz se cumple en ambas implementaciones")
    void testLiskovSubstitution_contractFulfilledByBoth() {
        assertNotNull(emailNotificationService, "EmailNotificationService debe implementar el contrato de NotificationService");
        assertNotNull(smsNotificationService, "SmsNotificationService debe implementar el contrato de NotificationService");

        assertTrue(emailNotificationService instanceof NotificationService,
                "EmailNotificationService debe ser subtipo de NotificationService");
        assertTrue(smsNotificationService instanceof NotificationService,
                "SmsNotificationService debe ser subtipo de NotificationService");
    }

    @Test
    @DisplayName("Envío de notificación por email exitosamente")
    void testSendEmailNotification_success() {
        doNothing().when(emailNotificationService).send(testRecipient, testMessage);

        notificationService.setNotificationStrategy(emailNotificationService);
        notificationService.sendNotification(testRecipient, testMessage);

        verify(emailNotificationService).send(testRecipient, testMessage);
    }

    @Test
    @DisplayName("Envío de notificación por SMS exitosamente")
    void testSendSmsNotification_success() {
        String phoneNumber = "+1234567890";
        doNothing().when(smsNotificationService).send(phoneNumber, testMessage);

        notificationService.setNotificationStrategy(smsNotificationService);
        notificationService.sendNotification(phoneNumber, testMessage);

        verify(smsNotificationService).send(phoneNumber, testMessage);
    }

    @Test
    @DisplayName("Error al enviar notificación sin estrategia configurada")
    void testSendNotification_noStrategy() {
        NotificationService serviceWithoutStrategy = new NotificationService();

        assertThrows(IllegalStateException.class, () -> 
                serviceWithoutStrategy.sendNotification(testRecipient, testMessage));
    }

    @Test
    @DisplayName("Cambio de estrategia de email a SMS en tiempo de ejecución")
    void testStrategyChangeAtRuntime() {
        doNothing().when(emailNotificationService).send(anyString(), anyString());
        doNothing().when(smsNotificationService).send(anyString(), anyString());

        notificationService.setNotificationStrategy(emailNotificationService);
        notificationService.sendNotification("email@test.com", "Email message");

        notificationService.setNotificationStrategy(smsNotificationService);
        notificationService.sendNotification("+1234567890", "SMS message");

        verify(emailNotificationService, times(1)).send(anyString(), eq("Email message"));
        verify(smsNotificationService, times(1)).send(anyString(), eq("SMS message"));
    }

    @Test
    @DisplayName("Interfaz de NotificationService define contrato claro para implementaciones")
    void testInterfaceDefinesClearContract() {
        Class<?>[] interfaces = NotificationService.class.getInterfaces();
        assertTrue(interfaces.length > 0 || NotificationService.class.getSuperclass() != Object.class,
                "NotificationService debe definir un contrato claro para sus implementaciones");
    }

    @Test
    @DisplayName("Las implementaciones no alteran el comportamiento esperado del contrato")
    void testImplementationsDoNotAlterContractBehavior() {
        doThrow(new RuntimeException("Error de email")).when(emailNotificationService).send(isNull(), anyString());
        doThrow(new RuntimeException("Error de SMS")).when(smsNotificationService).send(isNull(), anyString());

        assertAll("Ambas implementaciones deben throwear cuando reciben parámetros inválidos",
                () -> assertThrows(RuntimeException.class, () -> {
                    notificationService.setNotificationStrategy(emailNotificationService);
                    notificationService.sendNotification(null, "test");
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    notificationService.setNotificationStrategy(smsNotificationService);
                    notificationService.sendNotification(null, "test");
                })
        );
    }
}

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>
    
    <groupId>com.bank</groupId>
    <artifactId>solid</artifactId>
    <version>1.0.0</version>
    <name>Solid Banking Application</name>
    <description>Aplicación bancaria que demuestra principios SOLID</description>
    
    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.16</version>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/bank/solid/notification/NotificationService.java ===
package com.bank.solid.notification;

import java.util.List;

public interface NotificationService {
    
    NotificationResult send(NotificationRequest request);
    
    BulkNotificationResult sendBulk(List<NotificationRequest> requests);
    
    boolean supportsChannel(NotificationChannel channel);
    
    NotificationChannel getChannel();
    
    enum NotificationChannel {
        EMAIL,
        SMS,
        PUSH
    }
    
    record NotificationRequest(
        String recipient,
        String subject,
        String message,
        NotificationPriority priority
    ) {
        public NotificationRequest {
            if (recipient == null || recipient.isBlank()) {
                throw new IllegalArgumentException("Recipient cannot be null or blank");
            }
            if (message == null || message.isBlank()) {
                throw new IllegalArgumentException("Message cannot be null or blank");
            }
        }
        
        public static NotificationRequest simple(String recipient, String message) {
            return new NotificationRequest(recipient, null, message, NotificationPriority.NORMAL);
        }
    }
    
    record NotificationResult(
        boolean success,
        String message,
        String messageId
    ) {
        public static NotificationResult ok(String messageId) {
            return new NotificationResult(true, "Operation successful", messageId);
        }
        
        public static NotificationResult fail(String errorMessage) {
            return new NotificationResult(false, errorMessage, null);
        }
    }
    
    record BulkNotificationResult(
        int total,
        int successful,
        int failed,
        List<String> errors
    ) {
        public static BulkNotificationResult empty() {
            return new BulkNotificationResult(0, 0, 0, List.of());
        }
        
        public boolean hasFailures() {
            return failed > 0;
        }
    }
    
    enum NotificationPriority {
        LOW,
        NORMAL,
        HIGH,
        URGENT
    }
}


// === ARCHIVO: src/main/java/com/bank/solid/account/Account.java ===
package com.bank.solid.account;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad que representa una cuenta bancaria en el sistema.
 * Implementa los callbacks de ciclo de vida de JPA para auditoría automática.
 */
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Column(nullable = false)
    private boolean active = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "pin")
    private String pin;

    public enum AccountType {
        CHECKING,
        SAVINGS,
        FIXED_TERM,
        CREDIT
    }

    public Account() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (balance == null) {
            balance = BigDecimal.ZERO;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @PostLoad
    protected void onLoad() {
        if (balance == null) {
            balance = BigDecimal.ZERO;
        }
    }

    public boolean hasBalance() {
        return balance != null && balance.compareTo(BigDecimal.ZERO) > 0;
    }

    public String getFormattedBalance() {
        return balance != null ? String.format("$%.2f", balance) : "$0.00";
    }

    public void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero");
        }
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero");
        }
        if (!hasBalance()) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Saldo insuficiente para realizar la operación");
        }
        this.balance = this.balance.subtract(amount);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}

// === ARCHIVO: src/main/java/com/bank/solid/dto/AccountResponse.java ===
package com.bank.solid.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO para enviar datos de cuentas a los clientes.
 * Aplica el principio de Responsabilidad Única (SRP) al representar exclusivamente
 * los datos de salida de la capa de presentación. Mantiene una separación clara
 * entre la entidad de dominio (Account) y la representación que se expone al exterior.
 * Utiliza un record de Java 21 para inmutabilidad y concisión.
 */
public record AccountResponse(
    Long id,
    String accountNumber,
    Long customerId,
    String accountType,
    BigDecimal balance,
    String holderName,
    String email,
    String phone,
    boolean active,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    String status
) {
    /**
     * Factory method para crear una respuesta exitosa.
     */
    public static AccountResponse success(AccountResponse response) {
        return response;
    }

    /**
     * Factory method para crear una respuesta con estado inactivo.
     */
    public static AccountResponse inactive(AccountResponse response) {
        return new AccountResponse(
            response.id(),
            response.accountNumber(),
            response.customerId(),
            response.accountType(),
            response.balance(),
            response.holderName(),
            response.email(),
            response.phone(),
            false,
            response.createdAt(),
            response.updatedAt(),
            "INACTIVA"
        );
    }

    /**
     * Verifica si la cuenta tiene saldo disponible.
     */
    public boolean hasBalance() {
        return balance != null && balance.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * Retorna el saldo formateado como string con símbolo de moneda.
     */
    public String getFormattedBalance() {
        return balance != null ? String.format("$%.2f", balance) : "$0.00";
    }
}

// === ARCHIVO: src/main/java/com/bank/solid/account/AccountRepository.java ===
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

// === ARCHIVO: src/main/java/com/bank/solid/account/AccountService.java ===
package com.bank.solid.account;

import com.bank.solid.dto.AccountRequest;
import com.bank.solid.dto.AccountResponse;
import com.bank.solid.exception.AccountNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Servicio que implementa la lógica de negocio para la gestión de cuentas bancarias.
 * Este componente aplica el Principio de Responsabilidad Única (SRP) al concentrar
 * exclusivamente en operaciones relacionadas con cuentas, separándolas de otros
 * Concerns como autenticación y notificaciones.
 */
@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    /**
     * Constructor con inyección de dependencias del repositorio de cuentas.
     * Spring Boot 3.4 permite inyección por constructor sin necesidad de @Autowired explícito.
     * @param accountRepository Repositorio para operaciones de persistencia de cuentas
     */
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Crea una nueva cuenta bancaria en el sistema.
     * Valida que el número de cuenta no exista previamente antes de persistir.
     * @param request Datos de la cuenta a crear
     * @return AccountResponse con los datos de la cuenta creada
     * @throws IllegalArgumentException si los datos de entrada son inválidos
     */
    public AccountResponse createAccount(AccountRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("La solicitud de cuenta no puede ser nula");
        }
        if (request.accountNumber() == null || request.accountNumber().isBlank()) {
            throw new IllegalArgumentException("El número de cuenta es obligatorio");
        }
        if (accountRepository.existsByAccountNumber(request.accountNumber())) {
            throw new IllegalArgumentException("Ya existe una cuenta con el número: " + request.accountNumber());
        }

        Account account = new Account();
        account.setAccountNumber(request.accountNumber());
        account.setCustomerId(request.customerId());
        account.setAccountType(request.accountType());
        account.setBalance(request.initialBalance() != null ? request.initialBalance() : BigDecimal.ZERO);
        account.setActive(true);

        Account savedAccount = accountRepository.save(account);
        return AccountResponse.success(fromEntity(savedAccount));
    }

    /**
     * Recupera una cuenta por su identificador único.
     * @param id Identificador de la cuenta
     * @return AccountResponse con los datos de la cuenta
     * @throws AccountNotFoundException si la cuenta no existe
     */
    @Transactional(readOnly = true)
    public AccountResponse getAccount(Long id) {
        Account account = findAccountById(id);
        return mapToResponse(account);
    }

    /**
     * Actualiza la información de una cuenta existente.
     * Solo permite modificar el tipo de cuenta y el estado de actividad.
     * @param id Identificador de la cuenta a actualizar
     * @param request Nuevos datos para la cuenta
     * @return AccountResponse con los datos actualizados
     * @throws AccountNotFoundException si la cuenta no existe
     */
    public AccountResponse updateAccount(Long id, AccountRequest request) {
        Account account = findAccountById(id);

        if (request.accountType() != null) {
            account.setAccountType(request.accountType());
        }

        if (request.initialBalance() != null) {
            account.setBalance(request.initialBalance());
        }

        Account updatedAccount = accountRepository.save(account);
        return mapToResponse(updatedAccount);
    }

    /**
     * Desactiva una cuenta bancaria, marcándola como inactiva.
     * Las cuentas inactivas no pueden realizar operaciones hasta ser reactivadas.
     * @param id Identificador de la cuenta a desactivar
     * @return AccountResponse con los datos de la cuenta desactivada
     * @throws AccountNotFoundException si la cuenta no existe
     */
    public AccountResponse deactivateAccount(Long id) {
        Account account = findAccountById(id);
        account.setActive(false);
        Account savedAccount = accountRepository.save(account);
        return AccountResponse.inactive(fromEntity(savedAccount));
    }

    /**
     * Reactiva una cuenta bancaria previamente desactivada.
     * @param id Identificador de la cuenta a reactivar
     * @return AccountResponse con los datos de la cuenta reactivada
     * @throws AccountNotFoundException si la cuenta no existe
     */
    public AccountResponse activateAccount(Long id) {
        Account account = findAccountById(id);
        account.setActive(true);
        Account savedAccount = accountRepository.save(account);
        return AccountResponse.success(fromEntity(savedAccount));
    }

    /**
     * Busca una cuenta por su número único de cuenta.
     * @param accountNumber Número de cuenta a buscar
     * @return Optional con la cuenta si existe, vacío si no
     */
    @Transactional(readOnly = true)
    public Optional<AccountResponse> findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(this::mapToResponse);
    }

    /**
     * Recupera todas las cuentas asociadas a un cliente específico.
     * @param customerId Identificador del cliente
     * @return Lista de AccountResponse con las cuentas del cliente
     */
    @Transactional(readOnly = true)
    public List<AccountResponse> findByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId).stream()
                .map(this::mapToResponse)
                .toList();
    }

    /**
     * Busca cuentas con saldo superior a un monto mínimo especificado.
     * Útil para identificar cuentas con alto saldo disponible.
     * @param minBalance Saldo mínimo a buscar
     * @return Lista de cuentas que cumplen el criterio
     */
    @Transactional(readOnly = true)
    public List<AccountResponse> findAccountsWithBalanceAbove(BigDecimal minBalance) {
        if (minBalance == null || minBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo mínimo debe ser mayor o igual a cero");
        }
        return accountRepository.findAccountsWithBalanceAbove(minBalance).stream()
                .map(this::mapToResponse)
                .toList();
    }

    /**
     * Busca cuentas por tipo específico.
     * @param accountType Tipo de cuenta a buscar
     * @return Lista de cuentas del tipo especificado
     */
    @Transactional(readOnly = true)
    public List<AccountResponse> findByAccountType(Account.AccountType accountType) {
        return accountRepository.findByAccountType(accountType).stream()
                .map(this::mapToResponse)
                .toList();
    }

    /**
     * Recupera todas las cuentas inactivas en el sistema.
     * Útil para procesos de auditoría y revisión de cuentas.
     * @return Lista de cuentas inactivas
     */
    @Transactional(readOnly = true)
    public List<AccountResponse> findInactiveAccounts() {
        return accountRepository.findByActiveFalse().stream()
                .map(this::mapToResponse)
                .toList();
    }

    /**
     * Cuenta las cuentas activas de un cliente específico.
     * @param customerId Identificador del cliente
     * @return Número de cuentas activas del cliente
     */
    @Transactional(readOnly = true)
    public int countActiveAccountsByCustomer(Long customerId) {
        return accountRepository.countByCustomerIdAndActiveTrue(customerId);
    }

    /**
     * Método helper para buscar una cuenta por ID y lanzar excepción si no existe.
     * @param id Identificador de la cuenta
     * @return Entidad Account encontrada
     * @throws AccountNotFoundException si la cuenta no existe
     */
    private Account findAccountById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El identificador de cuenta no puede ser nulo");
        }
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Cuenta no encontrada con ID: " + id));
    }

    /**
     * Convierte una entidad Account a AccountResponse para la capa de presentación.
     * @param account Entidad del dominio
     * @return DTO de respuesta para el cliente
     */
    private AccountResponse fromEntity(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getAccountNumber(),
                account.getCustomerId(),
                account.getAccountType() != null ? account.getAccountType().name() : null,
                account.getBalance(),
                null,
                null,
                null,
                account.isActive(),
                account.getCreatedAt(),
                account.getUpdatedAt(),
                account.isActive() ? "ACTIVA" : "INACTIVA"
        );
    }

    /**
     * Mapea una entidad a AccountResponse con manejo de estado activo/inactivo.
     * @param account Entidad del dominio
     * @return AccountResponse con el formato apropiado según el estado
     */
    private AccountResponse mapToResponse(Account account) {
        AccountResponse response = fromEntity(account);
        return account.isActive() ? AccountResponse.success(response) : AccountResponse.inactive(response);
    }
}

// === ARCHIVO: src/main/java/com/bank/solid/auth/AuthService.java ===
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

// === ARCHIVO: src/main/java/com/bank/solid/account/Account.java ===
package com.bank.solid.account;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @Column(nullable = false)
    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Account() {
    }

    public Account(String accountNumber, Long customerId, BigDecimal balance, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = balance;
        this.accountType = accountType;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public enum AccountType {
        CHECKING,
        SAVINGS,
        INVESTMENT
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public boolean hasBalance() {
        return balance != null && balance.compareTo(BigDecimal.ZERO) > 0;
    }

    public String getFormattedBalance() {
        return balance != null ? balance.toString() : "0.00";
    }

    public void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.balance = this.balance.subtract(amount);
    }
}

// === ARCHIVO: src/main/java/com/bank/solid/account/AccountService.java ===
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

// === ARCHIVO: src/main/java/com/bank/solid/dto/AccountResponse.java ===
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

// === ARCHIVO: src/main/java/com/bank/solid/notification/NotificationService.java ===
package com.bank.solid.notification;

import java.util.List;

public interface NotificationService {

    NotificationResult send(NotificationRequest request);

    BulkNotificationResult sendBulk(List<NotificationRequest> requests);

    boolean supportsChannel(NotificationChannel channel);

    NotificationChannel getChannel();

    void setNotificationStrategy(NotificationService strategy);

    void sendNotification(String recipient, String message);

    enum NotificationChannel {
        EMAIL,
        SMS,
        PUSH
    }

    record NotificationRequest(
        String recipient,
        String subject,
        String body,
        NotificationPriority priority
    ) {}

    record NotificationResult(
        boolean success,
        String messageId,
        String message
    ) {}

    record BulkNotificationResult(
        int total,
        int successful,
        int failed,
        List<String> errors
    ) {}

    enum NotificationPriority {
        LOW,
        NORMAL,
        HIGH,
        URGENT
    }
}

// === ARCHIVO: src/main/java/com/bank/solid/notification/NotificationServiceImpl.java ===
package com.bank.solid.notification;

public class NotificationServiceImpl implements NotificationService {

    private NotificationService strategy;

    public NotificationServiceImpl() {
    }

    public NotificationServiceImpl(NotificationService strategy) {
        this.strategy = strategy;
    }

    @Override
    public NotificationResult send(NotificationRequest request) {
        if (strategy == null) {
            throw new IllegalStateException("No hay estrategia de notificación configurada");
        }
        return strategy.send(request);
    }

    @Override
    public BulkNotificationResult sendBulk(List<NotificationRequest> requests) {
        if (strategy == null) {
            throw new IllegalStateException("No hay estrategia de notificación configurada");
        }
        return strategy.sendBulk(requests);
    }

    @Override
    public boolean supportsChannel(NotificationChannel channel) {
        return strategy != null && strategy.supportsChannel(channel);
    }

    @Override
    public NotificationChannel getChannel() {
        return strategy != null ? strategy.getChannel() : null;
    }

    @Override
    public void setNotificationStrategy(NotificationService strategy) {
        this.strategy = strategy;
    }

    @Override
    public void sendNotification(String recipient, String message) {
        if (strategy == null) {
            throw new IllegalStateException("No hay estrategia de notificación configurada");
        }
        
        NotificationRequest request = new NotificationRequest(
            recipient,
            "Notificación",
            message,
            NotificationPriority.NORMAL
        );
        strategy.send(request);
    }
}

```
