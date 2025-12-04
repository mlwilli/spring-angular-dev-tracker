package com.github.mlwilli.activitytracker.service;

import com.github.mlwilli.activitytracker.dto.ProjectCreateRequest;
import com.github.mlwilli.activitytracker.dto.ProjectDto;
import com.github.mlwilli.activitytracker.dto.ProjectUpdateRequest;
import com.github.mlwilli.activitytracker.entity.Project;
import com.github.mlwilli.activitytracker.entity.ProjectStatus;
import com.github.mlwilli.activitytracker.exception.ResourceNotFoundException;
import com.github.mlwilli.activitytracker.mapper.ProjectMapper;
import com.github.mlwilli.activitytracker.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository,
                              ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectDto> getAllProjects(ProjectStatus status) {
        List<Project> projects = (status != null)
                ? projectRepository.findByStatus(status)
                : projectRepository.findAll();
        return projects.stream()
                .map(projectMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectDto getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", id));
        return projectMapper.toDto(project);
    }

    @Override
    public ProjectDto createProject(ProjectCreateRequest request) {
        Project project = projectMapper.fromCreateRequest(request);
        Project saved = projectRepository.save(project);
        return projectMapper.toDto(saved);
    }

    @Override
    public ProjectDto updateProject(Long id, ProjectUpdateRequest request) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", id));
        projectMapper.updateEntity(project, request);
        Project updated = projectRepository.save(project);
        return projectMapper.toDto(updated);
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", id));
        projectRepository.delete(project);
    }
}
