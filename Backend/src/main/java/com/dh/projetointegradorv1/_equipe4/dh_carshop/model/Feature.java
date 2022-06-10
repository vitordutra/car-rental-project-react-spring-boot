package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "features")
public class Feature implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 3000, nullable = false)
    private String imagem;
    @ManyToMany(mappedBy = "caracteristicas")
    private Set<Product> produtos;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Product> produtos) {
        this.produtos = produtos;
    }

    public OffsetDateTime getCriado() {
        return criado;
    }

    public void setCriado(OffsetDateTime criado) {
        this.criado = criado;
    }

    public OffsetDateTime getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(OffsetDateTime atualizado) {
        this.atualizado = atualizado;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", icone='" + imagem + '\'' +
                ", criado=" + criado +
                ", atualizado=" + atualizado +
                '}';
    }
}
