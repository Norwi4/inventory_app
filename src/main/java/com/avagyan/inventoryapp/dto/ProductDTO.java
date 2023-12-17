package com.avagyan.inventoryapp.dto;

import java.util.Optional;

/**
 * ДТО продукта для блюда
 *
 * @author Abaev Evgeniy
 */
public class ProductDTO {
    /**
     * Идентификатор продукта
     */
    private Long id;
    /**
     * Артикул продукта
     */
    private String article;
    /**
     * Кол-во продукта
     */
    private Optional<Integer> quantity;
    /**
     * Идентификатор блюда
     */
    private Optional<Integer> dishId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Optional<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(Optional<Integer> quantity) {
        this.quantity = quantity;
    }

    public Optional<Integer> getDishId() {
        return dishId;
    }

    public void setDishId(Optional<Integer> dishId) {
        this.dishId = dishId;
    }
}
