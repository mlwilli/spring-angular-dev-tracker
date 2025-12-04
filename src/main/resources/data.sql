INSERT INTO projects (id, name, description, status, created_at, updated_at)
VALUES (1, 'Portfolio API', 'Backend service for portfolio demos', 'IN_PROGRESS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO activities (project_id, title, description, type, activity_date, duration_minutes, created_at, updated_at)
VALUES (1, 'Initial project setup', 'Created Spring Boot project structure', 'CODING', CURRENT_DATE, 90, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
