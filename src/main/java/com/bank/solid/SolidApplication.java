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