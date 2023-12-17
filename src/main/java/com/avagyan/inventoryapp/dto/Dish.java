package com.avagyan.inventoryapp.dto;

import java.util.List;

/**
 * Модель блюда
 *
 * @author Abaev Evgeniy
 */
public class Dish {
    /**
     * Идентификатор блюда
     */
    private Long id;
    /**
     * Название блюда
     */
    private String name;
    /**
     * Состав
     */
    private List<Long> productDTO;

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

    public List<Long> getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(List<Long> productDTO) {
        this.productDTO = productDTO;
    }
}
