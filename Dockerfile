FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . .
RUN ./mvnw clean install -DskipTests || mvn clean install -DskipTests
CMD ["java", "-jar", "target/ip-app-0.0.1-SNAPSHOT.jar", "--server.port=8080", "--server.address=0.0.0.0"]
EXPOSE 8080