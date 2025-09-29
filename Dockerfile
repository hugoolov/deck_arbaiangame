FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} deck.jar
ENTRYPOINT ["java","-jar","/deck.jar"]
EXPOSE 8001