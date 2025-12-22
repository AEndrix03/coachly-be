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
# JLINK STAGE (custom JVM)
# =========================
FROM eclipse-temurin:21-jdk AS jlink
WORKDIR /jvm

RUN jlink \
  --add-modules java.base,java.logging,java.naming,java.management,java.security.jgss,java.instrument,java.sql,jdk.unsupported \
  --strip-debug \
  --no-man-pages \
  --no-header-files \
  --compress=2 \
  --output /custom-jre

# =========================
# RUNTIME STAGE (DISTROLESS)
# =========================
FROM gcr.io/distroless/base-debian12:nonroot
WORKDIR /app

COPY --from=jlink /custom-jre /jre
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar api.jar

EXPOSE 8443

ENTRYPOINT ["/jre/bin/java","-XX:+UseContainerSupport","-XX:MaxRAMPercentage=75","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","api.jar"]
