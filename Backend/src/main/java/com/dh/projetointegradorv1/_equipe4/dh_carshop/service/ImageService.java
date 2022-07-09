package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.*;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.*;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.CategoryRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.FeatureRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ImageRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ProductRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FeatureRepository featureRepository;

    @Transactional
    public ImageDto createImage(ImageDto dto) {
        Image entity = new Image();
        copyToEntity(dto, entity);
        entity = imageRepository.save(entity);
        return new ImageDto(entity);
    }

    @Transactional(readOnly = true)
    public ImageDto findImageById(Integer id) {
        Optional<Image> obj = imageRepository.findById(id);
        Image entity = obj.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
        return new ImageDto(entity, entity.getProdutos(), entity.getCategoria(), entity.getCaracteristica());
    }

    public void copyToEntity(ImageDto dto, Image entity) {
        entity.setTitulo(dto.getTitulo());
        entity.setUrl(dto.getUrl());
        if (entity.getProdutos() != null) {
            entity.getProdutos().clear();
        }

        for(ProductDto prodDto : dto.getProdutos()) {
            Optional<Product> obj = productRepository.findById(prodDto.getId());
            Product product = obj.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
            entity.getProdutos().add(product);
        }

        if (dto.getCategoria() != null) {
            Optional<Category> obj1 = categoryRepository.findById(dto.getCategoria().getId());
            Category category = obj1.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
            entity.setCategoria(category);
        }

        if (dto.getCaracteristica() != null) {
            Optional<Feature> obj2 = featureRepository.findById(dto.getCaracteristica().getId());
            Feature feature = obj2.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
            entity.setCaracteristica(feature);
        }

    }

}
