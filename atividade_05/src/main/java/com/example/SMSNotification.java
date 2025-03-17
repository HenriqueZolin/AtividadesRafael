package com.example;

public class SMSNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("SMS enviado com sucesso!");
    }
}