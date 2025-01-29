# Water Quality Detection Application

Welcome to the Water Quality Detection Application! This app allows users to check whether the water at a specific location is drinkable based on sensor data, utilizing a **Spring Boot** backend and **PostgreSQL** database for data management.

---

## Introduction
This project was completed solo as part of a **Spring Boot** course. It provides users with the ability to determine whether the water at a specific location is drinkable by using sensor data stored in a **PostgreSQL** database. The application leverages **Spring Boot**'s features, including **JPA** for data access, **Lombok** for reducing boilerplate code, and exception handling for better stability. Users can view reports and sensor data, along with the ability to register, log in, and access data based on their specific roles.

---

## Features

- **User Registration & Authentication**: Secure user login with role-based access control.
- **Water Quality Check**: Determine whether water at a given location is drinkable using sensor data.
- **CRUD Methods for Sensor Data**: Create, read, update, and delete sensor data in PostgreSQL.
- **Reports**: Generate reports based on water quality sensor readings.
- **Environment Configuration**: Multiple application configurations for development, testing, and production environments.
- **Exception Handling**: Custom exception handling for better error management.
- **Integration Testing**: Ensured the app works smoothly with integration tests.

---

## Project Structure

The application is built with **Spring Boot**, utilizing **Lombok** for reducing boilerplate code and **JPA** for data persistence in **PostgreSQL**. The backend includes various components for managing sensors, sensor data, and user authentication, and the project structure is organized as follows:

/water-quality-detection
    /src
        /main
            /java/com/waterquality
                /controller
                /dto
                /entity
                /repository
                /security
                /service
                /exception
                /WaterQualityApplication.java
            /resources
                /application.yml
                /application-dev.yml
                /application-prod.yml
                /application-test.yml
    /test
        /java/com/waterquality
            /controller
            /service
            /integration
            /WaterQualityApplicationTests.java

---

## Technologies Used

- **Spring Boot: The backend framework used for building the application.
- **PostgreSQL: Relational database for storing sensor data and user information.
- **Lombok: Dependency used for automatic generation of getters, setters, and constructors.
- **JPA: Java Persistence API used for database interactions.
- **Spring Security: For secure user authentication and authorization.
- **Spring Boot Test: For integration testing and ensuring the application works as expected.

---

## Prerequisites
Before you start, make sure you have the following installed:

- A code editor (e.g., **IntelliJ IDEA**)
- **Java 11** or newer
- **PostgreSQL** (or any compatible relational database)
- **Maven** or **Gradle** for building the project

---

## Acknowledgements

- **Spring Boot**: For providing an easy-to-use framework to build the application.
- **PostgreSQL**: For the powerful and reliable database management system.
- **Lombok**: For simplifying the development process by reducing boilerplate code.
