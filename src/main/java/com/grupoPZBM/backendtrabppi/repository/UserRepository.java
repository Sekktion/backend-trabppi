package com.grupoPZBM.backendtrabppi.repository;

import java.util.UUID;

import com.grupoPZBM.backendtrabppi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByPhoneNum(String phoneNum);
}

