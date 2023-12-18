package com.avagyan.inventoryapp.service;

import com.avagyan.inventoryapp.dao.DishRepository;
import com.avagyan.inventoryapp.dto.Dish;
import com.avagyan.inventoryapp.dto.DishDTO;
import com.avagyan.inventoryapp.dto.ProductDTO;
import com.avagyan.inventoryapp.dto.ProductsDishDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Service
public class DishService {
    private DishRepository repository;

    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    /**
     * Создание блюда
     * @param dish
     */
    public void createDish(Dish dish) {
        repository.createDish(dish);
        repository.addProduct(dish, repository.getLastId());
    }

    public List<DishDTO> getDishList() {
        return repository.getDishList();
    }

    public List<ProductDTO> getDishProducts() {
        return repository.getDishProducts(repository.getLastId());
    }

    public void saveQuantityProducts(List<ProductDTO> productDTO) {
        repository.saveQuantityProducts(productDTO);
    }
}
