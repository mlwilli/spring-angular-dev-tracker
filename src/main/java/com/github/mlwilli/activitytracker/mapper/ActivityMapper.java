package com.github.mlwilli.activitytracker.mapper;

import com.github.mlwilli.activitytracker.dto.ActivityCreateRequest;
import com.github.mlwilli.activitytracker.dto.ActivityDto;
import com.github.mlwilli.activitytracker.dto.ActivityUpdateRequest;
import com.github.mlwilli.activitytracker.entity.Activity;
import com.github.mlwilli.activitytracker.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {

    public ActivityDto toDto(Activity entity) {
        if (entity == null) {
            return null;
        }
        return new ActivityDto()
                .setId(entity.getId())
                .setProjectId(entity.getProject() != null ? entity.getProject().getId() : null)
                .setTitle(entity.getTitle())
                .setDescription(entity.getDescription())
                .setType(entity.getType())
                .setActivityDate(entity.getActivityDate())
                .setDurationMinutes(entity.getDurationMinutes())
                .setCreatedAt(entity.getCreatedAt())
                .setUpdatedAt(entity.getUpdatedAt());
    }

    public Activity fromCreateRequest(ActivityCreateRequest request, Project project) {
        Activity activity = new Activity();
        activity.setProject(project);
        activity.setTitle(request.getTitle());
        activity.setDescription(request.getDescription());
        activity.setType(request.getType());
        activity.setActivityDate(request.getActivityDate());
        activity.setDurationMinutes(request.getDurationMinutes());
        return activity;
    }

    public void updateEntity(Activity entity, ActivityUpdateRequest request) {
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setType(request.getType());
        entity.setActivityDate(request.getActivityDate());
        entity.setDurationMinutes(request.getDurationMinutes());
    }
}
