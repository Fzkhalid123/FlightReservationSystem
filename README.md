# Flight Reservation System

This is a Java-based desktop application for booking and managing flight reservations. The application provides an intuitive interface to:

- Book flights by selecting source and destination
- Fetch passenger details using Aadhar number
- View available flights
- Generate boarding passes
- Cancel reservations

## Features

- Java Swing GUI for a smooth user experience
- MySQL database integration for storing reservation data
- JDBC for database connectivity
- Date selection with JDateChooser
- Clear and responsive interface

## Technologies Used

- Java (Swing & AWT)
- MySQL
- JDBC
- IntelliJ IDEA

## How to Run

1. **Set up the MySQL Database**
   - Create a MySQL database.
   - Create the required tables (`passenger`, `flight`, `reservation`) with appropriate columns.
   - Update the `DBConnection` class with your MySQL credentials.

2. **Build and Run**
   - Open the project in IntelliJ IDEA.
   - Ensure MySQL is running.
   - Run the main classes, for example:
     - `BookFlight.java` to book tickets
     - `BoardingPass.java` to generate boarding passes
     - `Cancel.java` to cancel reservations

3. **Dependencies**
   - [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
   - [rs2xml.jar](https://sourceforge.net/projects/finalangelsanddemons/)
   - [jcalendar.jar](https://toedter.com/jcalendar/)


## Author

**Faiz Khalid**

---

