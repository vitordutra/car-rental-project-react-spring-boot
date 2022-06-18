package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Role;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoleDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;

    private List<UserDto> users = new ArrayList<UserDto>();

    public RoleDto() {
    }

    public RoleDto(Integer id, String nome ) {
        this.id = id;
        this.nome = nome;
    }

    public RoleDto(Role entity) {
        id = entity.getId();
        nome = entity.getNome();

    }

    // Outro construtor que recebe o objeto e a lista de categorias
    public RoleDto(Role entity, List<User> users) {
        this(entity);
        users.forEach(user -> this.users.add(new UserDto(user)));
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

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
