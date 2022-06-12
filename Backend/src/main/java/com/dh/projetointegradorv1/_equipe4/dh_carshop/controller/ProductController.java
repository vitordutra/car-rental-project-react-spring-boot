package com.dh.projetointegradorv1._equipe4.dh_carshop.controller;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.CategoryService;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productService.createProduct(product));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok(productService.listAllProducts());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> findProductById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }
}