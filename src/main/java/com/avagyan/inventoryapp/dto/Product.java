package com.avagyan.inventoryapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Модель товаров
 *
 * @author Abaev Evgeniy
 */
public class Product {
    /**
     * Идентификатор товара
     */
    private Long id;
    /**
     * Название
     */
    private String name;
    /**
     *  Артикул товара
     */
    private String article;
    /**
     * Цена
     */
    private BigDecimal price;
    /**
     * Срок годности
     */
    private LocalDate expirationDate;
    /**
     * Идентификатор склада
     */
    private Long warehouseId;

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

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}
