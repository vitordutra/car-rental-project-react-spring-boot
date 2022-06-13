package com.dh.projetointegradorv1._equipe4.dh_carshop.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serial;
import java.time.OffsetDateTime;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table (name = "users")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String sobrenome;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String senha;

    // @ManyToOne
    // @JoinColumn(name = "id_funcao")
    // @JsonIgnoreProperties("roles")
    // private Role funcao;

//    @PrePersist
//    public void antesDeSalvar() { senha = bCryptPasswordEncoder.encode(senha);}

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

    public String getSobrenome() {   return sobrenome; }
    public void setSobrenome(String sobrenome) {  this.sobrenome = sobrenome; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public OffsetDateTime getCriado() {
        return criado;
    }

    public OffsetDateTime getAtualizado() {
        return atualizado;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", criado=" + criado +
                ", atualizado=" + atualizado +
                '}';
    }
}
