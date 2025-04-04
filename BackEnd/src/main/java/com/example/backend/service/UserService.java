package com.example.backend.service;

import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;

import java.util.List;

public interface UserService {
    void save (UserDTO userDTO);
    List<User> getAllUsers();

//    void deleteUser(String email);

    boolean deleteUser(int id);

    void updateUser(UserDTO userDTO);

    UserDTO findUserByEmail(String email);
}
