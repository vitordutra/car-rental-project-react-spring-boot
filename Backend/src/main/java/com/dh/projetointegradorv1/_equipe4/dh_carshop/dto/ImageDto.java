package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Feature;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Image;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ImageDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;
    private String url;
    private List<ProductDto> produtos = new ArrayList<>();
    private CategoryDto categoria;
    private FeatureDto caracteristica;

    public ImageDto() {

    }

    public ImageDto(Integer id, String titulo, String url) {
        this.id = id;
        this.titulo = titulo;
        this.url = url;
    }

    public ImageDto(Image entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        url = entity.getUrl();
    }

    public ImageDto(Image entity, Set<Product> produtos, Category categoria, Feature caracteristica) {
        this(entity);
        produtos.forEach(prod -> this.produtos.add(new ProductDto(prod)));
        this.categoria = new CategoryDto(categoria);
        this.caracteristica = new FeatureDto(caracteristica);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ProductDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProductDto> produtos) {
        this.produtos = produtos;
    }

    public CategoryDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoryDto categoria) {
        this.categoria = categoria;
    }

    public FeatureDto getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(FeatureDto caracteristica) {
        this.caracteristica = caracteristica;
    }
}
