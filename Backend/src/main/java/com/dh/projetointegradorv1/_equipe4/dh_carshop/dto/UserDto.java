package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Role;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;

    private List<UserDto> users = new ArrayList<>();
    private RoleDto roleDto = new RoleDto();

    public UserDto() {
    }

    public UserDto(Integer id, String nome, String sobrenome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    public UserDto(User entity) {
        id = entity.getId();
        nome = entity.getNome();
        sobrenome = entity.getSobrenome();
        email = entity.getEmail();
        senha = entity.getSenha();
    }

    public UserDto(User entity, RoleDto roleDto) {
        this(entity);
        this.roleDto = roleDto;
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

    public RoleDto getRole() {
        return roleDto;
    }

}
