import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { Project, ProjectStatus } from '../../models/project.model';

@Component({
  selector: 'app-project-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './project-form.component.html',
  styleUrls: ['./project-form.component.css']
})
export class ProjectFormComponent implements OnChanges {
  @Input() project: Project | null = null;
  @Output() created = new EventEmitter<void>();
  @Output() updated = new EventEmitter<void>();

  name = '';
  description = '';
  status: ProjectStatus = 'IN_PROGRESS';
  saving = false;

  constructor(private api: ApiService) { }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['project']) {
      if (this.project) {
        this.name = this.project.name;
        this.description = this.project.description ?? '';
        this.status = this.project.status;
      } else {
        this.resetForm();
      }
    }
  }

  resetForm(): void {
    this.name = '';
    this.description = '';
    this.status = 'IN_PROGRESS';
  }

  submit(): void {
    this.saving = true;
    const payload = {
      name: this.name,
      description: this.description,
      status: this.status
    };

    if (this.project) {
      this.api.updateProject(this.project.id, payload).subscribe({
        next: () => {
          this.saving = false;
          this.updated.emit();
        },
        error: err => {
          console.error('Failed to update project', err);
          this.saving = false;
        }
      });
    } else {
      this.api.createProject(payload).subscribe({
        next: () => {
          this.saving = false;
          this.resetForm();
          this.created.emit();
        },
        error: err => {
          console.error('Failed to create project', err);
          this.saving = false;
        }
      });
    }
  }
}
