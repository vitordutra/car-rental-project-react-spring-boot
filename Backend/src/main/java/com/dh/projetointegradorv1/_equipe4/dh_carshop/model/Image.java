package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import javax.persistence.*;
import java.io.Serial;
import java.time.OffsetDateTime;
import java.io.Serializable;


@Entity
@Table (name = "images")
public class Image implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String titulo;
    @Column(columnDefinition = "longtext", nullable = false)
    private String url;

    //Timestamps Automáticos

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime criado;
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime atualizado;

    @PrePersist
    public void antesDeSalvar() {criado = OffsetDateTime.now();}

    @PreUpdate
    public void antesDeAtualizar(){ atualizado = OffsetDateTime.now();}

    public Integer getId() { return id; }

    public void setId(Integer id) {   this.id = id;  }

    public String getTitulo() {   return titulo;  }

    public void setTitulo(String titulo) {  this.titulo = titulo; }

    public String getUrl() {  return url;}

    public void setUrl(String url) {   this.url = url;  }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", url='" + url + '\'' +
                ", criado=" + criado +
                ", atualizado=" + atualizado +
                '}';
    }
}
