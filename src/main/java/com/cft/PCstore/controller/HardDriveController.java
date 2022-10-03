package com.cft.PCstore.controller;

import com.cft.PCstore.model.HardDrive;
import com.cft.PCstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hdd")
public class HardDriveController extends SubclassController<HardDrive>{
    @Autowired
    public HardDriveController(ProductService productService) {
        super(productService);
    }
}
