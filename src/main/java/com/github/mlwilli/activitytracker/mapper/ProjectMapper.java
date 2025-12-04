package com.github.mlwilli.activitytracker.mapper;

import com.github.mlwilli.activitytracker.dto.ProjectCreateRequest;
import com.github.mlwilli.activitytracker.dto.ProjectDto;
import com.github.mlwilli.activitytracker.dto.ProjectUpdateRequest;
import com.github.mlwilli.activitytracker.entity.Project;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProjectMapper {

    private final ActivityMapper activityMapper;

    public ProjectMapper(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    public ProjectDto toDto(Project entity) {
        if (entity == null) {
            return null;
        }
        ProjectDto dto = new ProjectDto()
                .setId(entity.getId())
                .setName(entity.getName())
                .setDescription(entity.getDescription())
                .setStatus(entity.getStatus())
                .setCreatedAt(entity.getCreatedAt())
                .setUpdatedAt(entity.getUpdatedAt());

        if (entity.getActivities() != null) {
            dto.setActivities(
                    entity.getActivities().stream()
                            .map(activityMapper::toDto)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public Project fromCreateRequest(ProjectCreateRequest request) {
        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setStatus(request.getStatus());
        return project;
    }

    public void updateEntity(Project project, ProjectUpdateRequest request) {
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setStatus(request.getStatus());
    }
}
