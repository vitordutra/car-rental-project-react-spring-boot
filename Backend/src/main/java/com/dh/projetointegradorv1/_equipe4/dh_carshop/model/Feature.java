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
    @ManyToMany(mappedBy = "caracteristicas")
    private Set<Product> produtos;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "images_features",
            joinColumns = { @JoinColumn(name = "id_caracteristica", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id_imagem", referencedColumnName = "id") })
    private Image imagem;

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

    public Feature() {
    }

    public Feature(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", criado=" + criado +
                ", atualizado=" + atualizado +
                '}';
    }
}
