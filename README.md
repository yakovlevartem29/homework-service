# Homework service

## Links

* [Github project](https://github.com/yakovlevartem29/homework-service)
* [Heroku app](https://homework-artem.herokuapp.com/)

## Prerequisites
  * [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
  * [Maven 3.2+](https://maven.apache.org/download.cgi)

## Build HOW TO
* Maven: Build with unit tests `mvn clean package`
* Run unit test and generate report `mvn surefire-report:report && mvn project-info-reports:index`.
Report file surefire-report.html will be generated in target/site/ folder

## Run app
* Maven plugin: `mvn spring-boot:run`
* Build app by using maven and then start `java -jar target/string-calc-0.0.1-SNAPSHOT.jar` 

App will start locally on port 5000.

## API docs
* Swagger based API documentation is home page of the app

