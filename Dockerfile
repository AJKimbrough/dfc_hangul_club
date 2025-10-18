FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /workspace

#Copy POM first to cache dependencies
COPY pom.xml .
RUN mvn -q -B -DskipTests=true dependency:go-offline

COPY src ./src
RUN mvn -q -B -DskipTests=true package

FROM eclipse-temurin:17-jre
WORKDIR /app

ENV PORT=9090
EXPOSE 9090

COPY --from=build /workspace/target/*-SNAPSHOT.jar /app/app.jar

CMD ["sh","-c","java -jar /app/app.jar --server.port=${PORT}"]
