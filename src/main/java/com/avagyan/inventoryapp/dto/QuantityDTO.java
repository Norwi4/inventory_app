package com.avagyan.inventoryapp.dto;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
public class QuantityDTO {
    List<ProductDTO> products;

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
