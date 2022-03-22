package com.grupoPZBM.backendtrabppi.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.grupoPZBM.backendtrabppi.dto.productDto;
import com.grupoPZBM.backendtrabppi.dto.userDto;
import com.grupoPZBM.backendtrabppi.model.productModel;
import com.grupoPZBM.backendtrabppi.model.userModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends CrudRepository<productModel, UUID>{

    public productModel save(productDto productDto);

    public List<productModel> findAll();

    public Optional<productModel> findById(UUID id);

    public void delete(productModel product);

//    public List<productModel> findAllByUser(UUID userID);

}

