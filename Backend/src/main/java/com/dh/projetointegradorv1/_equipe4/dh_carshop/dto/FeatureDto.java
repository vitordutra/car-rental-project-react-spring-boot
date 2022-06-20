package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Feature;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Image;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FeatureDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private List<ProductDto> produtos = new ArrayList<>();
    private ImageDto imagem;
    //private String icone;

    public FeatureDto() {

    }

    public FeatureDto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    /*public FeatureDto(Integer id, String nome, String icone) {
        this.id = id;
        this.nome = nome;
        this.icone = icone;
    }*/

    public FeatureDto(Feature entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

    /*public FeatureDto(Feature entity) {
        id = entity.getId();
        nome = entity.getNome();
        icone = entity.getIcone();
    }*/

    public FeatureDto(Feature entity, Set<Product> produtos, Image imagem) {
        this(entity);
        produtos.forEach(prod -> this.produtos.add(new ProductDto(prod)));
        this.imagem = new ImageDto(imagem);
    }

    /*public FeatureDto(Feature entity, Set<Product> produtos) {
        this(entity);
        produtos.forEach(prod -> this.produtos.add(new ProductDto(prod)));
    }*/

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

    public List<ProductDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProductDto> produtos) {
        this.produtos = produtos;
    }

    public ImageDto getImagem() {
        return imagem;
    }

    public void setImagem(ImageDto imagem) {
        this.imagem = imagem;
    }

    /*public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }*/
}
