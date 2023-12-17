package com.avagyan.inventoryapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Остаток на складе
 *
 * @author Abaev Evgeniy
 */
public class RemainsDTO {
    private String article;
    private String productName;
    private Integer quantity;
    @JsonProperty("warehouse_name")
    private String warehouse_name;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }
}
