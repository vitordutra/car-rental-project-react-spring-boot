package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import org.junit.experimental.categories.Categories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private String descricao;


    private List<CategoryDto> categories = new ArrayList<>();

    public ProductDto() {
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

    // Outro construtor que recebe o objeto e a lista de categorias
    public ProductDto(Product entity, Set<Category> categories) { // 0 1 2 cat
        this(entity);
        categories.forEach(cat -> this.categories.add(new CategoryDto(cat)));
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

    public List<CategoryDto> getCategories() {
        return categories;
    }


}
