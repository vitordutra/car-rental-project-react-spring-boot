package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;

/*
* TODO: Timestamp não está funcionando
* */

@Entity
@Table (name = "categories")
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String qualificacao;
    private String descricao;
    private String url_imagem;

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

    public Integer getId() {
        return id;
    }
    // id é definido automaticamente pelo banco de dados.
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

    public String getUrl_imagem() {
        return url_imagem;
    }

    public void setUrl_imagem(String url_imagem) {
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
                ", qualificacao='" + qualificacao + '\'' +
                ", descricao='" + descricao + '\'' +
                ", url_imagem='" + url_imagem + '\'' +
                ", criado=" + criado +
                ", atualizado=" + atualizado +
                '}';
    }

}
