package com.example.Project.Management.IPF.auth.user.repository;

import com.example.Project.Management.IPF.auth.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUserName(String username);
//    Optional<User> findByVerificationCode(String verificationCode);
    Optional<User> findByEmail(String username);



}
