package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.io.Serializable;

@Entity
@Table (name = "cities")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String pais;

    //Timestamps Automáticos

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime criado;
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime atualizado;

    @PrePersist
    public void antesDeSalvar() {criado = OffsetDateTime.now();}

    @PreUpdate
    public void antesDeAtualizar(){ atualizado = OffsetDateTime.now();}


    public City () {
    }


    public City(Integer id, String nome, String pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNome() {  return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getPais() {  return pais;  }

    public void setPais(String pais) { this.pais = pais; }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais='" + pais + '\'' +
                ", criado=" + criado +
                ", atualizado=" + atualizado +
                '}';
    }
}
