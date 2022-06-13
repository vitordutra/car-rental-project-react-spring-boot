package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "categorias")
@Getter @Setter
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String qualificacao;
    @Column(length = 300, nullable = false)
    private String descricao;
    @Column(length = 300, nullable = false)
    private String url_imagem;

    // Relacionamentos
    @JsonManagedReference
    @ManyToMany(mappedBy = "categorias")
    private List<Product> produtos = new ArrayList<>();

    // Timestamps automáticos
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime criado;
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime atualizado;

    @PrePersist
    public void antesDeSalvar() {
        criado = OffsetDateTime.now();
    }

    @PreUpdate
    public void antesDeAtualizar() {
        atualizado = OffsetDateTime.now();
    }

    public Category() {
    }

    public Category(String qualificacao, String descricao, String url_imagem) {
        this.qualificacao = qualificacao;
        this.descricao = descricao;
        this.url_imagem = url_imagem;
    }

    public OffsetDateTime getCriado() {
        return criado;
    }

    public OffsetDateTime getAtualizado() {
        return atualizado;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", titulo='" + qualificacao + '\'' +
                ", descricao='" + descricao + '\'' +
                ", url_imagem='" + url_imagem + '\'' +
                ", criado=" + criado +
                ", atualizado=" + atualizado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(getId(), category.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
