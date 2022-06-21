package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.*;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.*;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.*;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.exceptions.BDExcecao;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public ProductDto createProduct(ProductDto dto) {
        Product entity = new Product();
        copyToEntity(dto, entity);
        entity = productRepository.save(entity);
        return new ProductDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ProductDto> listAllProducts() {
        List<ProductDto> listDto = new ArrayList<>();
        List<Product> list = productRepository.findAll();
        for(Product prod : list) {
            ProductDto dto = new ProductDto(prod);
            listDto.add(dto);
        }
        return listDto;
    }

    @Transactional(readOnly = true)
    public ProductDto findProductById(Integer id) {
        Optional<Product> obj = productRepository.findById(id);
        Product entity = obj.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
        return new ProductDto(entity, entity.getCaracteristicas(), entity.getImagens(),
                entity.getCategorias(), entity.getCidade(), entity.getReservas());
    }

    @Transactional
    public ProductDto editProductById(Integer id, ProductDto dto) {
        try {
            Optional<Product> obj = productRepository.findById(id);
            Product entity = obj.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
            copyToEntity(dto, entity);
            entity = productRepository.save(entity);
            return new ProductDto(entity);
        }
        catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontrado("ID NÃO ENCONTRADO: " + id);
        }

        /*return productRepository.findById(id)
                .map(product -> {
                    product.setNome(editedProduct.getNome());
                    product.setDescricao(editedProduct.getDescricao());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    editedProduct.setId(id);
                    return productRepository.save(editedProduct);
                });*/
    }

    public void deleteProductById(Integer id) {
        try{
            productRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontrado("ID NÃO ENCONTRADO: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new BDExcecao("VIOLAÇÃO DE INTEGRIDADE");
        }
    }

    public void copyToEntity(ProductDto dto, Product entity) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.getCaracteristicas().clear();
        for(FeatureDto featDto : dto.getCaracteristicas()) {
            Optional<Feature> obj = featureRepository.findById(featDto.getId());
            Feature feature = obj.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
            entity.getCaracteristicas().add(feature);
        }
        entity.getImagens().clear();
        for(ImageDto imgDto : dto.getImagens()) {
            Optional<Image> obj = imageRepository.findById(imgDto.getId());
            Image image = obj.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
            entity.getImagens().add(image);
        }
        entity.getCategorias().clear();
        for(CategoryDto catDto : dto.getCategorias()) {
            Optional<Category> obj = categoryRepository.findById(catDto.getId());
            Category category = obj.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
            entity.getCategorias().add(category);
        }
        for(BookingDto bookDto : dto.getReservas()) {
            Optional<Booking> obj = bookingRepository.findById(bookDto.getId());
            Booking booking = obj.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
            entity.getReservas().add(booking);
        }
        Optional<City> obj = cityRepository.findById(dto.getCidade().getId());
        City city = obj.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
        entity.setCidade(city);
    }

    /*public List<Product> findProductByCity(String name) {
        return productRepository.findByCidadeNome(name);
    }

    public List<Product> findProductByCategory(String title) {
        return productRepository.findByCategoriaTitulo(title);
    }*/
}
