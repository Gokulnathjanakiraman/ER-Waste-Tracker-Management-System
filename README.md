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
 ├── controller
 ├── service
 ├── repository
 ├── entity
 └── config
Database Configuration

Update your application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/erapp23
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
