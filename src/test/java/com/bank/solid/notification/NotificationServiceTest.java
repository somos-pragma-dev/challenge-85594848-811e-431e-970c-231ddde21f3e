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