import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { Project, ProjectStatus } from '../../models/project.model';
import { ProjectFormComponent } from '../project-form/project-form.component';
import { ActivityListComponent } from '../activity-list/activity-list.component';

@Component({
  selector: 'app-project-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,            // <--- important
    ProjectFormComponent,
    ActivityListComponent
  ],
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  projects: Project[] = [];
  selectedProject: Project | null = null;
  loading = false;
  filterStatus: ProjectStatus | 'ALL' = 'ALL';

  constructor(private api: ApiService) { }

  ngOnInit(): void {
    this.loadProjects();
  }

  loadProjects(): void {
    this.loading = true;
    const status = this.filterStatus === 'ALL' ? undefined : this.filterStatus;
    this.api.getProjects(status).subscribe({
      next: projects => {
        this.projects = projects;
        if (this.selectedProject) {
          this.selectedProject = projects.find(p => p.id === this.selectedProject!.id) ?? null;
        }
        this.loading = false;
      },
      error: err => {
        console.error('Failed to load projects', err);
        this.loading = false;
      }
    });
  }

  onCreated(): void {
    this.loadProjects();
  }

  onUpdated(): void {
    this.loadProjects();
  }

  onDeleted(projectId: number): void {
    if (this.selectedProject?.id === projectId) {
      this.selectedProject = null;
    }
    this.loadProjects();
  }

  selectProject(project: Project): void {
    this.selectedProject = project;
  }

  deleteProject(project: Project): void {
    if (!confirm(`Delete project "${project.name}"?`)) {
      return;
    }
    this.api.deleteProject(project.id).subscribe({
      next: () => this.onDeleted(project.id),
      error: err => console.error('Failed to delete project', err)
    });
  }

  statusClass(status: ProjectStatus): string {
    switch (status) {
      case 'COMPLETED':
        return 'badge badge-success';
      case 'IN_PROGRESS':
        return 'badge badge-warning';
      default:
        return 'badge badge-neutral';
    }
  }
}
