package com.example.Project.Management.IPF.project.service;

import com.example.Project.Management.IPF.project.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project projectSave(Project project);

    List<Project> findAll();

    Optional<Project> findById(Long projectid);

    void deleteProjectById(Long id);
}
