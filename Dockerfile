# Используем официальный образ Gradle для сборки
FROM gradle:8.4-jdk17 AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем весь проект
COPY . .

# Собираем JAR внутри Docker
RUN gradle clean build -x test

# Используем OpenJDK 17 для запуска приложения
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный JAR из предыдущего этапа
COPY --from=build /app/core/build/libs/*.jar app.jar

# Добавляем права на выполнение
RUN chmod +x app.jar

# Явно указываем команду для запуска Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
