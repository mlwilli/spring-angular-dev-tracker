package com.github.mlwilli.activitytracker.service;

import com.github.mlwilli.activitytracker.dto.ActivityCreateRequest;
import com.github.mlwilli.activitytracker.dto.ActivityDto;
import com.github.mlwilli.activitytracker.dto.ActivityUpdateRequest;
import com.github.mlwilli.activitytracker.entity.Activity;
import com.github.mlwilli.activitytracker.entity.Project;
import com.github.mlwilli.activitytracker.exception.ResourceNotFoundException;
import com.github.mlwilli.activitytracker.mapper.ActivityMapper;
import com.github.mlwilli.activitytracker.repository.ActivityRepository;
import com.github.mlwilli.activitytracker.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final ProjectRepository projectRepository;
    private final ActivityMapper activityMapper;

    public ActivityServiceImpl(ActivityRepository activityRepository,
                               ProjectRepository projectRepository,
                               ActivityMapper activityMapper) {
        this.activityRepository = activityRepository;
        this.projectRepository = projectRepository;
        this.activityMapper = activityMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityDto> getActivitiesByProject(Long projectId) {
        verifyProjectExists(projectId);
        return activityRepository.findByProjectId(projectId).stream()
                .map(activityMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ActivityDto getActivityById(Long projectId, Long activityId) {
        verifyProjectExists(projectId);
        Activity activity = activityRepository.findById(activityId)
                .filter(a -> a.getProject().getId().equals(projectId))
                .orElseThrow(() -> new ResourceNotFoundException("Activity", activityId));
        return activityMapper.toDto(activity);
    }

    @Override
    public ActivityDto createActivity(Long projectId, ActivityCreateRequest request) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId));
        Activity activity = activityMapper.fromCreateRequest(request, project);
        Activity saved = activityRepository.save(activity);
        return activityMapper.toDto(saved);
    }

    @Override
    public ActivityDto updateActivity(Long projectId, Long activityId, ActivityUpdateRequest request) {
        verifyProjectExists(projectId);
        Activity activity = activityRepository.findById(activityId)
                .filter(a -> a.getProject().getId().equals(projectId))
                .orElseThrow(() -> new ResourceNotFoundException("Activity", activityId));
        activityMapper.updateEntity(activity, request);
        Activity updated = activityRepository.save(activity);
        return activityMapper.toDto(updated);
    }

    @Override
    public void deleteActivity(Long projectId, Long activityId) {
        verifyProjectExists(projectId);
        Activity activity = activityRepository.findById(activityId)
                .filter(a -> a.getProject().getId().equals(projectId))
                .orElseThrow(() -> new ResourceNotFoundException("Activity", activityId));
        activityRepository.delete(activity);
    }

    private void verifyProjectExists(Long projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new ResourceNotFoundException("Project", projectId);
        }
    }
}
