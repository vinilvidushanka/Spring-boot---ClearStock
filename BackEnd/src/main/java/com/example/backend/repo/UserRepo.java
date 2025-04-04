package com.example.backend.repo;

import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String userName);

    boolean existsByEmail(String userName);

//    int deleteByEmail(String email);

//    User findByUsername(String username);
}
