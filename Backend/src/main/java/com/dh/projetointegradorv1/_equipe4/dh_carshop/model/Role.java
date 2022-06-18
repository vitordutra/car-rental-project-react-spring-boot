package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Set;


@Entity
@Table
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;


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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<User> users;

    public Role() {
    }

    public Role(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Instant getCriado() {
        return criado;
    }

    public void setCriado(Instant criado) {
        this.criado = criado;
    }

    public Instant getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(Instant atualizado) {
        this.atualizado = atualizado;
    }
}
