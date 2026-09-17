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