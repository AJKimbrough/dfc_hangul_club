# ---- Build stage ----
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /workspace

# Copy just the POM first to cache dependencies
COPY pom.xml .
RUN mvn -q -B -DskipTests=true dependency:go-offline

# Now copy sources and build
COPY src ./src
RUN mvn -q -B -DskipTests=true package

# ---- Run stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app

# Render sets PORT at runtime; Spring Boot should bind to it
ENV PORT=8080
EXPOSE 8080

# Copy the *repackaged* Spring Boot jar (exclude any "original-*.jar")
# If you do produce an original jar, uncomment the longer COPY below.
COPY --from=build /workspace/target/*-SNAPSHOT.jar /app/app.jar
# COPY --from=build /workspace/target/*.jar /tmp/
# RUN sh -c 'ls /tmp/*.jar | grep -v original | xargs -I{} mv {} /app/app.jar && rm -rf /tmp/*'

CMD ["sh","-c","java -jar /app/app.jar --server.port=${PORT}"]
