# SpectrumCodingChallenge

## Requirements

For building and running the application you need:

- [JDK 11.0](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## EndPoints
http://localhost:8080/api/v1/data
http://localhost:8080/api/v1/data/sortByAsc?sortBy=organization
http://localhost:8080/api/v1/data/sortByAsc?sortBy=releaseCount
http://localhost:8080/api/v1/data/sortByAsc?sortBy=labourHours
http://localhost:8080/api/v1/data/sortByDesc?sortBy=organization
http://localhost:8080/api/v1/data/sortByDesc?sortBy=releaseCount
http://localhost:8080/api/v1/data/sortByDesc?sortBy=labourHours
http://localhost:8080/api/v1/organization/export
