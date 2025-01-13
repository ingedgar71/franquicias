# Spring Boot Application - Prueba Técnica franquicias

Esta aplicación desarrollada con **Spring Boot** es una prueba técnica para aplicar a una vacante en la compañia Accenture. La aplicación proporciona servicios relacionados con la gestión de franquicias, sucursales y productos, utilizando programación reactiva.

---

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalados los siguientes requisitos en tu entorno local:

1. **Java 17** (Recomendado usar [Amazon Corretto 17](https://aws.amazon.com/es/corretto/)).
2. **Maven** (versión 3.6 o superior).
3. **PostgreSQL** (versión 16).
4. **Git** (para clonar el repositorio).
5. Un **IDE** como IntelliJ IDEA (opcional pero recomendado).

---

## Configuración del Proyecto

### 1. Clonar el Repositorio

Clona el proyecto desde el repositorio remoto:

```bash
git clone https://github.com/ingedgar71/franquicias.git
cd franquicias

### 2. Configuración Base de Datos PostgreSQL

CREATE DATABASE franquicias;
Luego desde "Query Tools" de la aplicación pgAdmin corre el script proveido para la creación de la base de Datos "scriptCreacionBD.sql"

Configura las credenciales de acceso en el archivo application.properties, Ej:

spring.r2dbc.url=r2dbc:postgresql://localhost:5432/franquicias
spring.r2dbc.username=postgres
spring.r2dbc.password=admin

---

### 3. Configuración y ejecución de aplicación SpringBoot

Construye el proyecto ejecutando el siguiente comando:

mvn clean install

Esto descargará todas las dependencias y generará un archivo JAR en el directorio target

Una vez iniciada, la aplicación estará disponible en:
http://localhost:8080

Endpoints Disponibles

A continuación, una lista de los endpoints principales:

Franquicias
POST /franchise/create: Crear una nueva franquicia.
PUT /franchise/{id}/update-name?name=NOMBRE: Actualizar el nombre de una franquicia.

Sucursales
POST /branch/create: Crear una nueva sucursal.
PUT /branch/{id}/update-name?name=NOMBRE: Actualizar el nombre de una sucursal.

Productos
POST /product/create: Crear un nuevo producto.
Ejemplo desde Postman:
Url: http://localhost:8080/product/create
Body de la petición
{
	"productName": "producto 3",
    "stock": 27,
    "idBranch": 1
}

PUT /product/{id}/update-stock?stock=NUMERO: Actualizar el stock de un producto.
PUT /product/{id}/update-name?name=NOMBRE: Actualizar el nombre de un producto.
DELETE /product/delete/{id}: Eliminar un producto.
GET /product/top-stock/{idFranchise}: Listar productos con mayor stock por sucursal para una franquicia específica.
Desde Postman:
http://localhost:8080/product/top-stock/1