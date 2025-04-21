package com.unicesumar.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Venda extends Entity{
    private UUID id;
    private UUID userId;
    private String paymentMethod;
    private LocalDateTime saleDate;

    public Venda() {
        // Construtor padrão necessário para frameworks e serialização
    }

    public Venda(UUID userId, String paymentMethod, LocalDateTime saleDate) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.paymentMethod = paymentMethod;
        this.saleDate = saleDate != null ? saleDate : LocalDateTime.now();
    }

    public Venda(UUID id, UUID userId, String paymentMethod, LocalDateTime saleDate) {
        super(id);
        this.userId = userId;
        this.paymentMethod = paymentMethod;
        this.saleDate = saleDate != null ? saleDate : LocalDateTime.now();
    }

    // Getters e Setters

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + this.getUuid() +
                ", userId=" + userId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", saleDate=" + saleDate +
                '}';
    }
}
