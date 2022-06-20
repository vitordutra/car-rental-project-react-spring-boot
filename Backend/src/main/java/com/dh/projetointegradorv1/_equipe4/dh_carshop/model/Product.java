package com.dh.projetointegradorv1._equipe4.dh_carshop.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serial;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table (name = "products")

public class Product implements Serializable{
    //@Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 300, nullable = false)
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "features_products",
            joinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_caracteristica", referencedColumnName = "id")
    )
    Set<Feature> caracteristicas = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "images_products",
            joinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_imagem", referencedColumnName = "id")
    )
    Set<Image> imagens = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "categories_products",
            joinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    )
    Set<Category> categorias = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    @JsonIgnoreProperties("products")
    private City cidade;

    //Timestamps Automáticos

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant criado; // Antes: OffsetDateTime
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Instant atualizado;

    @PrePersist
    public void antesDeSalvar() {
        criado = Instant.now();
    }

    @PreUpdate
    public void antesDeAtualizar() {
        atualizado = Instant.now();
    }

    public Integer getId() {   return id; }
    public void setId(Integer id) {  this.id = id;}

    public String getNome() {   return nome; }
    public void setNome(String nome) {  this.nome = nome; }

    public String getDescricao() {   return descricao; }
    public void setDescricao(String descricao) {  this.descricao = descricao; }

    public Set<Feature> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<Feature> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Set<Image> getImagens() {
        return imagens;
    }

    public void setImagens(Set<Image> imagens) {
        this.imagens = imagens;
    }

    public Set<Category> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Category> categorias) {
        this.categorias = categorias;
    }

    public City getCidade() {
        return cidade;
    }

    public void setCidade(City cidade) {
        this.cidade = cidade;
    }

    public Instant getCriado() {
        return criado;
    }

    public Instant getAtualizado() {
        return atualizado;
    }

}
