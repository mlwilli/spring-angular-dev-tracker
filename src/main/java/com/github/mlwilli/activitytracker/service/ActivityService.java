package com.github.mlwilli.activitytracker.service;

import com.github.mlwilli.activitytracker.dto.ActivityCreateRequest;
import com.github.mlwilli.activitytracker.dto.ActivityDto;
import com.github.mlwilli.activitytracker.dto.ActivityUpdateRequest;

import java.util.List;

public interface ActivityService {

    List<ActivityDto> getActivitiesByProject(Long projectId);

    ActivityDto getActivityById(Long projectId, Long activityId);

    ActivityDto createActivity(Long projectId, ActivityCreateRequest request);

    ActivityDto updateActivity(Long projectId, Long activityId, ActivityUpdateRequest request);

    void deleteActivity(Long projectId, Long activityId);
}
