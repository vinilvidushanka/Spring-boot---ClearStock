package com.example.backend.repo;

import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findByEmail(String userName);

    boolean existsByEmail(String userName);

    int deleteByEmail(String userName);

//    User findByUsername(String username);
}
