# Spring Boot Boilerplate

A simple example to create Blogs with name and content stored in a local Mysql DB.

## Installation

create the file src/main/resources/application.properties, where the 
environment variables are stored

```
// Server Port
server.port=4000

// Mysql configuration
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springdb
spring.datasource.username=root
spring.datasource.password=root
```

## Run

### Without docker
```
// Remove the compiled code
mvn clean

// Compile the code
mvn package

// Start the server
java -jar target/demo-0.0.1-SNAPSHOT.jar

Open browser on localhost:4000
```

### With Docker 
```
In the Dockerfile folder

// Build image
docker build -t demo .

// Run container
docker run -p 4000:4000 demo

// Stop container
1- docker ps
2- Copy docker container ID
3- docker stop CONTAINER_ID

Open browser on localhost:4000
```

## API
### Return all blogs in the DB
GET /blog


### Return the specified blog
GET /blog?name="Blog Name"

### Create a new Blog
POST /blog

{
  "name": "Blog",
  "content": "Content and other information"
}


## Dependencies

- JPA
- Mysql driver
- Lombok 
- Devtools
- Web
