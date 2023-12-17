package com.avagyan.inventoryapp.service;

import com.avagyan.inventoryapp.dao.WarehouseRepository;
import com.avagyan.inventoryapp.dto.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Service
public class WarehouseService {
    private WarehouseRepository repository;

    public WarehouseService(WarehouseRepository repository) {
        this.repository = repository;
    }

    public void createWarehouse(Warehouse warehouse) {
        repository.createWarehouse(warehouse);
    }

    public List<Warehouse> getWarehouseList() {
        return repository.getWarehouseList();
    }
}
