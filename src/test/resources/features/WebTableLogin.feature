@WebTable
Feature: Web table app login functionality
  Agile story: User should be able to login with correct credentials

  @WebTableLogin
  Scenario: Positive login scenario
    Given User is on the Web Table app login
    When User enters correct userName
    And User enters correct password
    And User clicks to login button
    Then User should see orders word in the URL

  @shortWebTableLogin
  Scenario: Positive login scenario
    Given User is on the Web Table app login
    When User enters "Test" username "Tester" password
    And User clicks to login button
    Then User should see orders word in the URL

  @MoreEasierWebTableLogin
  Scenario: Positive login scenario
    Given User is on the Web Table app login
    When User enters below correct credentials
      | username | Test   |
      | password | Tester |
    And User clicks to login button
    Then User should see orders word in the URL

