package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Integer id) {
        return productRepository.getById(id);
    }

    public Product editProductById(Product editedProduct, Integer id) {

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

    public List<Product> findProductByCity(String name) {
        return productRepository.findByCidadeNome(name);
    }

    public List<Product> findProductByCategory(String title) {
        return productRepository.findByCategoriaTitulo(title);
    }
}
