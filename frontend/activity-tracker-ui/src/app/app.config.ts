import { Routes } from '@angular/router';
import { ProjectListComponent } from './components/project-list/project-list.component';

export const appRoutes: Routes = [
  { path: '', component: ProjectListComponent },
  { path: '**', redirectTo: '' }
];
