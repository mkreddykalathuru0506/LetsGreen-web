# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml ./
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Create a lightweight image for the application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/target/letsGreen-web-0.0.1-SNAPSHOT.jar /app/letsGreen-web.jar

# Expose the port that the application will run on
EXPOSE 8080

# Set the entry point to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "/app/letsGreen-web.jar"]
