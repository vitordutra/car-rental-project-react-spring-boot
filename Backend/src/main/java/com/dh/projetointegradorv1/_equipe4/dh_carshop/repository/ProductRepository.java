package com.dh.projetointegradorv1._equipe4.dh_carshop.repository;


import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // List<Product> findByCidadeNome(String nome);

   // List<Product> findByCategoriaDescricao(String descricao);
}