package com.avagyan.inventoryapp.controller;

import com.avagyan.inventoryapp.dto.Warehouse;
import com.avagyan.inventoryapp.service.WarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
    private WarehouseService service;

    public WarehouseController(WarehouseService service) {
        this.service = service;
    }

    @GetMapping()
    public String viewHome(Model model) {
        List<Warehouse> list = service.getWarehouseList();
        model.addAttribute("list", list);
        return "warehouse/warehouse_list";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Warehouse warehouse = new Warehouse();
        model.addAttribute("warehouse", warehouse);
        return "warehouse/new_warehouse";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("warehouse") Warehouse warehouse) {
        service.createWarehouse(warehouse);
        return "redirect:/warehouse";
    }
}
