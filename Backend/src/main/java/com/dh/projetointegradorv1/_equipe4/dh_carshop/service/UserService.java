package com.dh.projetointegradorv1._equipe4.dh_carshop.service;


import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.RoleDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.UserDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Role;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.User;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.RoleRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.UserRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.exceptions.BDExcecao;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.exceptions.RecursoNaoEncontrado;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Page<UserDto> buscarTodos(PageRequest pageRequest) {
        Page<User> users = userRepository.findAll(pageRequest);
        return users.map(x -> new UserDto(x, new RoleDto(x.getRole())));
    }

    @SneakyThrows
    @Transactional(readOnly = true)
    public UserDto findById(Integer id) throws RecursoNaoEncontrado {
        Optional<User> user = userRepository.findById(id);
        //Products entidade = obj.get();
        User entidade = user.
                orElseThrow(() -> new RecursoNaoEncontrado("RECURSO NÃO ENCONTRADO"));
        return new UserDto(entidade, new RoleDto(entidade.getRole()));
    }

    @Transactional
    public UserDto insert(UserDto dto) {
        User entity = new User();
        copyToEntity(dto, entity);
        entity = userRepository.save(entity);
        return new UserDto(entity);
    }

    @SneakyThrows
    @Transactional
    public UserDto update(Integer id, UserDto dto) {
        try {
            User entity = userRepository.getById(id.intValue());
            copyToEntity(dto, entity);
            entity = userRepository.save(entity);
            return new UserDto(entity);
        }
        catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontrado("ID NÃO ENCONTRADO: " + id);
        }
    }

    public void delete(Integer id) throws RecursoNaoEncontrado {
        try {
            userRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontrado("ID NÃO ENCONTRADO:" + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new BDExcecao("VIOLAÇÃO DE INTEGRIDADE.");
        }
    }

    private void copyToEntity(UserDto dto, User entity) {
        entity.setNome(dto.getNome());
        entity.setSobrenome(dto.getSobrenome());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());

        System.out.println("====dto.getRole()");
        System.out.println(dto.getRole());
        RoleDto roleDto = dto.getRole();
        System.out.println("====roleDto");
        System.out.println(roleDto);
        System.out.println(roleDto.getId());
        System.out.println(roleDto.getNome());
        entity.setRole(new Role(roleDto.getId(), roleDto.getNome()));
    }

}
