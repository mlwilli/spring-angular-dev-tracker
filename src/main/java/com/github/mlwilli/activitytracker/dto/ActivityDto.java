package com.github.mlwilli.activitytracker.dto;

import com.github.mlwilli.activitytracker.entity.ActivityType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ActivityDto {

    private Long id;
    private Long projectId;
    private String title;
    private String description;
    private ActivityType type;
    private LocalDate activityDate;
    private int durationMinutes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public ActivityDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getProjectId() {
        return projectId;
    }

    public ActivityDto setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ActivityDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ActivityDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ActivityType getType() {
        return type;
    }

    public ActivityDto setType(ActivityType type) {
        this.type = type;
        return this;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public ActivityDto setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
        return this;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public ActivityDto setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public ActivityDto setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public ActivityDto setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
