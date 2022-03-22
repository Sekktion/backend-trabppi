package com.grupoPZBM.backendtrabppi.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.grupoPZBM.backendtrabppi.dto.userDto;
import com.grupoPZBM.backendtrabppi.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends CrudRepository<userModel, UUID>{

    public userModel save(userDto userDto);

    public boolean existsByUsername(String username);

    public boolean existsByEmail(String email);

    public boolean existsByPhoneNum(String phoneNum);

    public List<userModel> findAll();

    public Optional<userModel> findById(UUID id);

}

