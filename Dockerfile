# Use official Maven image to build the application
FROM maven:3.9-eclipse-temurin AS build
WORKDIR /app
COPY product-service .
RUN mvn clean install -Dmaven.test.skip=true


# Use a minimal JDK image to run the app
FROM eclipse-temurin:22-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
