package com.grupoPZBM.backendtrabppi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("products")
public class ProductController {

    @PostMapping("/")
    public String create(@RequestParam(value = "name", defaultValue = "mundo")String name) {
        String template = "Olá %s, deu certo. O app está rodando.";
        return String.format(template, name);
    }



}
