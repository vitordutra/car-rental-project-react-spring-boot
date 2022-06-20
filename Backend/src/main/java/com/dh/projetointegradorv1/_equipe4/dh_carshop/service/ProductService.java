package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.CategoryDTO;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.ProductDTO;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.ProductDTO;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.CategoryRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ProductRepository;
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
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Transactional
    public List<ProductDTO> findAll() {
        List<ProductDTO> listDTO = new ArrayList<>();
        List<Product> list = productRepository.findAll();
        for (Product product : list) {
            ProductDTO dto = new ProductDTO(product);
            listDTO.add(dto);
        }
        return listDTO;
    }

    @Transactional
    public ProductDTO findById(Integer id) {
        Optional<Product> obj = productRepository.findById(id);
        Product entity = obj.orElseThrow(() -> new RuntimeException("ENTIDADE NÃO ENCONTRADA"));
        return new ProductDTO(entity, entity.getCategorias());
    }

    @Transactional
    public ProductDTO save(ProductDTO dto) {
        Product entity = new Product();
        copyToEntity(dto, entity);
        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO editById(Integer id, ProductDTO dto) {
        try {
            Product entity = productRepository.getById(id.intValue());
            copyToEntity(dto, entity);
            entity = productRepository.save(entity);
            return new ProductDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new RuntimeException("ID NÃO ENCONTRADO: " + id);
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        try {
            productRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("ID NÃO ENCONTRADO: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new RuntimeException("VIOLAÇÃO DE INTEGRIDADE");
        }
    }

    public void copyToEntity(ProductDTO dto, Product entity) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());

        entity.getCategorias().clear();
        for(CategoryDTO catDto : dto.getCategorias()) {
            Category categories = categoryRepository.getById(catDto.getId());
            entity.getCategorias().add(categories);
        }
    }
}
