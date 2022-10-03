package com.cft.PCstore.controller;

import com.cft.PCstore.model.Monitor;
import com.cft.PCstore.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "monitor")
public class MonitorController extends SubclassController<Monitor>{
    public MonitorController(ProductService productService) {
        super(productService);
    }
}
