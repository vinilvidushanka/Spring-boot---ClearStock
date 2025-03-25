package com.example.backend.controller;

import com.example.backend.dto.ResponseDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import com.example.backend.service.impl.UserServiceImpl;
import com.example.backend.util.JwtUtil;
import com.example.backend.util.ResponseUtil;
import com.example.backend.util.VarList;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final UserServiceImpl userServiceImpl;

    public UserController(UserService userService, JwtUtil jwtUtil, UserServiceImpl userServiceImpl) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDTO> getUser(@RequestBody @Valid UserDTO userDTO) {
        System.out.println(userDTO.getEmail());
        userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "User Saved Successfully", null));
    }

    @GetMapping(path = "/getAll")
    public ResponseUtil getAllUsers() {
        List<User> userList = userService.getAllUsers();

        for (User user : userList) {
            System.out.println(user.toString());
        }
        return new ResponseUtil(200, "User saved successfully", userList);
    }

    @PutMapping(path = "/update")
    public  ResponseUtil updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return new ResponseUtil(201, "User updated successfully", null);

    }
}
