package com.dh.projetointegradorv1._equipe4.dh_carshop.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.time.OffsetDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "products")
@Getter @Setter
public class Product implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 300, nullable = false)
    private String descricao;

    // Timestamps Automáticos
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime criado;
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime atualizado;

    // Relacionamentos
    @ManyToMany
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Category> categorias = new ArrayList<>();

    // Construtores
    public Product() {
    }

    public Product(Integer id, String nome, String descricao, OffsetDateTime criado, OffsetDateTime atualizado) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.criado = criado;
        this.atualizado = atualizado;
    }
}
