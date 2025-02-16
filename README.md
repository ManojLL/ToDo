# ToDo-Task App
## Table of Contents

1. [Overview](#overview)
2. [Prerequisites](#prerequisites)
3. [Building and Running the App](#building-and-running-the-app)
4. [Usage](#usage)

## Overview
This is a simple todo app, developed using react, spring-boot and mysql.

### Class Digram

![image](https://github.com/user-attachments/assets/86dea9c0-1bce-4aac-9f51-af0f37ede551)

### File stucutre

```plaintext
.
├── docker-compose.yml 
├── README.md
├── todo-backend // this folder contains all backend service related to the Todo app
└── todo-frontend  // this folder contains all UI part of the Todo app

```
**E2E testings** can be fount in this [PDF](https://drive.google.com/file/d/1caY0sbP0yWQqJIV8xP1S8pq9Hwrjxqb7/view?usp=sharing) file. 

## Prerequisites

1. Docker
2. Docker Compose
   
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


