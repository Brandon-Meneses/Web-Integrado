# Proyecto de ERP Gestión de Inventario - La Librería Nacional

Este proyecto es una aplicación web empresarial desarrollada para la gestión centralizada del inventario de libros en La Librería Nacional. Proporciona una interfaz de usuario que permite a los empleados consultar el stock actualizado, buscar libros, registrar adquisiciones y generar reportes de manera centralizada. El proyecto se desarrollara con Angular para el frontend con Tailwind y DaisyUI, para el backend se utilizara Jakarta EE, ApiREST y JPA para la persistencia de datos. También se utilizará Maven como herramienta de gestión de dependencias y construcción del proyecto.

El proyecto se estructurará siguiendo una arquitectura de tres capas, con una capa de presentación en Angular, una capa de negocio en Jakarta EE y una capa de persistencia en JPA.

Además, se implementarán servicios RESTful en el backend utilizando la especificación JAX-RS de Jakarta EE para permitir la comunicación entre el frontend y el backend de manera eficiente.

El objetivo principal del proyecto es proporcionar una solución completa y escalable para la gestión de inventario de libros en La Librería Nacional, brindando una experiencia de usuario intuitiva y eficiente.

Si tienes alguna pregunta adicional o necesitas más ayuda, no dudes en preguntar.

## Configuración del Proyecto

1. **Clonar el Repositorio:** Para comenzar, clona este repositorio en tu máquina local utilizando el siguiente comando:

    ```
    git clone git@github.com:Brandon-Meneses/Web-Integrado.git
    ```

2. **Instalar Dependencias:** Una vez que hayas clonado el repositorio, navega hasta el directorio del proyecto y ejecuta el siguiente comando para instalar todas las dependencias necesarias:

    ```
    cd proyecto-inventario
    npm install
    ```

3. **Servidor de Desarrollo:** Después de instalar las dependencias, puedes iniciar el servidor de desarrollo local utilizando el siguiente comando. Esto iniciará la aplicación y abrirá automáticamente una ventana del navegador en `http://localhost:4200/`.

    ```
    ng serve
    ```

4. **Crear Nuevos Componentes:** Puedes crear nuevos componentes fácilmente utilizando el Angular CLI. Por ejemplo, para crear un nuevo componente llamado `nuevo-componente`, puedes especificar la ruta relativa al directorio utilizando la opción --dir, ejecuta el siguiente comando:

    ```
    ng generate component nuevo-componente --dir=directorio
    ```

    Esto creará automáticamente los archivos necesarios para el componente en el directorio correspondiente y actualizará automáticamente los archivos de configuración del proyecto.

## Contribución

Si deseas contribuir a este proyecto, asegúrate de seguir las pautas de contribución en [CONTRIBUTING.md](CONTRIBUTING.md). ¡Esperamos tus contribuciones!

## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en ponerte en contacto con el equipo de desarrollo:

- Nombre: Brandon Luis Meneses Solorzano
- Email: blmenesess.19@gmail.com
