package com.cft.PCstore.controller;

import com.cft.PCstore.model.Laptop;
import com.cft.PCstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "laptop")
public class LaptopController extends SubclassController<Laptop>{

    @Autowired
    public LaptopController(ProductService productService) {
        super(productService);
    }
}
