# SpectrumCodingChallenge

## Requirements

For building and running the application you need:

- [JDK 11.0](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Lombok Plugin in IDE] 

I've used Intellij IDEA for developing and executing the application.

## Running the application locally

Execute/Run the `main` method in the `SpectrumApplication` class in package `com.spectrum` from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## EndPoints

Endpoint for retrieving data :
http://localhost:8080/api/v1/data


Endpoint for retrieving data when in ascending order by organization :
http://localhost:8080/api/v1/data/sortByAsc?sortBy=organization

Endpoint for retrieving data when in ascending order by releaseCount :
http://localhost:8080/api/v1/data/sortByAsc?sortBy=releaseCount


Endpoint for retrieving data when in ascending order by labourHours :
http://localhost:8080/api/v1/data/sortByAsc?sortBy=labourHours

Endpoint for retrieving data when in descending order by organization :
http://localhost:8080/api/v1/data/sortByDesc?sortBy=organization

Endpoint for retrieving data when in descending order by releaseCount :
http://localhost:8080/api/v1/data/sortByDesc?sortBy=releaseCount

Endpoint for retrieving data when in descending order by labourHours :
http://localhost:8080/api/v1/data/sortByDesc?sortBy=labourHours

Endpoint for exporting data in csv format:
http://localhost:8080/api/v1/organization/export
