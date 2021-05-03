# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

Contact Demo Application

We have used Springboot-Java 8 with  sql database for this project, For the open api spec we have implemented swagger (url:http://localhost:8080/swagger-ui.html#/)
We decided to choose Spring Rest API because For microservices  springboot architecture is the best solution and its the best solution in the market for the rest apis, 

We have implemented the following apis end points:
* `GET /api/contact/` - list all contacts
* `GET /api/contact/postalCode/{postalCode}` - retrieve details of the contact identified by *postal code*
* `POST /api/contact/create` - create a contact and save it in the database
