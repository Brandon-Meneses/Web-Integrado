# Proyecto de ERP Gestión de Inventario

Este proyecto tiene como objetivo desarrollar una aplicación web empresarial para la gestión centralizada del inventario de libros en 'La Librería Nacional', una cadena con 25 sucursales distribuidas en diferentes departamentos.

Se utiliza Spring Framework en el backend para construir la capa de servicios, y Angular en el frontend para proporcionar una interfaz de usuario. 

La aplicación permitirá a los empleados consultar el stock actualizado, buscar libros, registrar adquisiciones y generar reportes de manera centralizada, además de contar con endpoints RESTful para la integración con sistemas externos.

### Sustentación del Proyecto

[Documento de Sustentación](#)

## Requerimientos minimos

- Java 17
- Node.js 20
- Angular CLI 17

## Iniciar la aplicación

### Backend

1. Clonar el repositorio
    ```bash
    git clone https://github.com/Brandon-Meneses/Web-Integrado.git

    cd Web-Integrado
    ```

2. Asegurate que `MySQL` esté instalado y corriendo en el puerto `3306`

3. Configura tus credenciales de la base de datos en `src/main/resources/application.properties`

    ```properties
    spring.datasource.username=root
    spring.datasource.password=root
    ```

4. Inicia el servidor backend

    ```bash
    mvn spring-boot:run
    ```

    No es necesario crear la base de datos manualmente, ya que Spring Boot se encargará de crearla automáticamente al iniciar la aplicación.

5. Asegurese que se esté ejecutando en el puerto `8080`
    

### Frontend

1. Angular CLI (opcional si no está instalado)
    ```bash
    npm install -g @angular/cli
    ```
2. Instala las dependencias del frontend
    
    Diríjase a la carpeta `frontend`
    ```bash
    cd frontend
    npm install
    ```
3. Ejecutar la aplicación
    ```bash
    ng serve
    ```
4. Acceder a la aplicación en el navegador
    ```
    http://localhost:4200
    ```

## Contribuye

Crear una bifurcación (Fork) del repositorio y contribuye con tus cambios a través de Pull Requests. Asegurate de describir tus cambios de manera clara en los comentarios.