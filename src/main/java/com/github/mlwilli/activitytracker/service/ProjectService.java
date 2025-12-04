package com.github.mlwilli.activitytracker.service;

import com.github.mlwilli.activitytracker.dto.ProjectCreateRequest;
import com.github.mlwilli.activitytracker.dto.ProjectDto;
import com.github.mlwilli.activitytracker.dto.ProjectUpdateRequest;
import com.github.mlwilli.activitytracker.entity.ProjectStatus;

import java.util.List;

public interface ProjectService {

    List<ProjectDto> getAllProjects(ProjectStatus status);

    ProjectDto getProjectById(Long id);

    ProjectDto createProject(ProjectCreateRequest request);

    ProjectDto updateProject(Long id, ProjectUpdateRequest request);

    void deleteProject(Long id);
}
