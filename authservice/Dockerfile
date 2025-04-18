# Use the official OpenJDK 21 image (change to the correct version if needed)
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/authservice-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (default port for Spring Boot applications)
EXPOSE 8080

# Run the application with the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
