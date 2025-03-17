package com.example;

public class PushNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("Mensagem : \n" + message);
        System.out.println("Enviada com sucesso!");
    }
}