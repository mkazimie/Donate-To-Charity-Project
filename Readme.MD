## Donate To Charity Project

The aim of the project is to create a place where everyone can donate unnecessary goods (clothes, toys, etc.) to
 trusted institutions.
 
The author of the project idea and layout is a CodersLab IT School graduate. 


#### About the Idea
We all have items at home that we don't use anymore, but which are in good condition. We often want to give them away
 to people who may need them - but it's not always as easy as it seems. There are many solutions available, but many
  of them require extra effort or are untrustworthy. This app makes donating unnecessary goods easy. 
 

![](./src/main/webapp/resources/images/charity-layout.png)

### Technology:
* Java - v.8
* Spring Boot -v.2.1.4
* Spring Data JPA
* Spring MVC
* Spring Security
* JSP
* MySQL
* Maven


### Run the Application Locally:

* Download the project.

#### DB setup:

* Connect to MySQL using your credentials and create an empty database.

* Go to `src/main/resources/application.properties` and update the datasource url, username and password according to
 your MySQL configuration. The table schema will be created for you in your database.

#### Run:

* Execute the `$ mvn spring-boot:run` command in our project root folder. 

* The app will start running at http://localhost:8080.