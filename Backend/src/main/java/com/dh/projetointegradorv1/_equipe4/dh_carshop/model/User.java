package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.RoleDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String senha;

    // Timestamps automáticos
    @Column(columnDefinition = "TIMESTAMP")
    private Instant criado;
    @Column(columnDefinition = "TIMESTAMP")
    private Instant atualizado;

    @PrePersist
    public void AntesDeSalvar() {
        criado = Instant.now();
    }

    @PreUpdate
    public void AntesDeAtualizar() {
        atualizado = Instant.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcao")
    @JsonIgnoreProperties("users")
    private Role role;

    public User() {
    }

    public User(Integer id, String nome, String sobrenome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

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

    public Instant getCriado() {
        return criado;
    }

    public void setCriado(Instant criado) {
        this.criado = criado;
    }

    public Instant getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(Instant atualizado) {
        this.atualizado = atualizado;
    }

    public Role getRole() {
        System.out.println("====get role");
        System.out.println(role);
        System.out.println(role.getId());
        return this.role;
    }

    public void setRole(Role role) {
        System.out.println("====set role");
        System.out.println(role);
        System.out.println(role.getId());
        this.role = role;
    }
}
