# EJB Client Project

This project contains a Java client application that connects to a remote EJB deployed on a WildFly server. The client demonstrates how to invoke methods on a remote EJB using JNDI.

## Project Structure

The project follows a standard Maven structure. Below is a breakdown of the important files:

- `src/main/java/org/example/`:
  - `Main.java`: Contains the main client logic to connect to and invoke the remote EJB.
  - `Hello.java`: Interface matching the remote EJB.

## Prerequisites

Before running the client application, ensure you have the following tools installed:

- **Java Development Kit (JDK) 17 or later**
- **Maven 3.6.0 or later**: 
- **WildFly client libraries**

## Notes 
- make sure your server is runing on 8080
- you can add a properties file to reduce code in the Main class .
