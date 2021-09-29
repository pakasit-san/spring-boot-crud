# spring-boot-crud-jpa

## Overview
This is a simple application to show how to use Spring Data JPA with Spring Boot, Demonstrated with the RESTFul api for CRUD and connect MySQL database via docker container.

## Software and Tools
- Java
- MySQL
- Docker
- IDE (IntelliJ IDEA)

## Quick start
* Import the project into IDE (IntelliJ IDEA) as Maven Project
* Add dependencies and configurations
* Start MySQL as docker container
* Find `SpringBootCrud.java` from sidebar, right-click on the file, select 'Run'
* CRUD endpoints. Please check file `UserController.java`

## Dependencies
Please add dependencies to `pom.xml` file
```
<!-- Dependency for create RESTFul api -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Dependency for create spring data jpa -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Dependency for connect mysql -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Dependency for avoid Boilerplate code -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```

## Configurations
Please add configuration to `application.properties` file
```
#Server port
server.port=9000

#Data source config for username, password, host, driver and other
spring.datasource.username=admin
spring.datasource.password=1234
spring.datasource.url=jdbc:mysql://host.docker.internal:3306/example
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
```

## MySQL
Running MySQL as docker container start up following command:

Pull docker image
```
docker pull mysql:5.6
```

Start up docker container
```
docker run --name mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=example -e MYSQL_USER=admin -e MYSQL_PASSWORD=1234 -d -p 3306:3306 mysql:5.6
```
* `--name mysql` set docker container name
* `-e MYSQL_ROOT_PASSWORD=password` set root password
* `-e MYSQL_DATABASE=example` set database name
* `-e MYSQL_USER=admin` set database user
* `-e MYSQL_PASSWORD=1234` set database password
* `-d` run docker container as daemon
* `-p 3306:3306` expose port
* `mysql:5.6` image name and version

## CRUD
endpoint `http://localhost:9000/api/v1`
* `POST: /users` create user
* `GET: /users` get all user
* `GET: /users/{userId}` get user by userId
* `PUT: /users/{userId}` update user by userId
* `DELETE: /users/{userId}` delete user by userId

## Example
Request
```
curl --location --request GET 'localhost:9000/api/v1/users'
```

Response
```
{
    "status": {
        "code": "SUCCESS",
        "message": "success"
    },
    "data": [
        {
            "id": 14,
            "firstName": "Johnny",
            "lastName": "Depp",
            "mobileNumber": "0800000000",
            "email": "johnny.d@mycompany.com"
        }
    ]
}
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Spring Data JPA documentation](https://github.com/spring-projects/spring-data-jpa)

