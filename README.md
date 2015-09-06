#Spring Boot based CharGrouper implementation.

This is a sample application based on Spring Boot application. 
This is a gradle based project. For usage and execution, run "gradle build"  and "gradle bootRun"  to execute all the compile steps and Junit tests execution, and Spring uses embedded tools to deploy a web app on the server address and port provided in application.properties.
The build also generates a jar file, and you may skip "gradle bootRun"  step. The jar file can be executed normally via "java -jar CharGroup.jar"  command and the web app will be deployed.

The app consists of a simple frontend based on AngularJS and Twitter Bootstrap CSS which executes certain basic validations on the frontend, and then executes a REST API, exposed by Spring Boot application, via $http of angularJS.
The input String is first sorted based on characters and then compressed based on the occurrences of the characters.
There are unit tests which test the functionality of the software, which can be executed via Eclipse, or they will eventually be executed via "gradle build"  step.
There is one Page Object Pattern based Selenium Web Driver Test, which needs a server up and running, and uses Firefox driver to open Firefox browser and execute test cases.
There is another Integration test, which first launches the application(server should be down) and then hits the server with the appropriate REST call with GET HTTP verb.
This is a completely XML-less approach to web application.

Minimum Gradle Version :2.2.1
Java Version:1.8
Please feel free to suggest changes.
