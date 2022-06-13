package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.CategoryDTO;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.CategoryRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<CategoryDTO> findById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new ObjectNotFoundException("Object not found!");
        }
        CategoryDTO categoria = new CategoryDTO();

        categoria.setDescricao(categoria.getDescricao());
        categoria.setUrlImagem(categoria.getUrlImagem());
        categoria.setId(categoria.getId());
        categoria.setQualificacao(categoria.getQualificacao());

        return Optional.of(categoria);
    }

    public Category updateById(Category category, Integer id) {
        return categoryRepository.findById(id)
                .map(categoryToUpdate -> {
                    categoryToUpdate.setDescricao(category.getDescricao());
                    categoryToUpdate.setQualificacao(category.getQualificacao());
                    categoryToUpdate.setUrl_imagem(category.getUrl_imagem());
                    return categoryRepository.save(categoryToUpdate);
                }).orElseGet(() -> {
                    category.setId(id);
                    return categoryRepository.save(category);
                });
    }

    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
