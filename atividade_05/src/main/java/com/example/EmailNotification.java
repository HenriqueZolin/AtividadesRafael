package com.example;

public class EmailNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("Email enviado com sucesso!");
    }
}