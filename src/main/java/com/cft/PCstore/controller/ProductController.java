package com.cft.PCstore.controller;

import com.cft.PCstore.model.Product;
import com.cft.PCstore.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "product")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "{id}")
    public Product getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @DeleteMapping(value = "{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
