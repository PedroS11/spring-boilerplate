# Spring Boot Boilerplate

A simple example to create Blogs with name and content stored in a local Mysql DB.

## Instalation

src/main/resources/application.properties

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
```
Remove the complided code
mvn clean

Compile the code
mvn package

Start the server
java -jar target/demo-0.0.1-SNAPSHOT.jar

On browser open localhost:3000
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
