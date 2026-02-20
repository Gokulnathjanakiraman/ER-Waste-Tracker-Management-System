# ER-Waste-Tracker-Management-System
Waste Tracker Management System

Waste Tracker Management System is a backend-driven web application built using Java and Spring Boot to manage daily waste collection, processing, attendance tracking, and operational reporting for waste management organizations.

Tech Stack

Java

Spring Boot

Spring Data JPA (Hibernate)

MySQL

HTML, CSS

Maven

Features

User authentication and role-based access control

RESTful APIs for CRUD operations

Employee attendance tracking

Daily waste entry (Dry, Wet, Reject)

Vehicle entry management

Processed waste tracking

Report generation (Excel, PDF, CSV)

Monthly automated reporting

MVC architecture (Controller → Service → Repository)

Exception handling and input validation

Project Structure
src/main/java
 └── com.erap23
      ├── config
      │     └── SecurityConfig.java
      │
      ├── controller
      │     ├── AttendanceController.java
      │     ├── AuthController.java
      │     ├── DailyActivityController.java
      │     ├── DailyWasteController.java
      │     ├── DashboardController.java
      │     ├── ProcessedWasteController.java
      │     ├── ReportController.java
      │     ├── SiteIssueController.java
      │     └── VehicleEntryController.java
      │
      ├── entity
      │     ├── Attendance.java
      │     ├── DailyActivity.java
      │     ├── DailyWaste.java
      │     ├── Employee.java
      │     ├── MaterialMaster.java
      │     ├── Otp.java
      │     ├── ProcessedWaste.java
      │     ├── SiteIssue.java
      │     ├── User.java
      │     └── VehicleEntry.java
      │
      ├── repository
      │     ├── AttendanceRepository.java
      │     ├── DailyActivityRepository.java
      │     ├── DailyWasteRepository.java
      │     ├── EmployeeRepository.java
      │     ├── MaterialMasterRepository.java
      │     ├── OtpRepository.java
      │     ├── ProcessedWasteRepository.java
      │     ├── SiteIssueRepository.java
      │     ├── UserRepository.java
      │     └── VehicleEntryRepository.java
      │
      ├── service
      │     ├── DailyActivityService.java
      │     ├── DailyWasteService.java
      │     ├── EmailService.java
      │     └── ReportService.java
      │
      ├── report
      │     ├── CsvGenerator.java
      │     ├── ExcelGenerator.java
      │     └── PdfGenerator.java
      │
      └── util

src/main/resources
 ├── static
 ├── templates
 │     ├── activity.html
 │     ├── attendance.html
 │     ├── daily_waste.html
 │     ├── dashboard.html
 │     ├── issue.html
 │     ├── login.html
 │     ├── otp.html
 │     ├── processed_waste.html
 │     ├── report.html
 │     ├── signup.html
 │     └── vehicle_entry.html
 │
 └── application.properties
 
Database Configuration

Update your application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/erapp23
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
