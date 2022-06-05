package com.dh.projetointegradorv1._equipe4.dh_carshop.controller;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.City;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/cities")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<City> createCity(@RequestBody City city) {
        return ResponseEntity.status(201).body(cityService.createCity(city));
    }

    @GetMapping("/cities")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<City>> listAllCities(@RequestBody City city) {
        return ResponseEntity.ok(cityService.listAllCities());
    }

}
