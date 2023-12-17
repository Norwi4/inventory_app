package com.avagyan.inventoryapp.dto;

/**
 * @author Abaev Evgeniy
 */
public class DishDTO {
    /**
     * Идентификатор блюда
     */
    private Long id;
    /**
     * Название блюда
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
