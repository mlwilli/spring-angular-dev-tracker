package com.github.mlwilli.activitytracker.controller;

import com.github.mlwilli.activitytracker.dto.ActivityCreateRequest;
import com.github.mlwilli.activitytracker.dto.ActivityDto;
import com.github.mlwilli.activitytracker.dto.ActivityUpdateRequest;
import com.github.mlwilli.activitytracker.service.ActivityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public ResponseEntity<List<ActivityDto>> getActivities(@PathVariable Long projectId) {
        return ResponseEntity.ok(activityService.getActivitiesByProject(projectId));
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityDto> getActivity(
            @PathVariable Long projectId,
            @PathVariable Long activityId
    ) {
        return ResponseEntity.ok(activityService.getActivityById(projectId, activityId));
    }

    @PostMapping
    public ResponseEntity<ActivityDto> createActivity(
            @PathVariable Long projectId,
            @Valid @RequestBody ActivityCreateRequest request
    ) {
        ActivityDto created = activityService.createActivity(projectId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{activityId}")
    public ResponseEntity<ActivityDto> updateActivity(
            @PathVariable Long projectId,
            @PathVariable Long activityId,
            @Valid @RequestBody ActivityUpdateRequest request
    ) {
        ActivityDto updated = activityService.updateActivity(projectId, activityId, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{activityId}")
    public ResponseEntity<Void> deleteActivity(
            @PathVariable Long projectId,
            @PathVariable Long activityId
    ) {
        activityService.deleteActivity(projectId, activityId);
        return ResponseEntity.noContent().build();
    }
}
