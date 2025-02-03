# Proyecto Angular + Spring Boot

Este proyecto consta de un **front-end en Angular** y un **back-end en Spring Boot**.

## 🚀 Tecnologías
- **Front-end:** Angular
- **Back-end:** Spring Boot
- **Base de datos:** https://supabase.com(PostgreSQL)

## 📁 Estructura del Proyecto
```
proyecto/
├── angular/       # Front-end en Angular
├── springboot/    # Back-end en Spring Boot
```

## 🔧 Instalación y Ejecución
### 📌 Requisitos
- Node.js y npm
- Angular CLI
- Java 17+
- Maven
- Base de datos (PostgreSQL)

### ▶️ Front-end
```sh
cd angular
npm install
ng serve
```
Acceder en: `http://localhost:4200/`

### ▶️ Back-end
```sh
cd springboot
mvn clean install
mvn spring-boot:run
```
API disponible en: `http://localhost:8080/`

## 📌 API Endpoints
- **GET** `/api/users` - Iniciar sesión
- **POST** `/api/users` - Registrar usuario

