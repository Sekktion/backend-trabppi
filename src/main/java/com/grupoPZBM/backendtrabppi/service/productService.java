package com.grupoPZBM.backendtrabppi.service;

import com.grupoPZBM.backendtrabppi.model.productModel;
import com.grupoPZBM.backendtrabppi.model.userModel;
import com.grupoPZBM.backendtrabppi.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class productService {

    @Autowired
    private productRepository productRepository;

    @Transactional
    public productModel save(productModel productModel){
        return productRepository.save(productModel);
    }

    public List<productModel> findALl(){
        return productRepository.findAll();
    }

    public Optional<productModel> findByID(UUID id){
        return productRepository.findById(id);
    }

    @Transactional
    public void delete(productModel product){
        productRepository.delete(product);
    }

}
