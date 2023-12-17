package com.avagyan.inventoryapp.controller;

import com.avagyan.inventoryapp.dto.*;
import com.avagyan.inventoryapp.service.DishService;
import com.avagyan.inventoryapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Controller
@RequestMapping("/dish")
public class DishController {
    private DishService dishService;
    private ProductService productService;

    public DishController(DishService dishService, ProductService productService) {
        this.dishService = dishService;
        this.productService = productService;
    }

    @GetMapping()
    public String viewDish(Model model) {
        List<DishDTO> list = dishService.getDishList();
        model.addAttribute("list", list);
        return "dish/dish_list";
    }

    @RequestMapping("/new-dish")
    public String formDish(Model model) {
        Dish dish = new Dish();
        List<Product> products = productService.products();

        model.addAttribute("dish", dish);
        model.addAttribute("products", products);
        return "dish/new_dish";
    }

    @RequestMapping(value = "/add-dish", method = RequestMethod.POST)
    public String save(@ModelAttribute("consignment") Dish dish) {
        dishService.createDish(dish);
        return "redirect:/dish/add_product_dish";
    }

    @RequestMapping("/add-product_dish")
    public String formProductDish(Model model) {
        ProductDTO products = new ProductDTO();
        List<ProductsDishDTO> list = dishService.getDishProducts();

        model.addAttribute("products", products);
        model.addAttribute("list", list);
        return "dish/add_product_dish";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String updateQuantity(@ModelAttribute("products") QuantityDTO products) {
        dishService.saveQuantityProducts(products.getProducts());
        return "redirect:/dish";
    }
}
