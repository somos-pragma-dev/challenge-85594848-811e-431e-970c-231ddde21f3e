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