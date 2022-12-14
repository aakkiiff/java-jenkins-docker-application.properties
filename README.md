# java-jenkins-docker-application.properties
![Diagram](https://github.com/aakkiiff/java-jenkins-docker-application.properties/blob/master/Diagram.jpg?raw=true)
## problem:
We can not use the actual credentials in our application.properties file since we have to store it in repository.So we need to pass the properties file securely.Maybe from Jenkins.
## Possible solutions

 - ***JENKINS***: Pass the whole file from jenkins
 - ***DOCKER***: 
	 - while building use *--secret* tag to pass the secret file
	 - pass as env variable while starting docker container as env variable``docker run --name my-tomcat -p 127.0.0.1:8080:8080 -e APP_DB_DB=mydb -e APP_DB_USER=dbuser tomcat:8-jre8-alpine``
	 - If using AWS ECS we can send the secret Env. variable from the UI
 - ***KUBERNETES***:
		
	 - maybe kubernetes secrets?

# using jenkins
**prereqs:**
	

 1. have your jenkins server up and runnng
 2. have docker installed
 3. install maven in the server and configure with the jenkins
 4. install [config file provider plugin in jenkins](https://plugins.jenkins.io/config-file-provider/)
 5. install  Role-based Authorization Strategy plugin to restrict access to the env files
 6. .......
 
## steps:
 1. push the java code to the repository
 2. make a jenkins pipeline project and use this code: [github url](https://github.com/aakkiiff/java-jenkins-docker-application.properties/blob/master/jenkinsfile)
 3. make the application.properties file from ManageJenkins -> Managed Files and name it as application.properties
 4. get the command (pipelinesyntax -> configfileprovider) to create the configured app.properties file the the same location of your jar file
 5. create credential in jenkins for dockerhub username and password
 6. get the command from pipelineProjectSettings->PipelineSyntax->withcredentials: Bind credentials to variable
 7. change all the docker image name and github link to yours
 8. run the jenkins build.
 9. dockerfile will copy both the jar file and app.properties file inside.
 10. now from your device run the docker compose file from the repo.
 while executing java will pick up the external properties file ! 
 ## Did it work?
 the port number u passed will be seen on the webpage and db url and password will be logged on the console!
