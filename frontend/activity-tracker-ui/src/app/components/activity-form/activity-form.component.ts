import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Project } from '../../models/project.model';
import { ApiService } from '../../services/api.service';
import { ActivityType } from '../../models/activity.model';

@Component({
  selector: 'app-activity-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './activity-form.component.html',
  styleUrls: ['./activity-form.component.css']
})
export class ActivityFormComponent {
  @Input() project!: Project;
  @Output() created = new EventEmitter<void>();

  title = '';
  description = '';
  type: ActivityType = 'CODING';
  activityDate = new Date().toISOString().substring(0, 10);
  durationMinutes = 60;
  saving = false;

  constructor(private api: ApiService) { }

  submit(): void {
    this.saving = true;
    const payload = {
      title: this.title,
      description: this.description,
      type: this.type,
      activityDate: this.activityDate,
      durationMinutes: this.durationMinutes
    };

    this.api.createActivity(this.project.id, payload).subscribe({
      next: () => {
        this.saving = false;
        this.resetForm();
        this.created.emit();
      },
      error: err => {
        console.error('Failed to create activity', err);
        this.saving = false;
      }
    });
  }

  resetForm(): void {
    this.title = '';
    this.description = '';
    this.type = 'CODING';
    this.activityDate = new Date().toISOString().substring(0, 10);
    this.durationMinutes = 60;
  }
}
