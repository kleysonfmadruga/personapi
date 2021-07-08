# Person API

![License](https://img.shields.io/github/license/kleysonfmadruga/personapi)
![Last commit](https://img.shields.io/github/last-commit/kleysonfmadruga/personapi)

## Description
A simple API to manage persons and departments in a company written in Java, using Spring Boot framework and H2 database. This project is also deployed in Heroku platform.

## Running in your PC
To run the project in your PC, you must, at first, install the dependencies and build the project executing the command ```mvn install```
Then run ```mvn spring-boot:run``` to start the Spring Boot application in the 8080 port.

## Using the endpoints
### Handling with persons
- To get all persons, use the URL ```http://localhost:8080/api/v1/persons``` with GET method.
- To get a single person, use the URL ```http://localhost:8080/api/v1/persons/{id}``` with GET method.
- To delete a person, use the URL ```http://localhost:8080/api/v1/persons/{id}``` with DELETE method.
- To create a person, use the URL ```http://localhost:8080/api/v1/persons/``` with POST method and JSON body like the example below.
- To edit a person, use the URL ```http://localhost:8080/api/v1/persons/{id}``` with PUT method and JSON body like the example below.
- Example of person data:
```json
{
  "firstName": "Joe",
  "lastName": "Carrots",
  "cpf": "insert some valid cpf with the numbers separated dots and hyphen",
  "birthDate": "01-01-1999",
  "phones": [
    {
      "type": "COMMERCIAL",
      "number": "0011999999999"
    }
  ]
}
```
