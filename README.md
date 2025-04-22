# 💼 Job Portal System

A modern Job Portal system built using **Java 17** and **Spring Boot**, allowing job seekers to browse and apply to jobs, while admins can manage job posts, categories, and employers.

---

- 🗂 **Categorized Job Listings**: Jobs are organized under relevant categories for easier navigation.
- 👤 **Employer Profiles**: Information about employers and workplaces is accessible for applicants.
- 📝 **Application Tracking**: Users can apply for jobs and view the full list of jobs they’ve applied to.
- 🔄 **Full CRUD Operations**: All core entities (jobs, categories, companies, applications, users) support full Create, Read, Update, and Delete operations.
- 🔐 **JWT Authentication & Role-based Authorization**: Secure access to endpoints for users and administrators.
- 📖 **Interactive API Documentation**: Swagger UI integration for testing and exploring APIs.


## 🔧 Tech Stack

| Layer          | Technology                                               |
|----------------|----------------------------------------------------------|
| 💻 Language      | Java 17                                                  |
| 🌱 Framework     | Spring Boot (Web, Data JPA, Security, Validation)       |
| 🛢 Database      | PostgreSQL                                               |
| 🧰 Build Tool    | Gradle                                                   |
| 📦 Dependency   | Spring Dependency Management Plugin                      |
| 🎯 Auth         | JWT (via `jjwt`)                                         |
| 🧾 Mapping      | MapStruct for DTO <-> Entity mapping                     |
| 🪄 Boilerplate  | Lombok                                                   |
| 📖 Docs         | Swagger UI (via Springdoc OpenAPI)                       |
| 🧪 Testing      | JUnit, Spring Boot Test                                  |

---

## 🌟 Features

### 👥 For Job Seekers
- 🔍 Browse all job vacancies
- 📝 Apply for available jobs
- 📂 View jobs you’ve applied to
- 🏢 View company/employer profiles

### 🔐 For Admins
- ➕ Create and manage job posts
- 🗂 Add job categories
- 🏭 Register/view company details

### ⚙️ System Features
- ✅ User authentication and authorization (JWT + Spring Security)
- 🔒 Secure REST APIs with role-based access control
- 📖 Interactive API documentation (Swagger UI)
- 🧾 Clean DTO mapping using MapStruct
- 📦 Gradle build automation



