package com.dh.projetointegradorv1._equipe4.dh_carshop.repository;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

}