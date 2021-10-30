# HelloCode Temp-Conversor #

ES:
Servicio conversor para unidades de temperatura.
EN:
Temperature conversion service.

### Details ###
ES:
Encuentras el código fuente de un servicio capaz de transformar
entre diversas unidades de temperatura. 

EN:
Service which does conversions between temperature units.

### Deployment ###

* Build/Construir: `./gradlew build`
* Execute/Ejecutar : `java -jar build/libs/temp-converter.jar`

* Using Docker Hub: 
 `docker run -p 8782:80 -d –name conversor-hellocode  hellocodeco/co.com.hellocode.services.temp-conversor:20210319012-swagger `
 Swagger: http://localhost:8782/swagger-ui.html
 Test: `curl http://localhost:8782/convert?from=C&to=F&value=32`


### Contact ###

* HelloCode SAS
* https://hellocode.com.co
* info@hellocode.com.co
