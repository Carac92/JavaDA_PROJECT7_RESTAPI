package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
@Log4j2
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User connectedUser = userRepository.findByUsername(username);
        if (connectedUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(connectedUser.getRole());
        return new org.springframework.security.core.userdetails.User(connectedUser.getUsername(),
                connectedUser.getPassword(), Collections.singletonList(authority));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public void addUser(User user){
        log.info("Adding user");
        userRepository.save(user);
    }
    public void updateUser(User user){
        log.info("Updating user");
        userRepository.save(user);
    }
    public void deleteUser(Integer id){
        log.info("Deleting user");
        userRepository.deleteById(id);
    }
}
