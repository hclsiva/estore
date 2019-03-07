# E-Store
E-Store application for practicing full stack application development

# Libraries used to develop
## Frontend
  ExtJs 6.2 GPL (framework based on javascript), Html 5, javascript, CSS.
  If required I am planning to use other javascript library such as bootstrap.js etc.
  Websocket messages will be used for notifying frontend
## Framework 
  Springboot framework. First a single instance of the application will be developed which can be scaled later.
## Intended to use
    Rest Controller 
    Business logic area
    Hazelcast Cache
    Hibernate ORM 
    MySQL Database.

Application will run in tomcat
# How to run Application
1. Clone the Application
2. goto src >> main and unzip webapp.zip into the same folder
3. run mvn clean install in the application folder.
4. java -jar target/estore-0.0.1-SNAPSHOT.jar
5. launch localhost:7999/login.html


