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