package com.dh.projetointegradorv1._equipe4.dh_carshop.model;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.time.OffsetDateTime;
import java.io.Serializable;
import java.util.*;


@Entity
@Table (name = "produtos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product implements Serializable {
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
    @Column(name = "criado", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime criado;
    @Column(name = "atualizado", columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime atualizado;

    @PrePersist
    public void antesDeSalvar() {
        criado = OffsetDateTime.now();
    }
    @PreUpdate
    public void antesDeAtualizar() {
        atualizado = OffsetDateTime.now();
    }

    // Relacionamentos
    @ManyToMany
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<Category> categorias = new HashSet<>();
}
