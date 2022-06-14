package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Feature;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public Feature createFeature(Feature feature) { return featureRepository.save(feature); }

    public Optional<Feature> findFeatureById(Integer id) {
        return featureRepository.findById(id);
    }

    public List<Feature> findAllFeatures() {
        return featureRepository.findAll();
    }

    public void deleteFeatureById(Integer id) {
        featureRepository.deleteById(id);
    }
}
