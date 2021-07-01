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

## NOTE : 

Requirement : most_active_months - Array of month (integer) with the highest number of release start dates.

Steps I used to caluclate the most_active_months : It is the array of month (integer) in which there are highest number of release start dates. 

## Example : 

<table>
    <thead>
      <tr>
        <th>organization</th>
        <th>most_active_months</th>
      </tr>
    </thead>
    <tbody>
        <tr>
            <td>Princeton Plasma Physics Laboratory (PPPL)</td>
            <td>[1,2,5,6,7,8]</td>
        </tr>
        <tr>
            <td>Nevada National Security Site/Mission Support and Test Services LLC (MSTS)</td>
            <td>[10]</td>
            </tr>
    </tbody>
  </table>



Once the application is up and tomcat is running in localhost(8080) hit the below URIs:


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
