
ENTORNO DESARROLLO

-Por estar en mi casa y disponer solo de MAC y no querer hacer una maquina virtual se ha desarrollado en:
	
	SO MacOS Mojave 10.14.4
	IDE STS 3.9.12 
	Se ha utlizado Spring Boot, Junit4 y H2
	



BASE DE DATOS

-La base de datos es autocontenida y es H2 los parametros de conexion son 

	http:localhost:8080/h2-console 
	jdbc:h2:mem:test
	(no tiene clave)
-Se han generado varios registros:

	2 en el pasado 
	
	ES0000000000000000000000 con amount=1000 y fee=100
	ES0000000000000000000001 con amount=2000 y fee=100
	
	2 en el presente (los registros se crean automaticamente con la fecha del dia en curso)
	
	ES0000000000000000000000 con amount=1000 y fee=100
	ES0000000000000000000001 con amount=2000 y fee=100
	
	
	2 en el futuro
	
	ES0000000000000000000000 con amount=1000 y fee=100
	ES0000000000000000000001 con amount=2000 y fee=100

-En todo el desarrollo se ha primado por la sencillez y legibilidad
-Se han ralizado todas las llamadas con el metodo GET no teniendo en cuenta el standar PUT,POST,DELETE ETC
-Para solvertar el Cors se ha definido un filtro en la configuración que reescribe la cabecera.
-No se ha hecho factorias para todas las entidades solo se ha realizado para Transaction.
-Se ha realizado un control generico de las Excepciones no dejando ninguna sin tratar aunque sin ir al detalle.
-Se han incluido constantes en una clase, se deberian de meter en BD o reescribiendo @Value para que las cogiera primero de BD y si no de propiedades
-Se han realizado interfaces a modo de ejemplo para cumplir con los principios SOLID
-Tambien para cumplir los principios SOLID se ha realizado herencia de la clase GeneralResult
-Se han incluido las restrinciones en BD y se han controlado por codigo para que los mensajes sean mas amigables.
-No se han realizado validaciones ni mapper Json, por no tener front y no existir contrato supongo que todo llega perfectamente en cuanto a formatos
-Los Test se han puesto a modo de ejemplo ya que podrian hacerse muchos e invertir mucho tiempo. No se han mokeado por tener el juego de datos embebido
-Dejo el fichero de la collecion con las llamadas por si se quieren hacer test desde SoapUI o Postman (Personal.postman.collection.json)

	
Status
	
	-Al devolver el estatus para diferenciar cuando se devuelve el amount o cuando se devuelve ammount-fee he puesto en la response "subtract" en lugar de ammount
	-El tratamieno de la fecha para evitar los segundo se ha realizado con string cuando es el caso TODAY las gestion de fechas por influir base de datos y entorno no lo he complicado mas
	-Las reglas las he metido directamente con objetos manualmente, lo ideal seria meterlos en BD, ficheros de propiedades o utilizar un motor de reglas standar
	-He asumido que si consulta el estatus y no esta conteplada la regla devuelvo un mensaje informando.
	Para realizar pruebas de estatus se puede utilizar la siguiente llamada
	-Asumo que como el canal es opcional y no se comprueba, da un error, se informa del mismo.
	
	
	Para el pasado:
	
	{
    "reference": "00000A",
    "channel": "CLIENT"
    }
    
    Para el futuro
    
    {
    "reference": "00000B",
    "channel": "CLIENT"
	}
	
	   
    Para Hoy
    
    {
    "reference": "00000C",
    "channel": "CLIENT"
	}
	
	
Cambiando los canales en cada una de las llamadas. 
	
	