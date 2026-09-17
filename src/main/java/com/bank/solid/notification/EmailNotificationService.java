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