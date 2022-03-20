package com.grupoPZBM.backendtrabppi.service;


import com.grupoPZBM.backendtrabppi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
}
