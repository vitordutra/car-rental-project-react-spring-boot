package com.dh.projetointegradorv1._equipe4.dh_carshop.controller;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.User;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productService.createProduct(product));
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok(productService.listAllProducts());
    }

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> findProductById(@PathVariable(value = "id") Integer id) {
        return productService.findProductById(id).map(product -> {
            return ResponseEntity.ok().body(product);
        }).orElseGet(() -> {
            return ResponseEntity.status(404).body(new Product());
        });
    }

    @GetMapping("products/city/{name}")
    public ResponseEntity<List<Product>> findProductByCity(@PathVariable String name) {
        return ResponseEntity.ok(productService.findProductByCity(name));
    }

    @GetMapping("products/category/{title}")
    public ResponseEntity<List<Product>> findProductByCategory(@PathVariable String title) {
        return ResponseEntity.ok(productService.findProductByCategory(title));
    }
}