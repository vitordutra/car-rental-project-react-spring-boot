package com.dh.projetointegradorv1._equipe4.dh_carshop.controller;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.ProductDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.User;
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
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto) {
        return ResponseEntity.status(201).body(productService.createProduct(dto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return ResponseEntity.ok(productService.listAllProducts());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDto> findProductById(@PathVariable(value = "id") Integer id) {
        ProductDto dto = productService.findProductById(id);
        return ResponseEntity.ok().body(dto);

        /*return productService.findProductById(id).map(product -> {
            return ResponseEntity.ok().body(product);
        }).orElseGet(() -> {
            return ResponseEntity.status(404).body(new Product());
        });*/
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDto> editProductById(@PathVariable(value = "id") Integer id, @RequestBody ProductDto dto) {
        return ResponseEntity.ok().body(productService.editProductById(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteProductById(@PathVariable(value = "id") Integer id) {
        productService.deleteProductById(id);
        return ResponseEntity.status(204).body("");
    }

    /*@GetMapping("products/city/{name}")
    public ResponseEntity<List<Product>> findProductByCity(@PathVariable String name) {
        return ResponseEntity.ok(productService.findProductByCity(name));
    }

    @GetMapping("products/category/{title}")
    public ResponseEntity<List<Product>> findProductByCategory(@PathVariable String title) {
        return ResponseEntity.ok(productService.findProductByCategory(title));
    }*/
}