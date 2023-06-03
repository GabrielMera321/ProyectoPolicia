# Sistema de Gestión Antinarcóticos

![Policia](https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Distintivo_de_la_Direcci%C3%B3n_de_Antinarc%C3%B3ticos_%28Colombia%29.svg/2560px-Distintivo_de_la_Direcci%C3%B3n_de_Antinarc%C3%B3ticos_%28Colombia%29.svg.png)


Este es un sistema de información para la división antinarcóticos de la fuerza policial, diseñado para gestionar datos de agentes, redadas y narcóticos capturados. 

## Tecnologías Utilizadas

- Spring Boot
- MySQL
- JUnit
- Bootstrap
- Hibernate ORM
- iText para generación de PDFs

## Configuración del Proyecto

1. **Clonar el repositorio:** 

git clone https://github.com/GabrielMera321/proyectopologica.git

2. **Importar el proyecto a tu IDE**

Este es un proyecto Maven, puedes importarlo en tu IDE favorito como Eclipse, IntelliJ, etc.

3. **Configurar la Base de Datos**

Asegúrate de tener instalado MySQL. Crea una nueva base de datos y configura los detalles en el archivo application.properties:

4. **Compilación**

Navega al directorio del proyecto y ejecuta el siguiente comando para compilar el proyecto y generar el archivo WAR: mvn clean package

## Despliegue
1. Asegúrate de tener instalado Tomcat.

2. Copia el archivo WAR generado a la carpeta 'webapps' de Tomcat.

3. Inicia Tomcat.

4. Abre un navegador y visita http://localhost:8080/ProyectoPolicia

## Uso del Sistema
El sistema tiene interfaces para gestionar agentes, redadas y narcóticos.

- Para ver la lista de agentes, visita http://localhost:8080/agentes
- Para agregar un nuevo agente, visita http://localhost:8080/agentes/nuevo
- Para editar o eliminar un agente existente, haz clic en el botón 'Editar' o 'Eliminar' junto a los detalles del agente en la lista.
Los enlaces para las redadas y los narcóticos son similares.

# Diagrama de clases del proyecto:
