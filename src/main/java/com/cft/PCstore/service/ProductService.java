package com.cft.PCstore.service;

import com.cft.PCstore.model.*;
import com.cft.PCstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public Product getById(Long id) throws ChangeSetPersister.NotFoundException {
        return productRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new); //TODO Exception
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Long id, Product product) throws ChangeSetPersister.NotFoundException {
        Product productFromDB = getById(id);
        if(productFromDB.getClass() == product.getClass()){
            product.setId(id);
            productRepository.save(product);
        }
    }


}
