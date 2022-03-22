package com.grupoPZBM.backendtrabppi.service;

import com.grupoPZBM.backendtrabppi.model.userModel;
import com.grupoPZBM.backendtrabppi.repository.productRepository;
import com.grupoPZBM.backendtrabppi.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class userService {

    @Autowired
    private userRepository userRepository;

    @Transactional
    public userModel save(userModel userModel){
        return userRepository.save(userModel);
    }

    public List<userModel> findAll(){
        return userRepository.findAll();
    }

    public boolean findByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public boolean findByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public boolean findByPhoneNum(String phoneNum){
        return userRepository.existsByPhoneNum(phoneNum);
    }

    public Optional<userModel> findById(UUID id){
        return userRepository.findById(id);
    }

    @Transactional
    public void delete(userModel user){
        userRepository.delete(user);
    }
}
