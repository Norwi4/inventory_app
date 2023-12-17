package com.avagyan.inventoryapp.dao;

import com.avagyan.inventoryapp.dto.RemainsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Service
public class RemainsService {
    private RemainsRepository remainsRepository;

    public RemainsService(RemainsRepository remainsRepository) {
        this.remainsRepository = remainsRepository;
    }

    public List<RemainsDTO> getRemainsList() {
        return remainsRepository.getRemainsList();
    }
}
