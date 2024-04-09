FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/url-shortener-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080

# Variables de entorno para la base de datos
ENV DB_HOST=$DB_HOST \
    DB_NAME=$DB_NAME \
    DB_USER=$DB_USER \
    DB_PASSWORD=$DB_PASSWORD

ENTRYPOINT ["java","-jar","demo.jar"]