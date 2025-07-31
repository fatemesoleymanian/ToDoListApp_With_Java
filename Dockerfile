# Stage 1: Build the application using Maven + Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Package the app (skip tests for faster builds)
RUN mvn clean package -DskipTests

# Stage 2: Run the application using a minimal Java 17 image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the jar from builder
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
