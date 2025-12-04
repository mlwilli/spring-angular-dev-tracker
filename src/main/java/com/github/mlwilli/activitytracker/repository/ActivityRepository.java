package com.github.mlwilli.activitytracker.repository;

import com.github.mlwilli.activitytracker.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByProjectId(Long projectId);
}
