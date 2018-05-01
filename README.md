## Movie Reservation

This app calls micro service running at localhost:9090

### Prerequisites

```
Spring Boot 2
Gradle
H2 Database (build-in)
Swagger
Intellij
Chrome browser and Chrome Driver for Acceptance testing

```

### Installing

```
Download the git repository and use gradle plugin in Intellij
```

## Running the tests
```
To run all the test
  gradle clean test
  
To Bootrun
  gradlew clean bootrun 
  Server starts at localhost:8080

Application can be accessed using http://localhost:8080/moviereservation
This communicates with movieprice microservice runnig at http://localhost:9090/movieprices
