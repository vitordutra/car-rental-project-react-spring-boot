package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.FeatureDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.ProductDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Feature;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Image;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.FeatureRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ImageRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Transactional
    public FeatureDto createFeature(FeatureDto dto) {
        Feature entity = new Feature();
        copyToEntity(dto, entity);
        entity = featureRepository.save(entity);
        return new FeatureDto(entity);
    }

    @Transactional(readOnly = true)
    public List<FeatureDto> findAllFeatures() {
        List<FeatureDto> listDto = new ArrayList<>();
        List<Feature> list = featureRepository.findAll();
        for(Feature feat : list) {
            FeatureDto dto = new FeatureDto(feat);
            listDto.add(dto);
        }
        return listDto;
    }

    @Transactional(readOnly = true)
    public FeatureDto findFeatureById(Integer id) {
        Optional<Feature> obj = featureRepository.findById(id);
        Feature entity = obj.orElseThrow(() -> new RuntimeException());
        return new FeatureDto(entity, entity.getProdutos(), entity.getImagem());
    }

    public void deleteFeatureById(Integer id) {
        featureRepository.deleteById(id);
    }

    public void copyToEntity(FeatureDto dto, Feature entity) {
        entity.setNome(dto.getNome());
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
