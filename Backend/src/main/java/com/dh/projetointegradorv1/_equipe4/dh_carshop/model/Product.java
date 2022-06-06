package com.dh.projetointegradorv1._equipe4.dh_carshop.model;


import javax.persistence.*;
import java.time.OffsetDateTime;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table (name = "products")

public class Product implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "features_products",
            joinColumns = @JoinColumn(name = "id_produto"), inverseJoinColumns = @JoinColumn(name = "id_caracteristica")
    )
    private Set<Feature> caracteristicas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto")
    private List<Image> imagens;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Category categoria;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private City cidade;

    //Timestamps Automáticos

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime criado;
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime atualizado;

    @PrePersist
    public void antesDeSalvar() {criado = OffsetDateTime.now();}

    @PreUpdate
    public void antesDeAtualizar() {atualizado = OffsetDateTime.now();}

    public Integer getId() {   return id; }

    public void setId(Integer id) {  this.id = id;}

    public String getNome() {   return nome; }

    public void setNome(String nome) {  this.nome = nome; }

    public String getDescricao() {   return descricao; }

    public void setDescricao(String descricao) {  this.descricao = descricao; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", criado=" + criado +
                ", atualizado=" + atualizado +
                '}';
    }
}
