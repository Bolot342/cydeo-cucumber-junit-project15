@orange
Feature: Bing search functionality
  Agile story: As a user, when I am on the google search page
  I should be able to search anything and see relevant results


  Scenario: Search result title verification
    Given user is on the Bing search page
    When user enters orange in the Bing Search box
    Then user should see orange - search in the title

    Scenario: Search result title verification
      Given user is on the Bing search page
      When user enters "orange" in the Bing Search box
      Then user should "see orange - Search" in the title