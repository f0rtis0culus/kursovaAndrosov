# Базовый образ с Java 17
FROM openjdk:17-jdk-slim

# Рабочая директория внутри контейнера
WORKDIR /app

# Копируем jar-файл (замени имя ниже на своё!)
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Команда запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
