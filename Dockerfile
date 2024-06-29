FROM gradle:8.4-jdk17 as build
WORKDIR /app
COPY . .
RUN cd core && gradle clean bootJar --no-daemon


FROM openjdk:23-ea-17-slim
WORKDIR /app
COPY --from=build /app/core/build/libs/core.jar /app
ENTRYPOINT ["java", "-jar", "core.jar"]