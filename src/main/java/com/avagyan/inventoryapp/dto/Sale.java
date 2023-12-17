package com.avagyan.inventoryapp.dto;

/**
 * @author Abaev Evgeniy
 */
public class Sale {
    private int id;
    private String item;
    private int quantity;
    private float amount;

    protected Sale() {
    }

    protected Sale(String item, int quantity, float amount) {
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
    }
}
