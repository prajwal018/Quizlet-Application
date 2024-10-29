# Base image
FROM openjdk:23-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file (assumes JAR is built in 'target' folder)
COPY target/*.jar app.jar

EXPOSE 8761

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
