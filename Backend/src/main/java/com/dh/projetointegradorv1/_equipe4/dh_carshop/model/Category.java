package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;


@Entity

public class Category {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String qualificacao;
    private String descricao;

    // Timestamps automáticos
    @Column(columnDefinition = "TIMESTAMP")
    private Instant criado;
    @Column(columnDefinition = "TIMESTAMP")
    private Instant atualizado;

    @PrePersist
    public void AntesDeSalvar() {
        criado = Instant.now();
    }

    @PreUpdate
    public void AntesDeAtualizar() {
        atualizado = Instant.now();
    }

    public Category() {
    }

    public Category(Integer id, String qualificacao, String descricao) {
        this.id = id;
        this.qualificacao = qualificacao;
        this.descricao = descricao;
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

    public void setCriado(Instant criado) {
        this.criado = criado;
    }

    public void setAtualizado(Instant atualizado) {
        this.atualizado = atualizado;
    }

}
