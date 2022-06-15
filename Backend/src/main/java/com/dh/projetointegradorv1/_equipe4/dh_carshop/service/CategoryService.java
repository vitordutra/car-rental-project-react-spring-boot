package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.CategoryDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.ProductDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Image;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.CategoryRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ImageRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Transactional
    public CategoryDto createCategory(CategoryDto dto) {
        Category entity = new Category();
        copyToEntity(dto, entity);
        entity = categoryRepository.save(entity);
        return new CategoryDto(entity);
    }

    @Transactional(readOnly = true)
    public List<CategoryDto> listAllCategories() {
        List<CategoryDto> listDto = new ArrayList<>();
        List<Category> list = categoryRepository.findAll();
        for(Category cat : list) {
            CategoryDto dto = new CategoryDto(cat);
            listDto.add(dto);
        }
        return listDto;
    }

    @Transactional(readOnly = true)
    public CategoryDto findCategoryById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id);
        Category entity = obj.orElseThrow(() -> new RuntimeException());
        return new CategoryDto(entity, entity.getProdutos(), entity.getImagem());
    }

    @Transactional
    public CategoryDto updateCategoryById(Integer id, CategoryDto dto) {
        try {
            Optional<Category> obj = categoryRepository.findById(id);
            Category entity = obj.orElseThrow(() -> new RuntimeException());
            copyToEntity(dto, entity);
            entity = categoryRepository.save(entity);
            return new CategoryDto(entity);
        }
        catch (EntityNotFoundException e) {
            throw new RuntimeException();
        }

        /*return categoryRepository.findById(id)
                .map(categoryToUpdate -> {
                    categoryToUpdate.setDescricao(category.getDescricao());
                    categoryToUpdate.setTitulo(category.getTitulo());
                    return categoryRepository.save(categoryToUpdate);
                }).orElseGet(() -> {
                    category.setId(id);
                    return categoryRepository.save(category);
                });*/
    }

    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }

    public void copyToEntity(CategoryDto dto, Category entity) {
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.getProdutos().clear();
        for(ProductDto prodDto : dto.getProdutos()) {
            Optional<Product> obj = productRepository.findById(prodDto.getId());
            Product product = obj.orElseThrow(() -> new RuntimeException());
            entity.getProdutos().add(product);
        }
        Optional<Image> obj = imageRepository.findById(dto.getImagem().getId());
        Image imagem = obj.orElseThrow(() -> new RuntimeException());
        entity.setImagem(imagem);
    }
}
