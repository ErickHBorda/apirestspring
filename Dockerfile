FROM amazoncorrectto:17-alpine-jdk

COPY target/apirfds220241-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]