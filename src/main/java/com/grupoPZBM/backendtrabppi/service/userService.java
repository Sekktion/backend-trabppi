package com.grupoPZBM.backendtrabppi.service;

import com.grupoPZBM.backendtrabppi.exception.UserException;
import com.grupoPZBM.backendtrabppi.model.User;
import com.grupoPZBM.backendtrabppi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class userService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User user){
        boolean foundEmail = userRepository.existsByEmail(user.getEmail());
        boolean foundUsername = userRepository.existsByUsername((user.getUsername()));
        if(foundEmail || foundUsername ) {
            throw new UserException("Já existe um usuário com este nome");
        }
        return userRepository.save(user);
    }

    public List<User> findAll(){
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

    public Optional<User> findById(UUID id){
        return userRepository.findById(id);
    }

    @Transactional
    public void delete(User user){
        userRepository.delete(user);
    }
}
