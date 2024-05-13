# -------------------- Descripciòn del proyecto --------------------
Pokemon API-Rest-to-Soap protocol Development of a web service with soap protocol based on the consumption of a Pokemon Rest API to expose the main characteristics of the json as functions of the soap endpoint, filtering by pokemon name.

# -------------------- Entregable --------------------
Subir códigos fuente a un repositorio y agregar en el readme las instrucciones
para validar el desarrollo.

A) Objetivo
Crear un endpoint con JAVA (spring boot java) utilizando SOAP para consumir una
API tipo rest ej. (https://pokeapi.co/api/v2/pokemon).
El desarrollo consiste en consumir la API rest de https://pokeapi.co/ y en base a lo
que retorna crear un endpoint en SOAP con los siguientes métodos:
● abilities
● base_experience
● held_items
● id
● name
● location_area_encounters
Nota:Todos los métodos tienen que aceptar como parámetro como String al pokemon
ya que la búsqueda tiene ser en tiempo real de https://pokeapi.co/

B) Se tiene que guardar en una base de datos h2, mysql, etc. Los request de las
peticiones guardando como variables:
● ip de origin
● fecha de request
● método que se ejecuta
Nota:Se puede utilizar: mybatis, hibernate, spring jdbc, como extra se puede crear un
pool deconexiones

# -------------------- Notas de configuraciòn previo a ejecuciòn --------------------
Es proyecto implementado con maven por lo que se debe tener el gestor de dependencias.
# Se utilizaron 3 opciones de Bases de datos para cumplir el objetivo B), dichas opciones se encuentran descritas y administradas dentro del archivo "/config/application.yml" dentro de la propiedad "opcion-menu-bd":

● 1) JPA BD H2 or JPA-MYSQL
● 2) Mongo DB NoSQL

# 1) JPA BD H2 or JPA-MYSQL
● Si se elige la opciòn 1 para JPA BD H2 o JPA Mysql una de estas opciones debes asegurarte que las properties correspondientes esten descomentadas en el archivo: 
  # src/main/resources/application.properties
● Las propiedades para crear la BD Mysql son:
# User: userPokeApi
# Pwd: pwdSoap13
# BD: POKE_BD

● Las propiedades para crear la BD Mysql son:
# User: sa
# Pwd: password
# BD: pokedb

# 2) Mongo DB
● Si se elige la opciòn 2 para Mongo DB debes asegurarte que las properties correspondientes esten descomentadas en el archivo: 
  # User cluster: joparedescano
  # Pwd: ddtfFqgCN5tnfpL7
  # Cluster: pokeapicluster
# Si se desea utilizar esta opciòn de BD NoSQL se debe crear un cluster con las propiedades anteriormente mencionadas o en su defecto cambiar sus valores en las properties.

# Nota: Dejar descomentado en todo momento las properties de la opcion 2) Mongo DB, ya que no intervienen con las properties de alguna de las opciones 1) JPA BD H2 or JPA-MYSQL

# -------------------- Notas de ejecuciòn --------------------
# Compilaciòn de proyecto maven: 
● mvn compile 
# Deployment del proyecto:
● mvn spring-boot:run
# Para obtener el wsdl crear en SoapUI un proyecto Soap
● Ingresar en la propiedad "Initial WSDL": http://localhost:8080/ws/pokeapi.wsdl
● Se crearan los request requeridos para probar las operaciones expuestas del servicio soap 
# (Ejemplo)
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:pok="http://joparedescano.org/pokeapi">
   <soapenv:Header/>
   <soapenv:Body>
      <pok:getBaseExperienceRequest>
         <pok:name>pikachu</pok:name>
      </pok:getBaseExperienceRequest>
   </soapenv:Body>
</soapenv:Envelope>
● Ingresar como parametro de entrada el nombre de un pokemon:
# <pok:name>pikachu</pok:name>
