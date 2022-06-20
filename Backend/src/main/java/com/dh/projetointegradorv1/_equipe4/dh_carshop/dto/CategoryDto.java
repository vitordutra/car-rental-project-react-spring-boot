package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Image;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
public class CategoryDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;
    private String descricao;
    //private String urlImagem;
    private List<ProductDto> produtos = new ArrayList<>();
    private ImageDto imagem;

    public CategoryDto(Integer id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    /*public CategoryDto(Integer id, String titulo, String descricao, String urlImagem) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.urlImagem = urlImagem;
    }*/

    public CategoryDto(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public CategoryDto(Category entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        descricao = entity.getDescricao();
    }

    /*public CategoryDto(Category entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        descricao = entity.getDescricao();
        urlImagem = entity.getUrlImagem();
    }*/

    public CategoryDto(Category entity, Set<Product> produtos, Image imagem) {
        this(entity);
        produtos.forEach(prod -> this.produtos.add(new ProductDto(prod)));
        this.imagem = new ImageDto(imagem);
    }

    /*public CategoryDto(Category entity, Set<Product> produtos) {
        this(entity);
        produtos.forEach(prod -> this.produtos.add(new ProductDto(prod)));
    }*/
}
