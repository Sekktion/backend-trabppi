package com.grupoPZBM.backendtrabppi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.grupoPZBM.backendtrabppi.dto.userDto;
import com.grupoPZBM.backendtrabppi.model.productModel;
import com.grupoPZBM.backendtrabppi.model.userModel;
import com.grupoPZBM.backendtrabppi.repository.userRepository;

import com.grupoPZBM.backendtrabppi.service.productService;
import com.grupoPZBM.backendtrabppi.service.userService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @Autowired
    private productService productService;

    @PostMapping // Rota para criação de usuário
    public ResponseEntity<Object> createUser(@RequestBody @Valid userDto userDto) {
        if(userService.findByUsername(userDto.getUsername())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Usuário já cadastrado.");
        }
        if(userService.findByEmail(userDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Email já cadastrado.");
        }
        if(userService.findByPhoneNum(userDto.getPhoneNum())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Número de telefone já cadastrado.");
        }

        userModel userModel = new userModel();

        BeanUtils.copyProperties(userDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping // Rota para listar usuários (puramente para teste)
    public ResponseEntity<List<userModel>> listAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }


    @GetMapping("/{id}") // Rota para listar usuário por id
    public ResponseEntity<Object> listOneUser(@PathVariable (value = "id") UUID id){
        Optional<userModel> user = userService.findById(id);
        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @PutMapping("/{id}") // Rota para mudar infos do usuário no BD
    public ResponseEntity<Object> updateUser(@PathVariable (value = "id") UUID id,
                                             @RequestBody @Valid userDto userDto){
        Optional<userModel> user = userService.findById(id);
        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        var updatedUser = new userModel();
        BeanUtils.copyProperties(userDto, updatedUser);

        updatedUser.setId(user.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(userService.save(updatedUser));
    }

    @DeleteMapping("/{id}") // Rota para apagar usuário e todos os seus produtos do BD.
    public ResponseEntity<Object> deleteUser(@PathVariable (value = "id") UUID id){

        Optional<userModel> user = userService.findById(id);
        if(!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

//        int counter = 0;
//        while(counter < user.get().getProducts().size()){
//            productService.delete(productService.findByID(user.get().getProducts().toArray()[counter]));
//        }


        userService.delete(user.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário removido com sucesso");
    }
}