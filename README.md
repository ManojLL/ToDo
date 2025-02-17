# ToDo-Task App
## Table of Contents

1. [Overview](#overview)
2. [Prerequisites](#prerequisites)
3. [Building and Running the App](#building-and-running-the-app)
4. [Usage](#usage)

## Overview
This is a simple todo app, developed using react, spring-boot and mysql. This To-Do app allows users to add tasks with two input fields for the task title and description. After filling out both fields, clicking the **Add** button adds the task to the top of the list. Each task has a blue complete button with a `checkmark` icon. Clicking this button moves the task to the completed status and removes it from the active task list.  **E2E testings** can be find in this [PDF](https://drive.google.com/file/d/1caY0sbP0yWQqJIV8xP1S8pq9Hwrjxqb7/view?usp=sharing) file. 

| ![image](https://github.com/user-attachments/assets/91602cce-e611-4856-a26e-bf6ff8e41267) |  ![image](https://github.com/user-attachments/assets/0ac1cac3-88d5-49a7-8741-d79dfa619987) |
| --- | --- |

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
    cd ToDo/
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

### API End-points

**Add new task - POST**

```
http://localhost:8080/api/v1/tasks
```
payload 

```
{
"title" : "dummy task title",
"description": "dummy task description",
"compleled": false
}
```
**Complete a task - PUT**

```
http://localhost:8080/api/v1/tasks/{taskID}
```
payload 

```
{
"title" : "dummy task title",
"description": "dummy task description",
"compleled": true
}
```

** Get latest five task - GET**
```
http://localhost:8080/api/v1/tasks/topFive
```
payload 

```
[
   {
   "title" : "dummy task title 1",
   "description": "dummy task description",
   "compleled": flase
   },
    {
   "title" : "dummy task title 2",
   "description": "dummy task description",
   "compleled": flase
   },
]

```
