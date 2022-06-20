package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.CategoryDTO;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.ProductDTO;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.CategoryRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<CategoryDTO> findAll() {
        List<CategoryDTO> listDTO = new ArrayList<>();
        List<Category> list = categoryRepository.findAll();
        for (Category category : list) {
            CategoryDTO dto = new CategoryDTO(category);
            listDTO.add(dto);
        }
        return listDTO;
    }

    @Transactional
    public CategoryDTO findById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id);
        Category entity = obj.orElseThrow(() -> new RuntimeException("ENTIDADE NÃO ENCONTRADA"));
        return new CategoryDTO(entity, entity.getProdutos());
    }

    @Transactional
    public CategoryDTO save(CategoryDTO dto) {
        Category entity = new Category();
        copyToEntity(dto, entity);
        entity = categoryRepository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO editById(Integer id, CategoryDTO dto) {
        try {
            Category entity = categoryRepository.getById(id);
            copyToEntity(dto, entity);
            entity = categoryRepository.save(entity);
            return new CategoryDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new RuntimeException("ID NÃO ENCONTRADO: " + id);
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        try {
            categoryRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("ID NÃO ENCONTRADO: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new RuntimeException("VIOLAÇÃO DE INTEGRIDADE");
        }
    }

    public void copyToEntity(CategoryDTO dto, Category entity) {
        entity.setQualificacao(dto.getQualificacao());
        entity.setDescricao(dto.getDescricao());
        entity.setUrl_imagem(dto.getUrl_imagem());


        entity.getProdutos().clear();
        for(ProductDTO prodDto : dto.getProdutos()) {
            Product products = productRepository.getById(prodDto.getId());
            entity.getProdutos().add(products);
        }
    }
}
