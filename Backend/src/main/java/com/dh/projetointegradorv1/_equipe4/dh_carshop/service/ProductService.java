package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product updateById(Product editedProduct, Integer id) {

        return productRepository.findById(id)
                .map(product -> {
                    product.setNome(editedProduct.getNome());
                    product.setDescricao(editedProduct.getDescricao());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    editedProduct.setId(id);
                    return productRepository.save(editedProduct);
                });
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }
}
