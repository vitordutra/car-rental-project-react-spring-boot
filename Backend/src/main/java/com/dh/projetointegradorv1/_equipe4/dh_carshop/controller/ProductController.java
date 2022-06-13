package com.dh.projetointegradorv1._equipe4.dh_carshop.controller;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productService.create(product));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> findALl() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Product>> findById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }
}