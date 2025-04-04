package com.example.backend.service.impl;

import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.repo.UserRepo;
import com.example.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(UserDTO userDTO) {
        if (userRepo.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        userRepo.save(modelMapper.map(userDTO, User.class));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

//    @Override
//    public void deleteUser(String email) {
//        if (userRepo.existsByEmail(email)) {
//            userRepo.deleteByEmail(email);
//            throw new RuntimeException("User deleted successfully");
//        } else {
//            throw new RuntimeException("User not found");
//        }
//    }

    /*@Override
    public void deleteUser(String email) {
        if (userRepo.existsByEmail(email)) {
            userRepo.deleteByEmail(email);
        } else {
            throw new RuntimeException("User not found");
        }
    }*/

    @Override
    public boolean deleteUser(int id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }



    @Override
    public void updateUser(UserDTO userDTO) {
        try {
            User user = userRepo.findByEmail(userDTO.getEmail());
            if (user != null) {
                userRepo.save(modelMapper.map(userDTO, User.class));
                throw new RuntimeException("User updated successfully");
            } else {
                throw new RuntimeException("User not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating User: " + e.getMessage());
        }
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        User user = userRepo.findByEmail(email);
        return modelMapper.map(user,UserDTO.class);
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        /*User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole()))
        );*/
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole()))
        );
    }

    public UserDTO loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        return modelMapper.map(user,UserDTO.class);
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }



}
