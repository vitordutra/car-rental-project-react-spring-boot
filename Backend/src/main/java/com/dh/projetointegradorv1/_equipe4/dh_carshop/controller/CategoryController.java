package com.dh.projetointegradorv1._equipe4.dh_carshop.controller;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.status(201).body(categoryService.createCategory(category));
    }

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Category>> findAllCategories() {
        return ResponseEntity.ok(categoryService.listAllCategories());
    }

    @GetMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Category> findCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.findCategoryById(id));
    }

    @PutMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Category> updateCategoryById(@PathVariable(value = "id") Integer id, @RequestBody Category category) {
        return ResponseEntity.ok().body(categoryService.updateCategoryById(category, id));
    }

    @DeleteMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteCategoryById(@PathVariable(value = "id") Integer id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok("Deleted");
    }
}
