package com.example.Project.Management.IPF.task.repository;

import com.example.Project.Management.IPF.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByProjectId(Long projectId);
}
