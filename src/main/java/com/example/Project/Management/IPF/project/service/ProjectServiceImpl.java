package com.example.Project.Management.IPF.project.service;

import com.example.Project.Management.IPF.project.entity.Project;
import com.example.Project.Management.IPF.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public void projectSave(Project project) {
        projectRepository.save(project);

    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}
