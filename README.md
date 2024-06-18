# Project Checklist and Setup Guide

This document outlines the setup checklist and essential steps for creating a Spring Boot project using Maven, Java 17, and integrating with H2 database. It also covers entity creation, database configuration, exception handling, and basic CRUD operations.

## Project Setup Checklist

### Spring Initializr Setup
- Maven Project
- Java 17
- Packaging as JAR
- Dependencies: Spring Web

### Entity Setup Checklist
- Basic attributes
- Associations (initialize collections)
- Constructors
- Getters & Setters (only getter for collections)
- `hashCode` & `equals`
- `Serializable`

### Database Setup (H2 Database)
- Dependencies: 
  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <scope>runtime</scope>
  </dependency>
application.properties:
properties
Copy code
spring.profiles.active=test
spring.jpa.open-in-view=true
application-test.properties:
properties
Copy code
# DATASOURCE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# H2 CLIENT
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA, SQL
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
JPA Repository and Dependency Injection
UserRepository extends JpaRepository<User, Long>
Configuration class for "test" profile
@Autowired UserRepository
Instantiate objects in memory
Persist objects
Service Layer and Component Registration
Exception Handling
EntityNotFoundException:
Define EntityNotFoundException class
Modify UserService to throw EntityNotFoundException
Handle in UserResource
Centralized exception handling with @ControllerAdvice
User Operations Checklist
Insert User:

UserService
UserResource
Test with JSON:
json
Copy code
{
 "name": "Bob Brown",
 "email": "bob@gmail.com",
 "phone": "977557755",
 "password": "123456"
}
Delete User:

UserService
UserResource
Update User:

UserService
UserResource
Test with JSON:
json
Copy code
{
 "name": "Bob Brown",
 "email": "bob@gmail.com",
 "phone": "977557755"
}
Exception Handling for CRUD Operations
Exception Handling - findById:

EntityNotFoundException
ResourceExceptionHandler
UserService
Exception Handling - Delete:

DatabaseException
ResourceExceptionHandler
UserService
Handle EmptyResultDataAccessException, DataIntegrityViolationException
Exception Handling - Update:

UserService