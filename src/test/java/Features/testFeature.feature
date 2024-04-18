Feature: Pruebas para la aplicacion WEB retrievist.akc.org

  Scenario: Login success
    Given Open web application
    When User enter valid Username and Password
    Then Navigates on landing page


  Scenario Outline: Search bar display search results
    Given Open web application
    When search by <item>
    Then Verify that search result is displayed with <item>

    Examples:
      | item    |
      | toys    |
      | collars |
      | Bed     |
      | Leashes |
      | treats  |