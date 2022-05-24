package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    public ResponseEntity<Category> findCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .map(category -> ResponseEntity.ok().body(category))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Category> updateCategoryById(Category category, Integer id) {
        return categoryRepository.findById(id)
                .map(categoryToUpdate -> {
                    categoryToUpdate.setDescricao(category.getDescricao());
                    categoryToUpdate.setQualificacao(category.getQualificacao());
                    categoryToUpdate.setUrl_imagem(category.getUrl_imagem());
                    Category updatedCategory = categoryRepository.save(categoryToUpdate);
                    return ResponseEntity.ok().body(updatedCategory);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .map(categoryToDelete -> {
                    categoryRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
