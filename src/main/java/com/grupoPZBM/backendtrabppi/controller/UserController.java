package com.grupoPZBM.backendtrabppi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.grupoPZBM.backendtrabppi.dto.UserDto;
import com.grupoPZBM.backendtrabppi.entity.User;
import com.grupoPZBM.backendtrabppi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")
class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        try {
            List<User> items = new ArrayList<User>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable("id") UUID id) {
        Optional<User> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid UserDto userDto) {
        try {
//            User savedItem = repository.save(userDto);
//            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);

            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable("id") UUID id, @RequestBody User item) {
        Optional<User> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            User existingItem = existingItemOptional.get();
            System.out.println("TODO for developer - update logic is unique to entity and must be implemented manually.");
            //existingItem.setSomeField(item.getSomeField());
            return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") UUID id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}