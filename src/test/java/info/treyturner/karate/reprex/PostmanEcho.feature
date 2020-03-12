Feature: Call Postman's echo service

  Background:
    * url 'https://postman-echo.com'

  Scenario: Simple GET request

    Given path 'get'
    When method GET
    Then status 200
