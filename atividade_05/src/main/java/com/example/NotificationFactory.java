package com.example;

class NotificationFactory {
    public static Notification createNotification(String type) {
        return switch (type) {
            case "1" -> new EmailNotification();
            case "2" -> new SMSNotification();
            case "3" -> new PushNotification();
            default -> throw new IllegalArgumentException("Tipo inválido");
        };
    }
}