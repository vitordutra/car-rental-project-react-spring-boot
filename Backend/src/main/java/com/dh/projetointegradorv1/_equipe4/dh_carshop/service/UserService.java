package com.dh.projetointegradorv1._equipe4.dh_carshop.service;


import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.UserDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.User;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Optional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDto createUser(UserDto dto) {
        User entity = new User();
        copyToEntity(dto, entity);
        entity = userRepository.save(entity);
        return new UserDto(entity);
    }

    @Transactional(readOnly = true)
    public List<UserDto> listAllUsers() {
        List<UserDto> listDto = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for(User user : list) {
            UserDto dto = new UserDto(user);
            listDto.add(dto);
        }
        return listDto;
    }

    @Transactional(readOnly = true)
    public UserDto findUserById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        User entity = obj.orElseThrow(() -> new RuntimeException());
        return new UserDto(entity);
    }

    @Transactional
    public UserDto updateUserById(Integer id, UserDto dto) {
        try {
            Optional<User> obj = userRepository.findById(id);
            User entity = obj.orElseThrow(() -> new RuntimeException());
            copyToEntity(dto, entity);
            entity = userRepository.save(entity);
            return new UserDto(entity);
        }
        catch (EntityNotFoundException e) {
            throw new RuntimeException();
        }

        /*return userRepository.findById(id)
                .map(userToUpdate -> {
                    userToUpdate.setNome(user.getNome());
                    userToUpdate.setSobrenome(user.getSobrenome());
                    userToUpdate.setEmail(user.getEmail());
                    userToUpdate.setSenha(user.getSenha());
                    return userRepository.save(userToUpdate);
                }).orElseGet(() -> {
                    user.setId(id);
                    return userRepository.save(user);
                });*/
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public void copyToEntity(UserDto dto, User entity) {
        entity.setNome(dto.getNome());
        entity.setSobrenome(dto.getSobrenome());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
    }

}
