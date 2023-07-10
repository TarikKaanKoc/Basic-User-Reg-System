<h1 align="center">📸 Application Preview 👨‍💻</h1>

https://github.com/TKaanKoc/Basic-User-Reg-System/assets/83168207/db5a8fd2-ed19-4d43-a36b-5d821c085223


<h1 align="center">🎓💻📚 Web Programming Lesson ~ Homework 👨‍💻</h1>

<div align="center">
    <strong>This project is an assignment given by Hamit Mızrak for the Web Programming course. The goal of the assignment is to develop a web application that allows users to enter their username and password. The application will then send the data to a Spring API, which will save it to the database. After saving the data, the application will retrieve it using a jQuery GET request and display it using console.log or in the UI.</strong>
</div>
<br/>


<h2 align="center">📁 Project Structure 🗂️</h2>

```bash
src
├── main
│   ├── java
│   │   └── com
│   │       └── koc
│   │           └── finalproject
│   │               ├── FinalprojectApplication.java
│   │               ├── controller
│   │               │   └── UserController.java
│   │               ├── dto
│   │               │   └── UserDto.java
│   │               ├── entity
│   │               │   └── User.java
│   │               ├── repository
│   │               │   └── IUserRepository.java
│   │               └── service
│   │                   └── UserService.java
│   └── resources
│       ├── application.properties
│       ├── static
│       │   ├── background.html
│       │   ├── css
│       │   │   ├── bootstrap.min.css
│       │   │   ├── bootstrap.min.css.map
│       │   │   └── style.css
│       │   └── js
│       │       └── main.js
│       └── templates
│           ├── getall.html
│           ├── login.html
│           └── register.html
```

### 📌 The project structure is organized as follows:

* `src/main/java/com/koc/finalproject:` Contains the Java source code files.
  * `FinalprojectApplication.java:` The main class of the Spring Boot application.
  * `controller/UserController.java:` Defines the REST API endpoints for user-related operations.
  * `dto/UserDto.java:` Data transfer object for user information.
  * `entity/User.java:` Entity class representing a user in the database.
  * `repository/IUserRepository.java:` Interface for user repository, which provides database operations.
  * `service/UserService.java:` Service class for handling user-related business logic.
* `src/main/resources:` Contains the configuration files and static resources.
  * `application.properties:` Configuration file for Spring Boot.
  * `static:` Directory for static files used in the frontend.
  * `background.html:` HTML file for displaying animated circles in the background.
  * `css:` Directory for CSS files.
    * `bootstrap.min.css:` Minified version of the Bootstrap CSS framework.
    * `bootstrap.min.css.map:` Source map file for Bootstrap CSS.
    * `style.css:` Custom CSS styles for the application.
  * `js:` Directory for JavaScript files.
    * `main.js:` JavaScript file for handling form submissions and AJAX requests.
* `src/main/resources/templates:` Contains the HTML templates for the frontend.
  * `getall.html:` HTML template for displaying all users in a table.
  * `login.html:` HTML template for the login page.
  * `register.html:` HTML template for the registration page.

### 📌 Dependencies:

* Lombok 🌟
* Spring Boot Starter Data JPA 🌐
* Spring Boot Starter Validation ✅
* Spring Boot Starter Thymeleaf 🍃
* Spring Boot Starter Test 🧪
* Spring Boot Starter Web 🌐
* Spring Boot DevTools 🛠️
* H2 Database 🗄️


### 📌 Usage

To run the project, you need to have Java and Maven installed on your system.

1. Clone the repository:

```bash
git clone <repository-url>
```

2. Navigate to the project directory:


```bash
cd finalproject
```

3. Build the project using Maven:

```bash
mvn clean install
```

4. Run the application:

```bash
mvn spring-boot:run
```

5. Access the application in your browser at -> `http://localhost:8080` <- 




<div align="center">
    <strong>Happy Coding! 💻🎉</strong>
</div>









