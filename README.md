# Vehicule Rent Backend 

## Introduction
This project is designed to manage vehicules renting system. Built using **Spring Boot**, it provides an easy-to-use functionalities for administrators, suppliers, repairers and clients.

## Actors
This application supports the following user roles:
- **Admin**: Manages the system, including user accounts and existed locations.
- **Repairer**: Handles vehicle maintenance and repairs. In fact, he can use tickets and send demands to the supplier to approve the reparation of the car for which has the full repairInfos.
- **Supplier**: Provides vehicle inventory and details. In addition, he can different categories for his vehicules. Finally, he can manage subcriptions, adresses etc..
- **Client**: Books and manages car rentals. He can also follow the reparation of his vehicule.

## File Descriptions

### Backend (Spring Boot)
- `src/main/java/com/project/car_rental`: Contains the main application's logic.
  - `controller`: REST APIs for interacting with the frontend.
  - `service`: Business logic for processing requests.
  - `repository`: Database interactions using JPA.
  - `entity`: Java classes representing database tables.
  - `dto`: Data Transfer Objects to handle frontend-backend communication.
  - `mappers`: Used to map objects to DTOs.
- `application.properties`: Configures database and other services.


### Database
- schema_dump.sql: The database named `vehiculerents` stores application data such as clients, rentals, and vehicles.

### Additional Files
- `README.md`: Project documentation.
- `pom.xml`: Maven dependencies and build configuration.

## Class diagram
Here is a representation of different entities that will be present in the project:
![Alt Text](car_rental/vehicule.png)





## How to Upload and Run the Project

### Prerequisites
- **Java v21**
- **PostgreSQL v17**
- **Maven**
- **Keycloak v25.0.0**
  
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

### Steps to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/kerfaiyass54/vehicule_rent_app.git

2. **Run keycloak**
- Run keycloak server using this command
   ```bash
   kc.bat start-dev
   
3. **Configure Keycloak**
- Go to http://localhost:8080
- Create the realm and then go through it to create the client
- Create roles 'admin', 'client', 'repair' and 'supplier'
- Create new user and assign roles (start with the admin)

4. **Configure application.properties**
- Go to application.properties
- Update the different attributes you find with your information

5. **Create the database**
- Use the file .sql to fill the database you will use

6. **Run the app**
   ```bash
   mvn spring-boot:run
   

