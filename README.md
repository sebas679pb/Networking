# OO Design

## Autor

Jhon Sebastian Piñeros Barrera

## Fecha

10/06/2022

## Descripcion

Este proyecto consiste en realizar el diseño y construccion de un programa que dado un archivo con un conjunto de numeros lo lea y
calcule su media y desviacion estandar.

### LOC/h

Se realizaron 167 lineas de codigo en aproximadamente 4 horas de trabajo, es decir, 41.75 lineas de codigo por hora.

### Prerrequisitos

- JAVA
- Maven
- GIT

### Diagrama de clases

[![image.png](https://i.postimg.cc/65spgmhT/image.png)](https://postimg.cc/c6mW8T2N)

### Descripcion diagrama de clases

En el diagrama de clases se puede observar que para el diseño de este proyecto se implemento en la clase Calculator los metodos:

- fileConverter: Lee un archivo y digita los numeros en una lista enlazada.
- mean: Calcula la media dada una lista de numeros.
- standardDeviation: Calcula la desviacion estandar dada una lista de numeros.

Tambien se realizo la implementacion de las clases OpLinkedList y Node las cuales son una implementacion propia de linkedList que
implementa de la interfaz List y la clase CalculatoTest encargada de la ejecucion de las pruebas unitarias a traves de Junit.

### Reporte de pruebas

```
mvn test
```

[![image.png](https://i.postimg.cc/mr9NcCjZ/image.png)](https://postimg.cc/rd8t3d77)

Se realizaron 4 test durante los cuales se comprueba la correcta ejecucion de los metodos mean y standardDeviation tomando como referencia
los datos suministrados en la guia de trabajo.

### Estructura del proyecto

```
C:.
├───main
│   └───java
│       └───edu
│           └───escuelaing
│               └───arsw
│                   └───app
│                       └───Calculator.java
│                       └───DevelopmentHours.txt
│                       └───Node.java
│                       └───OpLinkedList.java
│                       └───ProxySize.txt
└───test
    └───java
        └───edu
            └───escuelaing
                └───arsw
                    └───app
                        └───CalculatoTest.java
```

### JavaDoc

El javadoc se puede vizualizar con el comando 

```
mvn javadoc:javadoc
```

y posteriormente vamos a la carpeta de nuestro proyecto y buscamos en target/site/apidocs/index.html