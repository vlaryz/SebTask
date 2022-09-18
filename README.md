# SEB Task for Test Data Solution Developer role

# Usage
To run Spring Boot server side project: 

1. Open Command Line and change directory to root folder of the project.
2. Type ```mvn package``` to build the project and execute tests.
3. To run project type ```cd target```, then type ```java -jar jarFile``` (jarFile probably would be "SebTask-0.0.1-SNAPSHOT.jar")<br/>
By default Spring Boot shold run on localhost port :8080
* Alternatively you can open the project with IntelliJ IDE, then build and run from it using UI.

To run Angular frontend project: 

1. Open Command Line and change directory to root folder of the project.
2. Type ```cd SebTaskUi``` to open UI project root foler.
3. Type ```npm install``` and then ```ng serve``` to start Angular project.<br/>
By default Angular shold run on localhost port :4200

# Features
1. User can add Customer to DB.
2. User can see all Customers.
3. User can get full data preview about Customer by clicking 'Details' button.
4. User can filter Customers list.
