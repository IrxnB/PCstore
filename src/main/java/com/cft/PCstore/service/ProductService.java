package com.cft.PCstore.service;

import com.cft.PCstore.Exceptions.NotFoundException;
import com.cft.PCstore.model.Product;
import com.cft.PCstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public Product getById(Long id){
        return productRepository.findById(id).orElseThrow(NotFoundException::new);
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

    public void updateProduct(Long id, Product product){
        Product productFromDB = getById(id);
        if(productFromDB.getClass() == product.getClass()){
            product.setId(id);
            productRepository.save(product);
        }else {
            throw new NotFoundException();
        }
    }


}
