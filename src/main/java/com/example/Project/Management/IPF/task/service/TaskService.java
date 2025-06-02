package com.example.Project.Management.IPF.task.service;

import com.example.Project.Management.IPF.task.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task taskSave(Task task);

    List<Task> findAllByProjectId(Long projectId);

    Optional<Task> findById(Long taskid);

    void deleteTaskById(Long id);
}
