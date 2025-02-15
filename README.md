# ToDo-Task App
This is a simple todo app, developed using react, spring-boot and mysql.

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Building and Running the App](#building-and-running-the-app)
3. [Usage](#usage)

## Prerequisites

1. Docker
2. Docker Compose
3. Git
4. Java 17
   
 Additionally, make sure the following ports are free on system, as they will be used by the todo app

- 8080: For Spring Boot backend
- 3307: For MySql database
- 3000: For React frontend

## Building and Running the App

1. **Clone the Repository:** Clone the repository to local machine
    ```bash
       https://github.com/ManojLL/ToDo.git
    ```
3. **Navigate to the Project Directory:**
    ```bash
    cd todo/
    ```
5. **Build and Run the App Using Docker Compose**
   ```bash
   docker-compose up --build
   ```
This command will build the Docker images for both the React frontend, Spring Boot backend and batabse

## Usage

Once the application is running,access the Todo app through browser

frontend (React): http://localhost:3000
backend (Spring-boot): http://localhost:8080


