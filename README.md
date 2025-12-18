# Java Spring Boot CRUD Application

## Project Description

This project is a **CRUD application** (Create, Read, Update, Delete) built with **Java Spring Boot**. It follows the **MVC architecture** to separate the presentation layer, business logic, and data layer. The application uses **SQL Server** as the database for data storage and management.

## Requirements

To run this project locally, you need:

- Java JDK 17 or higher
- Maven for dependency management
- Spring Boot
- SQL Server installed and running
- An IDE like IntelliJ IDEA or Eclipse

## Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone <https://github.com/Mahmoud-elmedany/mvc-crud-system.git>
   ```
2. **Configure the database**:
   - Create a new database in SQL Server.
   - Update the database connection settings in `application.properties` or `application.yml`:
     ```properties
     spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=your_database_name
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```
3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```
4. **Access the application**:
   - The application runs on `http://localhost:8080`.
   - You can access the different CRUD operations through the endpoints defined in the controllers.

## Features

- Create new records in the database.
- View all existing records.
- Update existing records.
- Delete records easily.
- Follows **MVC architecture** for clean separation of concerns.

## Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **SQL Server**
- **Maven**

## Notes

- Make sure SQL Server is running before starting the application.
- Database connection settings can be customized in `application.properties`.
- The project can be extended by adding more entities, services, and endpoints as needed.

