package com.github.mlwilli.activitytracker.repository;

import com.github.mlwilli.activitytracker.entity.Project;
import com.github.mlwilli.activitytracker.entity.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByStatus(ProjectStatus status);
}
