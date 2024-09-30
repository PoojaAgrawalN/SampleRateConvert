# Calculate API

<p align="center">
    <img src="screenshots/foreign_exchange_main_image.png" alt="Main Information" width="800" height="450">
</p>

### 📖 Information

<ul style="list-style-type:disc">
  <li>This project demonstrates a <b>Spring Boot</b> application for managing foreign exchange operations with calculation. It allows users to convert currencies with calcualtion based on user discount.</li>
  <li>The application integrates with an external service provider for fetching exchange rates and performing currency conversion calculations.</li>
  <li>	Apply discounts as per the following rules:</li>
  <li>	If the user is an employee of the store, they get a 30% discount.</li>
  <li>	If the user is an affiliate of the store, they get a 10% discount.</li>
  <li>	If the user has been a customer for over 2 years, they get a 5% discount.</li>
  <li>	For every $100 on the bill, there is a $5 discount.</li>
  <li>	The percentage-based discounts do not apply to groceries.</li>
  <li>	A user can get only one of the percentage-based discounts on a bill.</li>
</ul>


### Explore Rest APIs

Endpoints Summary

<table style="width:100%">
  <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Description</th>
      <th>Request Body</th>
      <th>Path Variable</th>
      <th>Response</th>
  </tr>

  <tr>
      <td>POST</td>
      <td>/api/calculate</td>
      <td>Converts currency based on the provided ConvertRequest.</td>
      <td>ConvertRequest</td>
      <td>None</td>
      <td>ConvertResponse</td>
  </tr>
</table>


### Technologies

---
- Java 11
- Spring Boot 2.7
- Restful API
- Maven
- Junit5
- Mockito


```

**### Prerequisites**

#### Define Variable in .env file for http://api.currencylayer.com/

```
EXCHANGE_API_API_KEY={EXCHANGE_API_API_KEY}
``


---
### Maven Run and Postman Collection to test the API changes

To build and run the application with `Maven`, please follow the directions shown below;


$ mvn clean install
$ mvn spring-boot:run


[Uploading Exchange Calculater.postman_collection.json]
```sh
{
	"info": {
		"_postman_id": "aa7501be-1e9e-4325-9631-0a7a4f59cc17",
		"name": "Exchange Calculater",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "38679747"
	},
	"item": [
		{
			"name": "Currency Conversion",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"originalCurrency\" : \"USD\",\r\n    \"targetCurrency\" : \"EUR\",\r\n    \"totalAmount\" : 100\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:1331/api/calculate",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "1331",
					"path": [
						"api",
						"calculate"
					]
				}
			},
			"response": []
		}
	]
}
