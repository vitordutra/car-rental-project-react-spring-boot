package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import javax.persistence.*;
import java.io.Serial;
import java.time.OffsetDateTime;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "cities")
public class City implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String estado;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cidade")
    Set<Product> produtos = new HashSet<>();

    //Timestamps Automáticos

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime criado;
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime atualizado;

    @PrePersist
    public void antesDeSalvar() {criado = OffsetDateTime.now();}

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public OffsetDateTime getCriado() {
        return criado;
    }

    public OffsetDateTime getAtualizado() {
        return atualizado;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estado='" + estado + '\'' +
                ", criado=" + criado +
                ", atualizado=" + atualizado +
                '}';
    }


}
