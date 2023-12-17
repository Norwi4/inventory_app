package com.avagyan.inventoryapp.service;

import com.avagyan.inventoryapp.dao.SalesRepository;
import com.avagyan.inventoryapp.dto.Sale;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Service
public class SaleService {
    private SalesRepository salesRepository;

    public SaleService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<Sale> list() {
        return salesRepository.list();
    }
}
