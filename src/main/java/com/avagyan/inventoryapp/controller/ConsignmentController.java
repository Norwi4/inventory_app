package com.avagyan.inventoryapp.controller;

import com.avagyan.inventoryapp.dto.Consignment;
import com.avagyan.inventoryapp.dto.ConsignmentDTO;
import com.avagyan.inventoryapp.dto.Product;
import com.avagyan.inventoryapp.dto.Provider;
import com.avagyan.inventoryapp.service.ConsignmentService;
import com.avagyan.inventoryapp.service.ProductService;
import com.avagyan.inventoryapp.service.ProviderService;
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
@RequestMapping("/consignment")
public class ConsignmentController {
    private ConsignmentService consignmentService;
    private ProviderService providerService;
    private ProductService productService;

    public ConsignmentController(ConsignmentService consignmentService, ProviderService providerService, ProductService productService) {
        this.consignmentService = consignmentService;
        this.providerService = providerService;
        this.productService = productService;
    }

    /**
     * Список приходных накладных
     * @param model
     * @return
     */
    @GetMapping("/in")
    public String viewConsignmen(Model model) {
        List<ConsignmentDTO> list = consignmentService.getConsignmentList();
        model.addAttribute("list", list);
        return "consignment/consignment_list";
    }

    @RequestMapping("/new")
    public String formConsignmen(Model model) {
        Consignment consignment = new Consignment();
        List<Provider> providers = providerService.getProviderList();
        List<Product> products = productService.products();

        model.addAttribute("consignment", consignment);
        model.addAttribute("providers", providers);
        model.addAttribute("products", products);
        return "consignment/new_consignment";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("consignment") Consignment consignment) {
        consignmentService.createConsignment(consignment);
        return "redirect:/consignment/in";
    }

    //---------------------------------- Списание -------------------------------------------

    /**
     * Список приходных накладных
     * @param model
     * @return
     */
    @GetMapping("/out")
    public String viewCancellation(Model model) {
        List<ConsignmentDTO> list = consignmentService.getCancellationList();
        model.addAttribute("list", list);
        return "consignment/cancellation_list";
    }

    @RequestMapping("/new-cancellation")
    public String formCancellation(Model model) {
        Consignment consignment = new Consignment();
        List<Provider> providers = providerService.getProviderList();
        List<Product> products = productService.products();

        model.addAttribute("consignment", consignment);
        model.addAttribute("providers", providers);
        model.addAttribute("products", products);
        return "consignment/cancellation_new";
    }

    @RequestMapping(value = "/save-cancellation", method = RequestMethod.POST)
    public String saveCancellation(@ModelAttribute("consignment") Consignment consignment) {
        consignmentService.createCancellation(consignment);
        return "redirect:/consignment/out";
    }
}
