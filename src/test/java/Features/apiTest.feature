Feature: pruebas en API's

Scenario: Endpoint send response 200
  Given setting the endpoint
  When endpoint is called
  Then response code is 200

Scenario: Posting data to the API endpoint
  Given setting API endpoint
  When I send a POST request with valid data
  Then I received a successful response