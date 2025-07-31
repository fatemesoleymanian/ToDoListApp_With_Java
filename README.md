# 📝 ToDo List Application

A simple yet complete CRUD-based **ToDo List** web application built with **Spring Boot**, **Thymeleaf**, **Hibernate (JPA)**, **Lombok**, **Bootstrap 5**, and **Dockerized** for deployment on **Render**.  

---

## 📌 Features

- Add, view, delete, and toggle tasks
- Server-side rendered UI with Thymeleaf
- Responsive design using Bootstrap 5
- Clean MVC architecture
- Fully containerized with Docker
- In-memory H2 database in production
- Unit and integration tests included
- Free deployment on Render

---

## 🧱 Tech Stack

| Layer        | Technology                      |
|--------------|----------------------------------|
| Backend      | Spring Boot 3.5.4, Spring MVC    |
| ORM          | Spring Data JPA (Hibernate)      |
| Database     | H2 (for production), MySQL (dev) |
| Frontend     | Thymeleaf + Bootstrap 5          |
| Dependency   | Maven                            |
| Boilerplate  | Lombok                           |
| Testing      | JUnit 5, Mockito, Spring MockMvc |
| Container    | Docker                           |
| IDE          | IntelliJ IDEA                    |
| Deployment   | Render (free tier)               |

---

## 🗂️ Project Structure

```

src/
├── main/
│   ├── java/
│   │   └── com.app.ToDoList/
│   │       ├── controller/
│   │       │   └── TaskController.java
│   │       ├── model/
│   │       │   └── Task.java
│   │       ├── repository/
│   │       │   └── TaskRepository.java
│   │       └── service/
│   │           └── TaskService.java
│   └── resources/
│       ├── templates/
│       │   └── tasks.html
│       └── application.properties
├── test/
│   └── java/com.app.ToDoList/
│       ├── controller/TaskControllerTest.java
│       └── service/TaskServiceTest.java

````

---

## 📄 API Endpoints

| Method | Endpoint            | Description               |
|--------|---------------------|---------------------------|
| GET    | `/`                 | View all tasks            |
| POST   | `/`                 | Create a new task         |
| GET    | `/{id}/delete`      | Delete a task by ID       |
| GET    | `/{id}/toggle`      | Toggle task completion    |

---

## 🧪 Testing

Unit and integration tests are written using **JUnit 5**, **Mockito**, and **Spring Boot Test**.

Run tests with:

```bash
./mvnw test
````

Test Coverage:

* ✅ `TaskServiceTest` (unit logic: create, toggle, delete, getAll)
* ✅ `TaskControllerTest` (endpoint coverage with MockMvc)

---

## 🐳 Docker Support

### `Dockerfile`

The project includes a multi-stage `Dockerfile` for optimized builds and deployment.

### Build & Run Locally

```bash
docker build -t todo-list .
docker run -p 8080:8080 todo-list
```

> 🐳 The app uses H2 in-memory DB so it runs out of the box inside Docker.

---

## 🔧 Production Configuration (Render)

### `application.properties`

```properties
# H2 (in-memory) database used for production
spring.datasource.url=jdbc:h2:mem:todo;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

---

## 🚀 Deployment (Render)

Deployed for free using [Render](https://render.com).

Steps:

1. Push your code to GitHub.
2. Create a new Web Service in Render.
3. Use Docker environment.
4. Render builds your image from the `Dockerfile`.
5. Your app will be available at a public URL.

> 💡 Uses in-memory H2 DB, so no extra database setup is required.

---

## ✅ How to Run Locally (Dev)

### 1. Clone the repository

```bash
git clone https://github.com/fatemesoleymanian/ToDoListApp_With_Java.git
cd ToDoListApp_With_Java
```

### 2. (Optional) Setup MySQL

If you want to use MySQL instead of H2:

```sql
CREATE DATABASE <database-name>;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<database-name>
spring.datasource.username=<user-name>
spring.datasource.password=<password>
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the app

```bash
./mvnw spring-boot:run
```

Then visit: `http://localhost:8080/`

---

## 📸 UI Preview

![img.png](img.png)

---

## 🧠 Learning Outcomes

* Spring Boot MVC architecture
* Using JPA with Hibernate (MySQL + H2)
* Thymeleaf templating
* Bootstrap for responsive design
* Unit & controller testing
* Dockerizing Spring Boot apps
* Deploying to Render (free cloud hosting)

---

## ✍️ Author

**Fateme Soleymanian**
[LinkedIn](https://www.linkedin.com/in/fateme-soleymanian-b2713a225) • [GitHub](https://github.com/fatemesoleymanian) • [Portfolio](https://dark-cake-0993.on.fleek.co/)

---

## 🪪 License

This project is licensed under the MIT License.
