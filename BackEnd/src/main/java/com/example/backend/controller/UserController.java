package com.example.backend.controller;

import com.example.backend.dto.ResponseDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.service.EmailService;
import com.example.backend.service.UserService;
import com.example.backend.service.impl.UserServiceImpl;
import com.example.backend.util.JwtUtil;
import com.example.backend.util.ResponseUtil;
import com.example.backend.util.VarList;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final UserServiceImpl userServiceImpl;

    @Autowired
    private EmailService emailService;

    public UserController(UserService userService, JwtUtil jwtUtil, UserServiceImpl userServiceImpl) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.userServiceImpl = userServiceImpl;
    }

    /*@PostMapping(path = "/save")
    public ResponseEntity<ResponseDTO> getUser(@RequestBody @Valid UserDTO userDTO) {
        System.out.println(userDTO.getEmail());
        userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "User Saved Successfully", null));
    }*/

    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody @Valid UserDTO userDTO) {
        System.out.println(userDTO.getEmail());
        userService.save(userDTO);

        // Send a welcome email after saving the user
        String subject = "Welcome to [clearStock] – Download & Edit Images with Ease!";
        String body = "Dear " + userDTO.getUsername() + ",\n\n"
                + "Welcome to **[clearStock]**! We are thrilled to have you on board.\n\n"
                + "With our platform, you can:\n"
                + "✅ **Download high-quality images** for free\n"
                + "✅ **Remove backgrounds** from any image in seconds\n\n"
                + "Get started now by visiting: [Your Website URL]\n\n"
                + "If you have any questions, feel free to reach out. Happy editing!\n\n"
                + "Best Regards,\n**[Your Website Name] Team**";

        emailService.sendEmail(userDTO.getEmail(), subject, body);

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

    @DeleteMapping(value = "/delete/{email}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ResponseDTO> deleteUser(@RequestParam String email) {
        userService.deleteUser(email);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "User Deleted Successfully", null));
    }
}
