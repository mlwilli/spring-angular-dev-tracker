package com.github.mlwilli.activitytracker.dto;

import com.github.mlwilli.activitytracker.entity.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProjectUpdateRequest {

    @NotBlank
    @Size(max = 140)
    private String name;

    @Size(max = 2000)
    private String description;

    @NotNull
    private ProjectStatus status;

    public String getName() {
        return name;
    }

    public ProjectUpdateRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProjectUpdateRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public ProjectUpdateRequest setStatus(ProjectStatus status) {
        this.status = status;
        return this;
    }
}
