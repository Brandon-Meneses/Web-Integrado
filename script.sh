#!/bin/bash

# Iniciar Spring Boot
echo "Iniciando Spring Boot..."
mvn spring-boot:run &

# Esperar a que Spring Boot se inicie
sleep 10s

# Cambiar al directorio del frontend
cd frontend

# Instalar dependencias de Node.js
echo "Instalando dependencias de Node.js..."
npm install

# Iniciar Angular
echo "Iniciando Angular..."
ng serve