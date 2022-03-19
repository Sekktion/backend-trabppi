package com.grupoPZBM.backendtrabppi.repository;

import java.util.UUID;

import com.grupoPZBM.backendtrabppi.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, UUID>{


}

