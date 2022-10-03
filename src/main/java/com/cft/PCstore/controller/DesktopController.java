package com.cft.PCstore.controller;

import com.cft.PCstore.model.Desktop;
import com.cft.PCstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "desktop")
public class DesktopController extends SubclassController<Desktop>{
    @Autowired
    public DesktopController(ProductService productService) {
        super(productService);
    }
}
