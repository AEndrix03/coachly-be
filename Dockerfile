# BUILD
FROM maven:3.9.8-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY . .
RUN mvn clean package -DskipTests

# RUNTIME
FROM gcr.io/distroless/java21-debian12:nonroot
WORKDIR /app
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar api.jar
EXPOSE 8443
ENTRYPOINT ["java", "-jar", "api.jar"]