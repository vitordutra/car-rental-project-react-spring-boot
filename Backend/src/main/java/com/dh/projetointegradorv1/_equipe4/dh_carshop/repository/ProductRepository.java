package com.dh.projetointegradorv1._equipe4.dh_carshop.repository;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM products p WHERE p.id_cidade = ?1", nativeQuery = true)
    List<Product> findByCidade(Integer id);

    /*@Query(value = "SELECT * FROM products p" +
            "INNER JOIN categories_products cp ON p.id_produto = cp.id_produto" +
            "WHERE cp.id_categoria = ?1", nativeQuery = true)
    List<Product> findByCategoria(Integer id);*/
}