************************************INFO***************************************
Requerimientos: Java 8

La aplicación funciona por default en el puerto 8080 (http://localhost:8080), 
es posible cambiar esta o cualquier otra propiedad con variables de sistema.

*************************Servicios consumidos**********************************
Para ofrecer la funcionalidad de esta aplicación esta aplicación utiliza los 
servicios de:

https://ip2country.info/
Es posible modificar el endpoint de esta api modificando el valor 
“ipContextInfo.url.restIp2Country “en las variables de sistema
(esta aplicación utiliza un trustore interno para acceder a 
	los servicios de esta api )
	
http://restcountries.eu/
Es posible modificar el endpoint de esta api modificando el valor 
“ipContextInfo.url.restCountry “en las variables de sistema

http://fixer.io/ 
Es posible modificar el endpoint de esta api modificando el valor 
“ipContextInfo.url.currencyRate “en las variables de sistema 
	(* es necesario asignar el api key para el funcionamiento de 
	esta api “ipContextInfo.url.currencyRate.apiKey”)

************************* Distancia *******************************************

La aplicación tomo por default la latitud y longitud (-34.608318, -58.370288) 
para realizar los cálculos de distancia, es posible cambiar esta o cualquier 
otra propiedad con variables de sistema.

************************* Cahche **********************************************

La aplicación cuenta dos niéveles de chache:

Por default “simple” es una implementación donde la cache es manejada por 
instancia (no recomendada para ambientes productivos)

Cahe “redis” esta opción utiliza una base redis como cache pudiendo ser 
compartida por n instancias las configuraciones por default pueden ser 
modificada a través de la asignación de variables del sistema.

************************* Docker **********************************************
La aplicación cuenta con la posibilidad de ser ejecutada sobre docker 
DockerFile : 
************************* DockerFile start ************************************
FROM openjdk:8-jre
MAINTAINER David Flemström <dflemstr@spotify.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/ipContextInfo/ipContextInfo.jar"]

# Make port 8080 available to the world outside this container
EXPOSE 8080

ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/ipContextInfo/ipContextInfo.jar
************************* DockerFile end **************************************

************************* Docker comando **************************************
Ejecutar docker default:

docker run –name ipContextInfo –d ipContextInfo 

Ejecutar docker modificando alguna propiedad:

docker run –name ipContextInfo –d ipContextInfo -e " ipContextInfo.ssl.enabled=true"

docker run –name ipContextInfo –d ipContextInfo --env-file " pathTo_env.env"




************************* Variables de sistemas *******************************
#file env.env
ipContextInfo.port=8080
ipContextInfo.ssl.enabled=false
ipContextInfo.ssl.store-type=JKS
ipContextInfo.ssl.key-store=classpath=cacerts
ipContextInfo.key-store-password=changeit
ipContextInfo.key-alias=ipcontext

ipContextInfo.origin.lat=-34.608318
ipContextInfo.origin.lon=-58.370288

ipContextInfo.url.restCountry=https://restcountries.eu/rest/v2

ipContextInfo.url.currencyRate=http://data.fixer.io/api
ipContextInfo.url.currencyRate.apiKey=606b069d85d65954dad92f822baa7805

ipContextInfo.url.restIp2Country=https://api.ip2country.info}

ipContextInfo.log.level=ERROR
ipContextInfo.log.file=ipContextInfo.log

# simple | redis
ipContextInfo.cacheType:simple

ipContextInfo.redis.host=localhost
ipContextInfo.redis.port=6379
ipContextInfo.redis.password=

************************* FIN *************************************************
