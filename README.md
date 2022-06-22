# Networking

## Autor

Jhon Sebastian Piñeros Barrera

## Fecha

21/06/2022

## Descripcion

Este proyecto consiste en realizar el diseño y construccion de servidores que escuchan un puerto y responden la solicitud del cliente, servidores web que atienden solicitudes desde el browser y un servidor capaz de responder multiples solicitudes concurrentes.

Para ejecutar el cliente concurrente usamos el comando:

```
java -cp "target\classes" co.edu.escuelaing.networking.HttpClientMulti #Numero de peticiones
```

### LOC/h

Se realizaron 450 lineas de codigo en aproximadamente 10 horas de trabajo, es decir, 45 lineas de codigo por hora.

### Prerrequisitos

- JAVA
- HTML
- Maven
- GIT
- Heroku

### Diagrama de clases

[![image.png](https://i.postimg.cc/2y20HPvk/image.png)](https://postimg.cc/SYYLR1D3)

### Descripcion diagrama de clases

En el diagrama de clases se puede observar que para el diseño de este proyecto se implementaron las clases:

- HttpServerMain: Clase encargada de implementar el servidor con el patron singleton. 
- HttpServerMulti: Servidor web que soporta multiples solicitudes seguidas (concurrentes).
- RequestProcessor: Se encarga de procesar las solicitudes del servidor.
- HttpClientMulti: Cliente que realiza multiples solicitudes seguidas (concurrentes).
- ClientRequestProcessor: Se encarga de procesar las solicitudes del cliente.

### Estructura del proyecto

```
C:.
└───src
|   └───main
|       └───java
|           └───co
|               └───edu
|                   └───escuelaing
|                       └───networking
|                           └───ClientRequestProcessor.java
|                           └───EchoClient.java
|                           └───EchoServer.java
|                           └───HttpClientMulti.java
|                           └───HttpServer.java
|                           └───HttpServerMain.java
|                           └───HttpServerMulti.java
|                           └───MathServer.java
|                           └───RequestProcessor.java
|                           └───URLExplorer.java
|                           └───URLReader.java
└───HelloWorld.js
└───img.jpg
└───index.html
└───list.html
└───notFound.html
└───text.html

```

### Heroku Link

https://htmlservermulti.herokuapp.com/

### JavaDoc

El javadoc se puede vizualizar con el comando 

```
mvn javadoc:javadoc
```

y posteriormente vamos a la carpeta de nuestro proyecto y buscamos en target/site/apidocs/index.html