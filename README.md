---

# Microservices Architecture Project

## Project Overview

This project demonstrates building a robust microservices architecture using Spring Boot. It includes multiple microservices for handling different functionalities such as a **Question Service** and a **Quiz Service**, with service discovery, API gateway, and load balancing mechanisms implemented using Eureka and Spring Cloud tools.

Each microservice is designed to interact seamlessly through RESTful APIs and Feign Clients, making the system scalable and maintainable.

## Table of Contents
1. [Introduction](#introduction)
2. [Microservices](#microservices)
   - [Question Service](#question-service)
   - [Quiz Service](#quiz-service)
3. [Service Discovery with Eureka](#service-discovery-with-eureka)
4. [Inter-service Communication](#inter-service-communication)
5. [Load Balancing and API Gateway](#load-balancing-and-api-gateway)
6. [Getting Started](#getting-started)
7. [Technologies Used](#technologies-used)
8. [How to Run](#how-to-run)

## Introduction

This project is structured to showcase the fundamental concepts of microservices development using Spring Boot and Spring Cloud. Each service is developed and deployed independently but can communicate with other services within the ecosystem. We will explore various concepts such as service discovery, load balancing, API gateway, and inter-service communication.

## Microservices

### 1. Question Service
The **Question Service** manages questions and related operations like adding, updating, and retrieving questions. This service acts as the primary database for the questions used in quizzes.

### 2. Quiz Service
The **Quiz Service** handles the logic for generating quizzes based on categories and retrieving the quiz data for user interactions. It communicates with the Question Service to fetch question data.

## Service Discovery with Eureka

We use **Eureka Server** for service discovery. Each microservice registers itself to the Eureka server, which maintains a registry of all active services. This enables efficient communication between services and supports dynamic scaling.

## Inter-service Communication

Services interact with each other using **OpenFeign**, which simplifies HTTP-based communication. The **Quiz Service** uses Feign to make REST calls to the **Question Service** for fetching the required data.

## Load Balancing and API Gateway

### Load Balancing
**Spring Cloud LoadBalancer** is integrated to distribute the load between instances of the Question and Quiz services. This helps achieve fault tolerance and efficient resource utilization.

### API Gateway
**Spring Cloud Gateway** serves as a single entry point for clients. It routes requests to the appropriate microservice based on the defined rules and handles cross-cutting concerns such as authentication, logging, and rate limiting.

## Getting Started

### Prerequisites

- Java 17+
- Spring Boot 3.0+
- Maven 3.8+

### Project Structure

The project is divided into multiple modules:
- **question-service**: Manages question data and exposes endpoints for CRUD operations.
- **quiz-service**: Manages quiz creation and interacts with the question service.
- **eureka-server**: Acts as a service registry for microservices.
- **api-gateway**: Handles routing and entry point for microservices.

## Technologies Used

- **Spring Boot** for building standalone applications
- **Spring Cloud Eureka** for service discovery
- **Spring Cloud OpenFeign** for inter-service communication
- **Spring Cloud Gateway** for API gateway
- **Spring Cloud LoadBalancer** for client-side load balancing
- **PostgreSQL** as the database for question and quiz data

## How to Run

1. **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/microservices-project.git
    cd microservices-project
    ```

2. **Build and Run the Eureka Server:**
    ```bash
    cd eureka-server
    mvn clean install
    mvn spring-boot:run
    ```

3. **Build and Run the Question Service:**
    ```bash
    cd ../question-service
    mvn clean install
    mvn spring-boot:run
    ```

4. **Build and Run the Quiz Service:**
    ```bash
    cd ../quiz-service
    mvn clean install
    mvn spring-boot:run
    ```

5. **Build and Run the API Gateway:**
    ```bash
    cd ../api-gateway
    mvn clean install
    mvn spring-boot:run
    ```

6. **Access Services:**
   - Eureka Server: `http://localhost:8761`
   - Question Service: `http://localhost:8081`
   - Quiz Service: `http://localhost:8082`
   - API Gateway: `http://localhost:8080`

## Contributors

- [Prajwal Kuchewar](https://github.com/prajwal018) - Project Developer and Architect

Feel free to reach out with any questions or feedback!

---
