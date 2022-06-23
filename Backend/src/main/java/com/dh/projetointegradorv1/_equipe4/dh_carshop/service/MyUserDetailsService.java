package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Role;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.UserRepository;
import org.eclipse.sisu.plexus.config.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserById(id);
        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
        for (Role role: user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getNome());
            grantList.add(grantedAuthority);
        }
        UserDetails user = null;
        user = (UserDetails) new User(username, user.getPassword(), grantList);
        return null;
    }
}



