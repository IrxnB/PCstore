package com.cft.PCstore.controller;

import com.cft.PCstore.model.Product;
import com.cft.PCstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class SubclassController<T extends Product> {
    ProductService productService;

    @Autowired
    public SubclassController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<?> getAllOfType(){
        Class<?> type = GenericTypeResolver.resolveTypeArgument(getClass(), SubclassController.class);
        return productService.getAll()
                .stream()
                .filter(Objects.requireNonNull(type)::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void addLaptop(@RequestBody T product) {
        productService.addProduct(product);
    }

    @PutMapping(value = "{id}")
    public void updateLaptop(@PathVariable Long id, @RequestBody T product) {
        productService.updateProduct(id, product);
    }

}
