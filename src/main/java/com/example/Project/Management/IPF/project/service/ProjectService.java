package com.example.Project.Management.IPF.project.service;

import com.example.Project.Management.IPF.project.entity.Project;

import java.util.List;

public interface ProjectService {
    void projectSave(Project project);

    List<Project> findAll();
}
