package com.example.Project.Management.IPF.auth.user.service;

import com.example.Project.Management.IPF.auth.user.entity.User;
import com.example.Project.Management.IPF.project.dto.ProjectDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getByUserName(String upperCase);

    User saveUser(User user);


    Optional<User> findByUserId(long userId);
}
