package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.City;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CityDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String estado;
    //private List<ProductDto> produtos = new ArrayList<>();

    public CityDto() {

    }

    public CityDto(Integer id, String nome, String estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public CityDto(City entity) {
        id = entity.getId();
        nome = entity.getNome();
        estado = entity.getEstado();
    }

    /*public CityDto(City entity, Set<Product> produtos) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*public List<ProductDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProductDto> produtos) {
        this.produtos = produtos;
    }*/
}
