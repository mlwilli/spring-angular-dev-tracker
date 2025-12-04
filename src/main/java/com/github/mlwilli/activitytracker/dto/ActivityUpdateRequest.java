package com.github.mlwilli.activitytracker.dto;

import com.github.mlwilli.activitytracker.entity.ActivityType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ActivityUpdateRequest {

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

    public ActivityUpdateRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ActivityUpdateRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public ActivityType getType() {
        return type;
    }

    public ActivityUpdateRequest setType(ActivityType type) {
        this.type = type;
        return this;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public ActivityUpdateRequest setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
        return this;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public ActivityUpdateRequest setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
        return this;
    }
}
