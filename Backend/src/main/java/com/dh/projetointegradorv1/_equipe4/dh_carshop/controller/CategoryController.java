package com.dh.projetointegradorv1._equipe4.dh_carshop.controller;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.CategoryDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.CategoryService;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<CategoryDto>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "3") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<CategoryDto> list = categoryService.findAllPage(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Integer id) {
        try {
            CategoryDto dto = categoryService.findById(id);
            return ResponseEntity.ok().body(dto);
        } catch (RecursoNaoEncontrado e) {
            return ResponseEntity.status(404).body(new CategoryDto());
        }




    }

    @PostMapping
    public ResponseEntity<CategoryDto> insert(@RequestBody CategoryDto dto) {
        dto = categoryService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable Integer id, @RequestBody CategoryDto dto) throws RecursoNaoEncontrado {
        dto = categoryService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws RecursoNaoEncontrado {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
