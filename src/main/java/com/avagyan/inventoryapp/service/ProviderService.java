package com.avagyan.inventoryapp.service;

import com.avagyan.inventoryapp.dao.ProviderRepository;
import com.avagyan.inventoryapp.dto.Consignment;
import com.avagyan.inventoryapp.dto.Provider;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Service
public class ProviderService {
    private ProviderRepository repository;

    public ProviderService(ProviderRepository repository) {
        this.repository = repository;
    }

    public List<Provider> getProviderList() {
        return repository.getProviderList();
    }

    public void createProvider(Consignment consignment) {
        repository.createProvider(consignment);
    }
}
