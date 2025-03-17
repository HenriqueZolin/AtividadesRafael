package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1: Email");
        System.out.println("2: SMS");
        System.out.println("3: Push Notification");

        String choice = scanner.nextLine();
        System.out.println("Digite a mensagem:");
        String message = scanner.nextLine();

        Notification notification = NotificationFactory.createNotification(choice);
        notification.send(message);

        scanner.close();
    }
}