package com.avagyan.inventoryapp.controller;

import com.avagyan.inventoryapp.dto.Product;
import com.avagyan.inventoryapp.dto.Warehouse;
import com.avagyan.inventoryapp.service.ProductService;
import com.avagyan.inventoryapp.service.WarehouseService;
import org.springframework.boot.Banner;
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
    private ProductService productService;

    public WarehouseController(WarehouseService service, ProductService productService) {
        this.service = service;
        this.productService = productService;
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

    //______________________________________________________________________
    @RequestMapping("/new-product")
    public String newProduct(Model model) {
        Product product = new Product();
        List<Warehouse> list = service.getWarehouseList();

        model.addAttribute("list", list);
        model.addAttribute("product", product);
        return "warehouse/new_product";
    }

    @RequestMapping(value = "/save-product", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.createProduct(product);
        return "redirect:/warehouse";
    }
}
