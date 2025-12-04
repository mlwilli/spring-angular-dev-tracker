import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project, ProjectStatus } from '../models/project.model';
import { Activity } from '../models/activity.model';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ApiService {
  private readonly baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  // Projects

  getProjects(status?: ProjectStatus): Observable<Project[]> {
    const url = status
      ? `${this.baseUrl}/projects?status=${status}`
      : `${this.baseUrl}/projects`;
    return this.http.get<Project[]>(url);
  }

  createProject(payload: {
    name: string;
    description?: string;
    status: ProjectStatus;
  }): Observable<Project> {
    return this.http.post<Project>(`${this.baseUrl}/projects`, payload);
  }

  updateProject(id: number, payload: {
    name: string;
    description?: string;
    status: ProjectStatus;
  }): Observable<Project> {
    return this.http.put<Project>(`${this.baseUrl}/projects/${id}`, payload);
  }

  deleteProject(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/projects/${id}`);
  }

  // Activities

  getActivities(projectId: number): Observable<Activity[]> {
    return this.http.get<Activity[]>(
      `${this.baseUrl}/projects/${projectId}/activities`
    );
  }

  createActivity(projectId: number, payload: {
    title: string;
    description?: string;
    type: string;
    activityDate: string;
    durationMinutes: number;
  }): Observable<Activity> {
    return this.http.post<Activity>(
      `${this.baseUrl}/projects/${projectId}/activities`,
      payload
    );
  }

  deleteActivity(projectId: number, activityId: number): Observable<void> {
    return this.http.delete<void>(
      `${this.baseUrl}/projects/${projectId}/activities/${activityId}`
    );
  }
}
