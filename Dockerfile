FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ocrmsbca-0.0.1-SNAPSHOT.jar
EXPOSE 9898
ENTRYPOINT ["java", "-jar", "/ocrmsbca-0.0.1-SNAPSHOT.jar"]