package com.avagyan.inventoryapp.service;

import com.avagyan.inventoryapp.dao.DishRepository;
import com.avagyan.inventoryapp.dto.*;
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

    public void consignmentDish(CancellationDish cancellationDish) {
        repository.consignmentDish(cancellationDish);
    }

    public DishDTO getDishById(Long id) {
        return repository.getDishById(id);
    }

    public List<ProductDTO> products(Long id) {
        return repository.products(id);
    }
}
