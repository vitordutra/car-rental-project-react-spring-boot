package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String descricao;
    private List<FeatureDto> caracteristicas = new ArrayList<>();
    private List<ImageDto> imagens = new ArrayList<>();
    private List<CategoryDto> categorias = new ArrayList<>();
    private CityDto cidade;

    private ProductDto() {

    }

    public ProductDto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public ProductDto(Product entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
    }

    public ProductDto(Product entity, Set<Feature> caracteristicas, Set<Image> imagens,
                      Set<Category> categorias, City cidade) {
        this(entity);
        caracteristicas.forEach(car -> this.caracteristicas.add(new FeatureDto(car)));
        imagens.forEach(img -> this.imagens.add(new ImageDto(img)));
        categorias.forEach(cat -> this.categorias.add(new CategoryDto(cat)));
        this.cidade = new CityDto(cidade);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<FeatureDto> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<FeatureDto> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<ImageDto> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImageDto> imagens) {
        this.imagens = imagens;
    }

    public List<CategoryDto> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoryDto> categorias) {
        this.categorias = categorias;
    }

    public CityDto getCidade() {
        return cidade;
    }

    public void setCidade(CityDto cidade) {
        this.cidade = cidade;
    }
}
