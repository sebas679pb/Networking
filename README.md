# Networking

## Autor

Jhon Sebastian Piñeros Barrera

## Fecha

15/06/2022

## Descripcion

Este proyecto consiste en realizar el diseño y construccion de servidores que escuchan un puerto y responden la solicitud del cliente y servidores web que atienden solicitudes desde el browser.

### LOC/h

Se realizaron 364 lineas de codigo en aproximadamente 6 horas de trabajo, es decir, 60.6 lineas de codigo por hora.

### Prerrequisitos

- JAVA
- HTML
- Maven
- GIT

### Diagrama de clases

[![image.png](https://i.postimg.cc/TwwqB9r4/image.png)](https://postimg.cc/hJkddVZL)

### Descripcion diagrama de clases

En el diagrama de clases se puede observar que para el diseño de este proyecto se implementaron las clases:

- URLReader: Lee los valores de un objeto URL.
- URLExplorer: Lee datos de internet.
- EchoServer: Servidor que escucha un puerto y responde a las solicitudes del cliente.
- EchoClient: Aplicativo que envia mensajes al servidor.
- MathServer: Servidor que escucha un puerto y responder ejecutando operaciones de sen, cos y Tan sobre el valor requerido por el cliente.
- HttpServer: Servidor web que atiende una solicitud del browser.
- HttpServerMulti: Servidor web que soporta multiples solicitudes seguidas del browser.

### Reporte de pruebas

MathServer

[![image.png](https://i.postimg.cc/GmYnWPcz/image.png)](https://postimg.cc/yDVG9Z3S)

HttpServer

[![image.png](https://i.postimg.cc/nLDKYzGX/image.png)](https://postimg.cc/jWRJRR9T)

[![image.png](https://i.postimg.cc/tCNMWrCK/image.png)](https://postimg.cc/6yTcNfZc)

HttpServerMulti

[![image.png](https://i.postimg.cc/9XnMVphj/image.png)](https://postimg.cc/vD5Mt5TP)

[![image.png](https://i.postimg.cc/xdLYzwqK/image.png)](https://postimg.cc/jWqGVkH5)

[![image.png](https://i.postimg.cc/c12sPLRx/image.png)](https://postimg.cc/G9PwyrgV)

[![image.png](https://i.postimg.cc/Jz145d3Z/image.png)](https://postimg.cc/Tp46R043)

[![image.png](https://i.postimg.cc/5NfMhQHM/image.png)](https://postimg.cc/kDYZ84Fj)

[![image.png](https://i.postimg.cc/Fs6Dj2Xn/image.png)](https://postimg.cc/7fg34t6g)

[![image.png](https://i.postimg.cc/D0XR9ss1/image.png)](https://postimg.cc/Pvd6ZCSq)

### Estructura del proyecto

```
C:.
└───src
    └───main
        └───java
            └───co
                └───edu
                    └───escuelaing
                        └───networking
                            └───EchoClient.java
                            └───EchoServer.java
                            └───HttpServer.java
                            └───HttpServerMulti.java
                            └───MathServer.java
                            └───URLExplorer.java
                            └───URLReader.java
                            └───webapp
                                └───HelloWorld.js
                                └───img.jpg
                                └───index.html
                                └───list.html
                                └───notFound.html
                                └───text.html
                                
```

### JavaDoc

El javadoc se puede vizualizar con el comando 

```
mvn javadoc:javadoc
```

y posteriormente vamos a la carpeta de nuestro proyecto y buscamos en target/site/apidocs/index.html