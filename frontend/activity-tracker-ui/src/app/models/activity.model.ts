export type ActivityType =
  | 'CODING'
  | 'CODE_REVIEW'
  | 'DESIGN'
  | 'TESTING'
  | 'DOCUMENTATION';

export interface Activity {
  id: number;
  projectId: number;
  title: string;
  description: string | null;
  type: ActivityType;
  activityDate: string;
  durationMinutes: number;
  createdAt: string;
  updatedAt: string;
}
