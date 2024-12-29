
#FROM maven:3.8.2-jdk-8-slim AS step1
FROM maven:3.9.9-amazoncorretto-17-debian-bookworm AS step1
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/app/pom.xml -DskipTests=true clean package

#FROM openjdk:8-jdk-alpine
FROM eclipse-temurin:17.0.13_11-jre-ubi9-minimal
VOLUME /tmp
EXPOSE 8080
COPY --from=step1 /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]
