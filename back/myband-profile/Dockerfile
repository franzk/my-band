FROM gradle:8.10.2-jdk23 AS build

RUN echo "Build profile service !"

WORKDIR /app

COPY --chown=gradle:gradle . .
RUN gradle build --no-daemon

FROM openjdk:23-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar ./app.jar

EXPOSE 8201

ENTRYPOINT ["java", "-jar", "app.jar"]