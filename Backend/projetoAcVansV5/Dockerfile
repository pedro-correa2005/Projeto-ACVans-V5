# Etapa 1: compilação da aplicação
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /workspace

# Copia primeiro as dependências do projeto
COPY pom.xml .
COPY .mvn .mvn

# Copia o código-fonte
COPY src ./src

# Compila e empacota a aplicação
RUN mvn -B -DskipTests package


# Etapa 2: execução da aplicação
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]