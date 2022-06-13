package com.dh.projetointegradorv1._equipe4.dh_carshop.controller;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Feature;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FeatureController {
    @Autowired
    FeatureService featureService;

    @PostMapping("/features")
    public ResponseEntity<Feature> createFeature(@RequestBody Feature feature) {
        return ResponseEntity.status(201).body(featureService.createFeature(feature));
    }

    @GetMapping("/features")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Feature>> findAllFeatures() {
        return ResponseEntity.ok(featureService.findAllFeatures());
    }

    @GetMapping("/features/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Feature> findFeatureById(@PathVariable Integer id) {
        return ResponseEntity.ok(featureService.findFeatureById(id));
    }

    @DeleteMapping("/features/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteFeatureById(@PathVariable(value = "id") Integer id) {
        featureService.deleteFeatureById(id);
        return ResponseEntity.ok("Deleted");
    }
}
