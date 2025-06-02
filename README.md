📁 Project Management System (Spring Boot)
📌 Objective
Develop a Spring Boot-based Project Management System to efficiently manage users, projects, and tasks with robust security, RESTful APIs, and role-based access control.

🚀 Features Overview
🔐 JWT Authentication & Role-Based Authorization (ADMIN, MANAGER, USER)

📁 Project Management (Create, Read, Update, Delete)

✅ Task Management (Assign, Update, Track Status)

📊 Dashboard API for summary statistics

📎 Data validation, error handling, and JPA relationships

🛡️ Secure access with Spring Security

✉️ Email Notifications & Caching 

📚 Requirements
1. 🔐 User Authentication & Authorization
Authentication
JWT-based Authentication using Spring Security

Endpoints:

POST /auth/signup - Register new users
![image](https://github.com/user-attachments/assets/5d5d5b3c-5d76-4210-9b9b-3ee1d8bad53b)

POST /auth/verify - Verify the code obtained from email
![Email_verification_code_IPF_PROJECT_MANAGEMENT](https://github.com/user-attachments/assets/274c3fd1-9ec4-4f6f-bf02-89afa89da62b)

POST /auth/resend - Resend verification code via email

POST /auth/login - Authenticate and get token
![image](https://github.com/user-attachments/assets/05ca69e0-4df1-476f-b973-a3d67a49122f)


POST /auth/logout - Invalidate token

Role-Based Access Control
Roles:

ADMIN: Full access

MANAGER: Manage assigned projects & tasks

USER: View/update their tasks

Use @PreAuthorize for method-level security

2. 🗃️ Database Schema (via JPA)
🧑 Users
Fields: id, name, email, password, role (enum), created_at, updated_at

Dynamic role assignment and validation

📁 Projects
Fields: id, name, description, manager_id, start_date, end_date, created_at, updated_at

Relationships:

One Manager (User with MANAGER role) → Many Projects

📋 Tasks
Fields: id, name, description, project_id, assignee_id, status (enum), created_at, updated_at

Relationships:

One Project → Many Tasks

One User → Many Assigned Tasks

3. 🔧 API Endpoints
✅ Projects API
Method	Endpoint	Access
POST	/api/project/create	Manager, Admin
GET	/api/project/list	All Roles
GET	/api/project/summary/projectid/{projectid}	All Roles
PUT	/api/project/update/{id}	Manager, Admin
DELETE	/api/project/dalete/{id}	Admin

📋 Tasks API
Method	Endpoint	Access
POST	/api/task/create	Manager
GET	/api/task/list/projectid/{projectid}	All Roles
GET	/api/task/summary/taskid/{taskid}	All Roles
PUT	/api/task/update/{id}	Manager, Assignee


📊 Dashboard API
GET /api/dashboard

Summary:

Total Projects

Tasks grouped by status

Total Users

4. 🛠 Additional Expectations
✅ Validation
Use @Valid for incoming request validation

Meaningful error messages for invalid inputs

❌ Error Handling
Global exception handler using @ControllerAdvice

Consistent JSON error responses

🔁 JPA Relationships
Use:

@OneToMany, @ManyToOne, @JoinColumn

🛡 Policies & Middleware
Role enforcement using:

@PreAuthorize

Interceptors/filters for request-level access checks

Optimize endpoints like /api/dashboard

✉️ Notifications
Send emails via Spring Mail when:

User authentication verification code notifictaion
![Email_verification_code_IPF_PROJECT_MANAGEMENT](https://github.com/user-attachments/assets/274c3fd1-9ec4-4f6f-bf02-89afa89da62b)


🛠 Tech Stack
Java 17+

Spring Boot

Spring Security + JWT

Spring Data JPA + Hibernate

MySQL/PostgreSQL

Spring Mail
