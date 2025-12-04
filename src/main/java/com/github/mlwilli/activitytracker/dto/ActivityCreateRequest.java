package com.github.mlwilli.activitytracker.dto;

import com.github.mlwilli.activitytracker.entity.ActivityType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ActivityCreateRequest {

    @NotBlank
    @Size(max = 140)
    private String title;

    @Size(max = 2000)
    private String description;

    @NotNull
    private ActivityType type;

    @NotNull
    private LocalDate activityDate;

    @Min(1)
    private int durationMinutes;

    public String getTitle() {
        return title;
    }

    public ActivityCreateRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ActivityCreateRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public ActivityType getType() {
        return type;
    }

    public ActivityCreateRequest setType(ActivityType type) {
        this.type = type;
        return this;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public ActivityCreateRequest setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
        return this;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public ActivityCreateRequest setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
        return this;
    }
}
