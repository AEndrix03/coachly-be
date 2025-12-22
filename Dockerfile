# =========================
# BUILD STAGE
# =========================
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY . .
RUN mvn clean package -DskipTests

# =========================
# RUNTIME STAGE (DISTROLESS JAVA)
# =========================
FROM gcr.io/distroless/java21-debian12:nonroot
WORKDIR /app

COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar api.jar

USER root
RUN mkdir -p /app/javatmp && chown -R nonroot:nonroot /app/javatmp
USER nonroot

EXPOSE 8443

ENTRYPOINT ["java","-XX:+UseContainerSupport","-XX:MaxRAMPercentage=75","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","api.jar"]
