package com.grupoPZBM.backendtrabppi.repository;

import java.util.UUID;

import com.grupoPZBM.backendtrabppi.model.productModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends CrudRepository<productModel, UUID>{
}

