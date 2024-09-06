# Land Route Calculation Service
This is a Spring Boot service that calculates a possible land route between two countries based on their borders. The application uses a list of country data in JSON format and calculates the route based on the countries' border information.

## Requirements
- Java 17
- Maven
  
## Dependencies
  The project uses the following key dependencies:

- Spring Boot: A framework for building Java web applications.
- Jackson: Used to parse JSON data.
- JUnit 5: For writing unit tests.
- Mockito: For mocking dependencies in unit tests.

All dependencies are managed via Maven, and the required libraries are specified in the `pom.xml` file. When you run `mvn clean install`, Maven will automatically download the required dependencies.

## Getting Started

### Install Java 17
Make sure you have Java 17 installed. You can check the installed version by running:
```
java -version
```
If not installed, you can install it from the official website: Java 17 Downloads

### Install Maven
Ensure that Maven is installed. To verify, run:
```
mvn -version
```
If Maven is not installed, you can install it from the official website: Maven Installation Guide


### Build the project
Once Java and Maven are installed, you can build the project by running the following command in the project's root directory:

```
mvn clean install
```

### Running the Application
To start the application, use the following Maven command:

```
mvn spring-boot:run
```

The service will start on http://localhost:8080/.

## REST API
The service exposes the following REST endpoint:

### Calculate Land Route
- Endpoint: /routing/{origin}/{destination}
- Method: GET
- Description: This endpoint returns a list of country codes representing a land route from the origin country to the destination country. The countries are identified by their cca3 field (three-letter ISO 3166 country codes).
- Example Usage 

Land Route from Czech Republic (CZE) to Italy (ITA)
```
curl -X GET "http://localhost:8080/routing/CZE/ITA" -H "Content-Type: application/json"
```

- Response:

```
{
  "route": ["CZE", "AUT", "ITA"]
}
```

- Error Example: No Land Route Available

If there is no possible land route between the origin and destination, the server returns an HTTP 400 error.

- Example:
```
curl -X GET "http://localhost:8080/routing/CZE/USA" -H "Content-Type: application/json"
```
- Response:
```
{
  "error": "No land route available between CZE and USA"
}
```
## Testing the Application
You can run the unit tests for the application using the following Maven command:
```
mvn test
```
This will execute all the unit tests and provide output indicating the test results.
