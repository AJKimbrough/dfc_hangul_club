# ---- Build stage ----
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml .
# Cache dependencies
RUN mvn -q -B -DskipTests=true dependency:go-offline
COPY src ./src
RUN mvn -q -B -DskipTests=true package

# ---- Run stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app
ENV PORT=8080
EXPOSE 8080
COPY --from=build /workspace/target/dfc-hangul-0.0.1-SNAPSHOT.jar app.jar
CMD ["sh","-c","java -jar app.jar --server.port=${PORT}"]
