package com.example.backend.service.impl;

import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.repo.UserRepo;
import com.example.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getId())) {
            throw new RuntimeException("User already exists");
        }
        userRepo.save(modelMapper.map(userDTO, User.class));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(int id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        try {
            Optional<User> optionalUser = userRepo.findById(userDTO.getId());
            if (optionalUser.isPresent()) {
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

    @Override
    public UserDTO findUserById(int id) {
        Optional<User> user = userRepo.findById(id);
        return modelMapper.map(user.get(),UserDTO.class);
    }

    public UserDetails loadUserByUsername(String email) {
        return null;
    }

    public UserDTO loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        return modelMapper.map(user,UserDTO.class);
    }

}
