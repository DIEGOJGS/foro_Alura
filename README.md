# Foro Alura

Este es un proyecto de foro desarrollado con Spring Boot para el curso de Alura. El proyecto permite la gestión de tópicos, usuarios y respuestas mediante una API REST.

# Configuración del Entorno
## Instalación de Java y Herramientas Necesarias:

      -Java JDK (versión 17 en adelante)
      -Maven (versión 4 en adelante)
      -Spring Boot (versión 3 en adelante)
      -MySQL (versión 8 en adelante)
      -IDE (IntelliJ IDEA recomendado)

## Configuración del Proyecto con Spring Initializr:

      Accede a Spring Initializr.
      Selecciona las siguientes opciones:
      -Project: Maven
      -Language: Java
      -Spring Boot: 3.0.0 (o la más reciente)
      -Packaging: Jar
      -Java: 17

## Dependencias a agregar:

      -Lombok
      -Spring Web
      -Spring Boot DevTools
      -Spring Data JPA
      -Flyway Migration
      -MySQL Driver
      -Validation
      -Spring Security

# Diagrama de Base de Datos
Diseña tu base de datos siguiendo el diagrama propuesto en el documento. Incluye las tablas necesarias para los tópicos, usuarios, etc. Utiliza herramientas como MySQL Workbench o DbDesigner para crear el modelo físico.

# Crear la Base de Datos
## Abrir MySQL Workbench:

      -Si has instalado MySQL Workbench durante la instalación de MySQL, ábrelo. Si no, puedes descargarlo e instalarlo desde MySQL Workbench.

## Conectar al Servidor MySQL:

      -Abre MySQL Workbench y crea una nueva conexión con el servidor MySQL utilizando el usuario root y la contraseña que configuraste durante la instalación.
      
## Crear la Base de Datos:

      Una vez conectado, abre una nueva pestaña de consulta SQL y ejecuta el siguiente comando para crear la base de datos:

            CREATE DATABASE foro_db;
         
## Seleccionar la Base de Datos:

      Selecciona la base de datos que acabas de crear ejecutando el siguiente comando:

            USE foro_db;
# Crear las Tablas
## Crear la Tabla de Tópicos:
      En la misma pestaña de consulta SQL, ejecuta el siguiente comando para crear la tabla topico:

               CREATE TABLE topico (
                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                   titulo VARCHAR(255) NOT NULL,
                   mensaje TEXT NOT NULL,
                   fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                   status VARCHAR(50),
                   autor VARCHAR(100),
                   curso VARCHAR(100)
               );


# Configuración del Proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/DIEGOJGS/foro_Alura.git
   cd foro_Alura
   
1. Configura la base de datos MySQL:


    Crea una base de datos llamada foro_db.
    Actualiza las credenciales de la base de datos en 
    `src/main/resources/application.properties`:

        spring.datasource.url=jdbc:mysql://localhost:3306/foro_db
        spring.datasource.username=TU_USUARIO
        spring.datasource.password=TU_CONTRASEÑA
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   
1. Ejecuta la aplicación:
   
         mvn spring-boot:run
   
1. Estructura del Proyecto:
   
             foro_Alura
          │
          ├── src
          │   ├── main
          │   │   ├── java
          │   │   │   └── com
          │   │   │       └── api
          │   │   │           └── foro_Alura
          │   │   │               ├── config
          │   │   │               │   ├── SecurityConfigurations.java
          │   │   │               │   └── SwaggerConfig.java
          │   │   │               ├── controller
          │   │   │               │   ├── RespuestaController.java
          │   │   │               │   ├── TopicoController.java
          │   │   │               │   └── UsuarioController.java
          │   │   │               ├── model
          │   │   │               │   ├── Respuesta.java
          │   │   │               │   ├── Topico.java
          │   │   │               │   └── Usuario.java
          │   │   │               ├── repository
          │   │   │               │   ├── RespuestaRepository.java
          │   │   │               │   ├── TopicoRepository.java
          │   │   │               │   └── UsuarioRepository.java
          │   │   │               └── service
          │   │   │                   └── TokenService.java
          │   │   └── resources
          │   │       ├── application.properties
          │   │       └── data.sql
          │   └── test
          │       └── java
          │           └── com
          │               └── api
          │                   └── foro_Alura
          │                       └── ForoAluraApplicationTests.java
          ├── .gitignore
          ├── mvnw
          ├── mvnw.cmd
          ├── pom.xml
          └── README.md

# Endpoints:

  ## Tópicos
   
       Crear Tópico
   
        -Método: `POST`
        -URL:` /topicos`
        -Body:
   
               {
              "titulo": "Título de prueba",
              "mensaje": "Mensaje de prueba",
              "status": "abierto",
              "autor": "Autor de prueba",
              "curso": "Curso de prueba"
            }
            
  ## Listar Tópicos

      -Método: GET
      -URL: /topicos
      -Obtener Tópico por ID
      
      -Método: GET
      -URL: /topicos/{id}
      -Actualizar Tópico
      
      -Método: PUT
      -URL: /topicos/{id}
      -Body:
                json
                {
                  "titulo": "Título actualizado",
                  "mensaje": "Mensaje actualizado",
                  "status": "cerrado",
                  "autor": "Autor actualizado",
                  "curso": "Curso actualizado"
                }
  ## Eliminar Tópico

        -Método: DELETE
        -URL: /topicos/{id}
        -Usuarios
        -Crear Usuario
        -Método: POST
        -URL: /usuarios
        -Body:
                  json

                  {
                    "nombre": "Nombre de prueba",
                    "email": "email@prueba.com"
                  }
  ## Listar Usuarios

        -Método: GET
        -URL: /usuarios
        -Obtener Usuario por ID
        
        -Método: GET
        -URL: /usuarios/{id}
        -Actualizar Usuario
        
        -Método: PUT
        -URL: /usuarios/{id}
        -Body:
                      json

                      {
                        "nombre": "Nombre actualizado",
                        "email": "email@actualizado.com"
                      }
  ## Eliminar Usuario

        -Método: DELETE
        -URL: /usuarios/{id}
        -Respuestas
        -Crear Respuesta
        
        -Método: POST
        -URL: /respuestas
        -Body:
                          json

                          {
                            "mensaje": "Mensaje de respuesta",
                            "autor": "Autor de respuesta"
                          }
  ## Listar Respuestas

        -Método: GET
        -URL: /respuestas
        -Obtener Respuesta por ID
        
        -Método: GET
        -URL: /respuestas/{id}
        -Actualizar Respuesta
        
        -Método: PUT
        -URL: /respuestas/{id}
        -Body:
                          json

                            {
                              "mensaje": "Mensaje actualizado",
                              "autor": "Autor actualizado"
                            }
  ## Eliminar Respuesta

          -Método: DELETE
          -URL: /respuestas/{id}

  # Pruebas

            Para ejecutar las pruebas unitarias, usa el siguiente comando:
  
                              bash
                              mvn test

  # Contribuciones
  
              Las contribuciones son bienvenidas. Por favor, crea un pull request para cualquier mejora o corrección.


   
