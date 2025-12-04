package com.github.mlwilli.activitytracker.dto;

import com.github.mlwilli.activitytracker.entity.ProjectStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectDto {

    private Long id;
    private String name;
    private String description;
    private ProjectStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ActivityDto> activities;

    public Long getId() {
        return id;
    }

    public ProjectDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProjectDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProjectDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public ProjectDto setStatus(ProjectStatus status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public ProjectDto setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public ProjectDto setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public List<ActivityDto> getActivities() {
        return activities;
    }

    public ProjectDto setActivities(List<ActivityDto> activities) {
        this.activities = activities;
        return this;
    }
}
