Feature: User Login

  Scenario: Successful Login
    Given the user is on the democart login page
    When the user enters the valid credentials (username: "jamilalm@gmail.com" , password: "test@123")
    And the user clicks on the login button
    Then the user should be redirected to MyAccount Page
    And the user should see a welcome message
