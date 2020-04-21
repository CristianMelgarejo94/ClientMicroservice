# Ejercicio Práctico Java, Spring Framework, Spring Boot y microservicios
## Proposito 🚀
_Con el propósito de poner en práctica y validar los conceptos adquiridos de la capacitación Java, Spring Framework, Spring Boot y microservicios. Se propuso un problema a manera de prueba de concepto (PoC), para construir un API Restful que expongan como mínimo las operaciones CRUD de una tabla de base de datos llamada CLIENTE._

_Cada operación se encuentra especificada como un servicio Restful en el controlador del microservicio desarrollado como proyecto **Spring Boot**. La información básica del cliente se almacenará en una base de datos relacional (MySQL) y su respectiva foto en una base de datos no relacional (Mongodb) donde se identificara con el numero de documento como campo único del registro._
>Proximamente: Todos los servicios deben permitir Cross Domain o el consumo de recursos
>              desde un dominio diferente para que la aplicación web ya existente los pueda consumir

## Propiedades del proyecto ⚙️

_Dentro del proyecto se encuentra el archivo **aplication.properties**, en el se encuentran las configuraciones basicas de este mismo, si deseas puedes cambiar el puerto en el que se despliega el servidor, cambiar el nombre de la base de datos, la url de la base de datos, etc... Es importante que modifiques estos valores de acuerdo a tu entorno de trabajo, esto con el fin de que no tengas inconvenientes al momento de ejecutarlo._

## EN CONSTRUCCIÓN 🛠️
El siguiente proyecto se encuentra en proceso de construcción, pero se pueden realizar las operaciones CRUD de la tabla cliente para almacenar los siguientes datos:

```
Tipo de identificación 
Número de identificación
Nombres
Apellidos
Edad
Ciudad de nacimiento
```

## Endpoints CRUD 📌

El endpoint puede cambiar si modificas el puerto del servidor, de lo contrario sera:

```
localhost:8080/client
```

**GET** - Para obtener todos los clientes de la base de datos:
```
GET localhost:8080/client
```

**POST** - Para crear un cliente:
```
POST localhost:8080/client

Se debe de enviar en el body del request la siguiente estructura en formato JSON:

{
	"documentNumber":1234567890,
	"typeDoc":"Cedula",
	"names":"Cristian",
	"lastname":"Melgarejo",
	"age":85,
	"birthCity":"Soachington"
}

```

**PUT** - Para actualizar un cliente:
```
PUT localhost:8080/client

Se debe de enviar en el body del request la siguiente estructura en formato JSON:

{
	"documentNumber":1234567890,
	"typeDoc":"Cedula",
	"names":"Cristian",
	"lastname":"Melgarejo",
	"age":85,
	"birthCity":"Soachington"
}
```

**DELETE**:Para eliminar el registro de un cliente de la base de datos:
```
DELETE localhost:8080/client

Se enviara el tipo de documento y el numero de documento en el body del request, con el fin de ofrecer mayor seguridad,
y no exponer los datos de un cliente en la url

Se debe de enviar en el body del request la siguiente estructura en formato JSON:

{
	"documentNumber":1234567890,
	"typeDoc":"Cedula"	
}
```

## Autores ✒️

_Los siguientes son los autores de este proyecto:_

* **Cristian Melgarejo**🍺 - *Director ejecutivo de compuHiperMegaRed*


---
con ❤️ por Cristian Melgarejo 😊