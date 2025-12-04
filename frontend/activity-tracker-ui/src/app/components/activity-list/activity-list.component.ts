import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Project } from '../../models/project.model';
import { Activity } from '../../models/activity.model';
import { ApiService } from '../../services/api.service';
import { ActivityFormComponent } from '../activity-form/activity-form.component';

@Component({
  selector: 'app-activity-list',
  standalone: true,
  imports: [CommonModule, ActivityFormComponent],
  templateUrl: './activity-list.component.html',
  styleUrls: ['./activity-list.component.css']
})
export class ActivityListComponent implements OnInit {
  @Input() project!: Project;

  activities: Activity[] = [];
  loading = false;

  constructor(private api: ApiService) { }

  ngOnInit(): void {
    this.loadActivities();
  }

  ngOnChanges(): void {
    this.loadActivities();
  }

  loadActivities(): void {
    if (!this.project) {
      return;
    }
    this.loading = true;
    this.api.getActivities(this.project.id).subscribe({
      next: acts => {
        this.activities = acts;
        this.loading = false;
      },
      error: err => {
        console.error('Failed to load activities', err);
        this.loading = false;
      }
    });
  }

  onCreated(): void {
    this.loadActivities();
  }

  deleteActivity(activity: Activity): void {
    if (!confirm(`Delete activity "${activity.title}"?`)) {
      return;
    }
    this.api.deleteActivity(this.project.id, activity.id).subscribe({
      next: () => this.loadActivities(),
      error: err => console.error('Failed to delete activity', err)
    });
  }
}
