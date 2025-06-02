package com.example.Project.Management.IPF.dashboard.service;

import com.example.Project.Management.IPF.auth.user.entity.User;
import com.example.Project.Management.IPF.auth.user.service.UserService;
import com.example.Project.Management.IPF.dashboard.dto.DashboardDto;
import com.example.Project.Management.IPF.project.entity.Project;
import com.example.Project.Management.IPF.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;


    public DashboardDto createDashboard() {
            List<User> userList = userService.findAll();
            List<Project> projectList = projectService.findAll();

            int users = userList.size();
            int projects = projectList.size();

            DashboardDto dashboardDto = new DashboardDto();
            dashboardDto.setUsers(users);
            dashboardDto.setProjects(projects);

            return dashboardDto;

    }
}
