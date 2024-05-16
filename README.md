# Proyecto ERP - Gestión de Inventario

Este proyecto tiene como objetivo desarrollar una aplicación web empresarial para la gestión centralizada del inventario de libros en 'La Librería Nacional', una cadena con 25 sucursales distribuidas en diferentes departamentos.

Se utiliza Spring Framework en el backend para construir la capa de servicios, y Angular en el frontend para proporcionar una interfaz de usuario. 

La aplicación permitirá a los empleados consultar el stock actualizado, buscar libros, registrar adquisiciones y generar reportes de manera centralizada, además de contar con endpoints RESTful para la integración con sistemas externos.

### Sustentación del Proyecto

[Documento de Sustentación](https://utpedupe-my.sharepoint.com/:w:/g/personal/u21315835_utp_edu_pe/EXMG4DOCZIFFppQ89Qh4DiAB6hJr6k-9oX3o0qfirQt58g?e=cpAYLz)

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

3. Crea  un nuevo archivo `application.properties` en base a `application.properties.copy`:

    ```bash
    cp src/main/resources/application.properties.copy src/main/resources/application.properties
    ```

   Luego, configura las credenciales de tu base de datos en `src/main/resources/application.properties` que acbas de crear:

    ```properties
   # Ejemplo:
    spring.datasource.username=root
    spring.datasource.password=root
    ```

4. Inicia el servidor backend.
   
   Puede hacerlo corriendo el archivo de `src/main/java/com/utp/webintegrado/WebIntegradoApplication.java` o ejecutando el siguiente comando en la raíz del proyecto:
   
    ```bash
   # Bash:
   chmod +x ./gradlew
    ./gradlew bootRun
    ```
   
    ```bash
    # CMD:
    gradlew.bat bootRun
    ```

    No es necesario crear la base de datos manualmente, ya que Spring Boot se encargará de crearla automáticamente al iniciar la aplicación.


5. Asegurese que se esté ejecutando en el puerto `8080`


6. Consultar la documentación de la API

   Una vez que el servidor esté en funcionamiento, puedes acceder a la documentación de la API generada por Swagger. Esta documentación proporciona detalles sobre los endpoints disponibles, los parámetros que aceptan y los formatos de respuesta que devuelven.

   Para acceder a la documentación de Swagger, abre un navegador web y navega a la siguiente URL:
   
    ```
   http://localhost:8080/swagger-ui/index.html
    ```
   Aquí, podrás ver y probar todos los endpoints de la API.

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
