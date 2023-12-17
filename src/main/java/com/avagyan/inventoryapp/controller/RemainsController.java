package com.avagyan.inventoryapp.controller;

import com.avagyan.inventoryapp.dao.RemainsService;
import com.avagyan.inventoryapp.dto.RemainsDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Controller
@RequestMapping("/remains")
public class RemainsController {
    private RemainsService service;

    public RemainsController(RemainsService service) {
        this.service = service;
    }
    @GetMapping()
    public String viewRemains(Model model) {
        List<RemainsDTO> list = service.getRemainsList();
        model.addAttribute("list", list);
        return "remains/remains_list";
    }
}
