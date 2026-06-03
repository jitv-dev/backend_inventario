# Backend Inventario

API REST de gestion de inventario multi-bodega construida con Spring Boot y PostgreSQL.

## Tech Stack

- Java 21
- Spring Boot 3.3.6
- Spring Security (JWT stateless)
- Spring Data JPA
- PostgreSQL 17
- jjwt 0.12.6
- SpringDoc OpenAPI 2.5.0 (Swagger)
- Lombok
- Maven

## Requisitos

- JDK 21
- Maven 3.9+
- PostgreSQL 17

## Configuracion

1. Crear la base de datos:

```sql
CREATE DATABASE inventario_db;
```

2. Configurar variable de entorno con la contraseña de PostgreSQL:

```powershell
$env:DB_PASSWORD = "tu_contraseña"
```

3. Ejecutar la aplicacion:

```bash
mvn spring-boot:run
```

La aplicacion arranca en `http://localhost:8080`.

Swagger disponible en `http://localhost:8080/swagger-ui.html`.

## Modulos

| Modulo | Estado |
|---|---|
| Autenticacion (JWT, login, register) | Completado |
| Categorias | En desarrollo |
| Proveedores | Pendiente |
| Productos | Pendiente |
| Bodegas y Stock | Pendiente |
| Movimientos | Pendiente |
| Reportes | Pendiente |

## Roles

- **ADMIN**: acceso total
- **BODEGUERO**: registrar movimientos y consultas (no eliminar ni crear usuarios/categorias)
- **VIEWER**: solo lectura (GET)

## Endpoints

### Auth (publico)

| Metodo | Ruta | Descripcion |
|---|---|---|
| POST | `/api/auth/login` | Iniciar sesion (devuelve token + rol) |
| POST | `/api/auth/register` | Crear usuario (solo ADMIN) |
| GET | `/api/auth/me` | Datos del usuario autenticado |

## Estructura del proyecto

```
src/main/java/com/tuusuario/inventario/
  config/        - Seguridad, Swagger
  controller/    - Controladores REST
  service/       - Logica de negocio
  repository/    - Acceso a datos (JPA)
  model/         - Entidades JPA
  dto/
    request/     - DTOs de entrada
    response/    - DTOs de salida
  exception/     - Excepciones y manejador global
  security/      - JWT, filtros, UserDetailsService
```
