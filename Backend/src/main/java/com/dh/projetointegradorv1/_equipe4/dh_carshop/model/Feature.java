package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "features")
public class Feature implements Serializable {
    //@Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String nome;
    @ManyToMany(mappedBy = "caracteristicas")
    Set<Product> produtos = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "images_features",
            joinColumns = { @JoinColumn(name = "id_caracteristica", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id_imagem", referencedColumnName = "id") })
    private Image imagem;
    /*@Column(length = 300, nullable = false)
    private String icone;*/

    // Timestamps automáticos
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

    public Feature() {
    }

    public Feature(String nome) {
        this.nome = nome;
    }

    /*public Feature(String nome, String icone) {
        this.nome = nome;
        this.icone = icone;
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

    public Set<Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Product> produtos) {
        this.produtos = produtos;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    /*public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }*/

    public Instant getCriado() {
        return criado;
    }

    public Instant getAtualizado() {
        return atualizado;
    }
}
