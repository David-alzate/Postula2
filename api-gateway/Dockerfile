# Usa una versión estable de JDK
FROM openjdk:23-jdk-slim

# Instalar utilidades necesarias
RUN apt-get update && apt-get install -y sudo curl && rm -rf /var/lib/apt/lists/*

# Crear un grupo y un usuario no privilegiado
RUN groupadd appgroup && useradd -ms /bin/bash -g appgroup appuser

# Crear un volumen y exponer el puerto
VOLUME /tmp
EXPOSE 8080

# Copiar el archivo JAR y el certificado SSL
COPY target/api-gateway-0.0.1-SNAPSHOT.jar /app.jar
COPY src/main/resources/localhost.p12 /localhost.p12

# Cambiar el propietario de los archivos a 'appuser'
RUN chown appuser:appgroup /app.jar /localhost.p12

# Cambiar al nuevo usuario
USER appuser

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]

