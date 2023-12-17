package com.avagyan.inventoryapp.dto;

/**
 * Модель склада
 *
 * @author Abaev Evgeniy
 */
public class Warehouse {
    /**
     * Идентификатор
     */
    private Long id;
    /**
     * Название
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
