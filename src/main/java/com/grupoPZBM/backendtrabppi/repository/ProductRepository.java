package com.grupoPZBM.backendtrabppi.repository;

import java.util.UUID;

import com.grupoPZBM.backendtrabppi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}

