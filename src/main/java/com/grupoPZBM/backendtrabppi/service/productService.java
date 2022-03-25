package com.grupoPZBM.backendtrabppi.service;

import com.grupoPZBM.backendtrabppi.model.Product;
import com.grupoPZBM.backendtrabppi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class productService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product save(Product productModel){
        return productRepository.save(productModel);
    }

    public List<Product> findALl(){
        return productRepository.findAll();
    }

    public Optional<Product> findByID(UUID id){
        return productRepository.findById(id);
    }

    @Transactional
    public void delete(Product product){
        productRepository.delete(product);
    }

}
