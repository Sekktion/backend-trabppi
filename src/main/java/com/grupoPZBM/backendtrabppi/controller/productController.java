package com.grupoPZBM.backendtrabppi.controller;

import com.grupoPZBM.backendtrabppi.dto.productDto;
import com.grupoPZBM.backendtrabppi.model.productModel;
import com.grupoPZBM.backendtrabppi.model.userModel;
import com.grupoPZBM.backendtrabppi.service.productService;
import com.grupoPZBM.backendtrabppi.service.userService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class productController {

    @Autowired
    private productService productService;

    @Autowired
    private userService userService;

    @PostMapping // Rota para criar produto no BD.
    public ResponseEntity<Object> createProduct(@RequestBody @Valid productDto productDto){

        Optional<userModel> user = userService.findById(productDto.getUserID());

        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tentando postar um produto sem um usuário válido.");
        }

        productModel product = new productModel();

        BeanUtils.copyProperties(productDto, product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @GetMapping // Rota para listar todos os produtos do BD.
    public ResponseEntity<List<productModel>> listAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findALl());
    }

    @GetMapping ("/{id}")// Rota para listar um produto por ID do BD.
    public ResponseEntity<Object> listOneProduct(@PathVariable (value = "id") UUID id){
        Optional<productModel> product = productService.findByID(id);
        if(!product.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PutMapping ("/{id}") // Rota para alterar informações de um produto do BD.
    public ResponseEntity<Object> updateProduct(@PathVariable (value = "id") UUID id,
                                                @RequestBody @Valid productDto productDto){
        Optional<productModel> product = productService.findByID(id);
        if(!product.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        productModel updatedProduct = new productModel();

        BeanUtils.copyProperties(productDto, updatedProduct);
        updatedProduct.setId(product.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(productService.save(updatedProduct));
    }

    @DeleteMapping ("/{id}") // Rota para deletar um produto do BD.
    public ResponseEntity<Object> deleteProduct(@PathVariable (value = "id") UUID id){
        Optional<productModel> product = productService.findByID(id);
        if(!product.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        productService.delete(product.get());
        return ResponseEntity.status(HttpStatus.OK).body("Listagem de produto removida.");
    }
}