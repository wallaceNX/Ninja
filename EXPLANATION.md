
# Implemented Solution

## Data model Diagram 

![Alt text](/Resources/dataModel.PNG?raw=true "dataModel.PNG")

## Implemented EndPoints

All endpoint are found with their respective examples in the Postman collection. [postman](/Resources/NinjaPoc.postman_collection.json)

Management the operating systems
| OS			 | Catalog Entity |	|
|--|--|--|
| GetAll	| http://localhost:8080/os 			|	GET			|	
|	saveAll	|	http://localhost:8080/oss			|	POST		|
|	save		|	http://localhost:8080/os			|	POST		|
|	Delete	|	http://localhost:8080/os/{id}	|	DELETE	|


   Management the service type
  |	Utilities	|	Catalog Entity									||
  |--|--|--|
  |	GetAll		|	http://localhost:8080/utilities		|	GET		|
  |	saveAll		|	http://localhost:8080/utilities		|	POST	|
  |	save		|	http://localhost:8080/utility		|	POST	|
  |	Delete		|	http://localhost:8080/utility/{id}	|	DELETE	|


   Management the devices with their operating systems
  |	Devices		|	Principal Entity								||
  |--|--|--|
  |	GetAll		|	http://localhost:8080/devices		|	GET		|
  |	saveAll		|	http://localhost:8080/devices		|	POST	|
  |	save		|	http://localhost:8080/device		|	POST	|
  |	Delete		|	http://localhost:8080/device/{id}	|	DELETE	|


   Management the services with their prices
  |	Services	|	Principal Entity								||
  |--|--|--|
  |	GetAll		|	http://localhost:8080/services		|	GET		|
  |	saveAll		|	http://localhost:8080/services		|	POST	|
  |	save		|	http://localhost:8080/service		|	POST	|
  |	Delete		|	http://localhost:8080/service/{id}	|	DELETE	|

   Management the devices and their associated services
  |	ServiceDevie	|	Transactional Entity							||
  |--|--|--|
  |	GetAll			|	http://localhost:8080/records		|	GET		|
  |	GetById			|	http://localhost:8080/record/{id}	|	GET		|
  |	saveAll			|	http://localhost:8080/records		|	POST	|
  |	save			|	http://localhost:8080/record		|	POST	|
  |	Delete			|	http://localhost:8080/record/{id}	|	DELETE	|

   Management the Inventory of the devices and their associated services with cost
  |	Summary			|	Inventory Operations									||
  |--|--|--|
  |	GetAll			|	http://localhost:8080/summary/device/{id}	|	GET		|
  |	GetById			|	http://localhost:8080/summary/devices		|	GET		|
  |	saveAll			|	http://localhost:8080/summary/services		|	GET		|


## Develop and Integration

   * Simple cache handling has been implemented using spring cache except in inventory operations   
   * Tests have been implemented through the postman project mentioned above.
   * Test cases have been implemented for the principal entities with JUnit.

