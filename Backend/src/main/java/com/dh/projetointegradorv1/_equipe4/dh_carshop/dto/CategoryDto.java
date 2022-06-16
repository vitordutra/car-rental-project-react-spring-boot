package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;


import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import org.junit.experimental.categories.Categories;

import java.io.Serializable;

public class CategoryDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String qualificacao;
    private String descricao;

    public CategoryDto() {
    }

    public CategoryDto(Integer id, String qualificacao, String descricao) {
        this.id = id;
        this.qualificacao = qualificacao;
        this.descricao = descricao;
    }

    public CategoryDto(Category category) {
        id = category.getId();
        qualificacao = category.getQualificacao();
        descricao = category.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQualificacao() {
        return qualificacao;
    }

    public void setQualificacao(String qualificacao) {
        this.qualificacao = qualificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
