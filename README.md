# Calculate API

<p align="center">
    <img src="screenshots/foreign_exchange_main_image.png" alt="Main Information" width="800" height="450">
</p>

### 📖 Information

<ul style="list-style-type:disc">
  <li>This project demonstrates a <b>Spring Boot</b> application for managing foreign exchange operations. It allows users to convert currencies, retrieve current exchange rates, and view conversion history.</li>
  <li>The application integrates with an external service provider for fetching exchange rates and performing currency conversion calculations.</li>
  <li>The application includes three main endpoints:
    <ul>
      <li>Exchange Rate Endpoint: Fetches the current exchange rate between two currencies.</li>
      <li>Currency Conversion Endpoint: Converts a given amount from one currency to another and returns a unique transaction identifier.</li>
      <li>Conversion History Endpoint: Retrieves the history of currency conversions based on transaction identifiers or dates.</li>
    </ul>
  </li>
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
- Java 23
- Spring Boot 3.0
- Restful API
- Maven
- Junit5
- Mockito


```


### Prerequisites

#### Define Variable in .env file for http://api.currencylayer.com/

```
EXCHANGE_API_API_KEY={EXCHANGE_API_API_KEY}
``


---
### Maven Run
To build and run the application with `Maven`, please follow the directions shown below;

```sh
$ mvn clean install
$ mvn spring-boot:run
