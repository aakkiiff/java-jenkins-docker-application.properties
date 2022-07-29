FROM openjdk:11

WORKDIR /app

COPY target/*.jar app.jar

COPY target/application.properties .

EXPOSE 666

CMD [ "java","-jar", "app.jar"]