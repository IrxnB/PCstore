package com.cft.PCstore.controller;

import com.cft.PCstore.model.*;
import com.cft.PCstore.service.ProductService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping()
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "product/{id}")
    public Product getById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return productService.getById(id);
    }

    @DeleteMapping(value = "product/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


    @GetMapping(value = "laptop")
    public List<Laptop> getAllLaptops(){
        return getAllOfType(Laptop.class);
    }
    @GetMapping(value = "desktop")
    public List<Desktop> getAllDesktops(){
        return getAllOfType(Desktop.class);
    }
    @GetMapping(value = "hdd")
    public List<HardDrive> getAllHardDrives(){
        return getAllOfType(HardDrive.class);
    }
    @GetMapping(value = "monitor")
    public List<Monitor> getAllOfType(){
        return getAllOfType(Monitor.class);
    }

    @PostMapping
    public void addLaptop(@RequestBody Laptop product) {
        productService.addProduct(product);
    }

    @PutMapping(value = "{id}")
    public void updateLaptop(@PathVariable Long id, @RequestBody Laptop product) throws ChangeSetPersister.NotFoundException {
        productService.updateProduct(id, product);
    }

    private <T> List<T> getAllOfType(Class<T> type) {
        return productService.getAll().
                stream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());
    }
}
