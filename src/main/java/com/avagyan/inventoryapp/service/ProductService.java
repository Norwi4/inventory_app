package com.avagyan.inventoryapp.service;

import com.avagyan.inventoryapp.dao.ProductRepository;
import com.avagyan.inventoryapp.dto.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> products() {
        return repository.products();
    }
}
