package com.dh.projetointegradorv1._equipe4.dh_carshop.service;


import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.User;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User updateUserById(User user, Integer id) {
        return userRepository.findById(id)
                .map(userToUpdate -> {
                    userToUpdate.setNome(user.getNome());
                    userToUpdate.setSobrenome(user.getSobrenome());
                    userToUpdate.setEmail(user.getEmail());
                    userToUpdate.setSenha(user.getSenha());
                    return userRepository.save(userToUpdate);
                }).orElseGet(() -> {
                    user.setId(id);
                    return userRepository.save(user);
                });
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

}
