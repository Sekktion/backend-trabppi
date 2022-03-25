package com.grupoPZBM.backendtrabppi.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.grupoPZBM.backendtrabppi.dto.UserDto;
import com.grupoPZBM.backendtrabppi.exception.UserException;
import com.grupoPZBM.backendtrabppi.model.User;

import com.grupoPZBM.backendtrabppi.service.productService;
import com.grupoPZBM.backendtrabppi.service.userService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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



    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping // Rota para listar usuários (puramente para teste)
    public ResponseEntity<List<User>> listAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }


    @GetMapping("/{id}") // Rota para listar usuário por id
    public ResponseEntity<Object> listOneUser(@PathVariable (value = "id") UUID id){
        Optional<User> user = userService.findById(id);
        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @PutMapping("/{id}") // Rota para mudar infos do usuário no BD
    public ResponseEntity<Object> updateUser(@PathVariable (value = "id") UUID id,
                                             @RequestBody @Valid UserDto userDto){
        Optional<User> user = userService.findById(id);
        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        var updatedUser = new User();
        BeanUtils.copyProperties(userDto, updatedUser);

        updatedUser.setId(user.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(userService.save(updatedUser));
    }

    @DeleteMapping("/{id}") // Rota para apagar usuário e todos os seus produtos do BD.
    public ResponseEntity<Object> deleteUser(@PathVariable (value = "id") UUID id){

        Optional<User> user = userService.findById(id);
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