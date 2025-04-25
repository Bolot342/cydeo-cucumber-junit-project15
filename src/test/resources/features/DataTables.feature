@list
Feature: Cucumber Data Tables implementation practices

  @listOfFruits
  Scenario: List of fruits and vegetables I like
    Given User should see below list
      | Orange     |
      | Apple      |
      | Kiwi       |
      | Strawberry |
      | Tomato     |
      | Pear       |
      | Eggplant   |
  #Create a new scenario where we list the type of pets we love
  #Print out all the strings in the list
  @listOfPets
  Scenario: List of pet types i Love
    Then I will share my favorites
      | Kan-gal          |
      | Husky            |
      | Golden Retriever |
      | Golden Doodle    |
      | Munchkin         |
      | Rag doll cat     |
      | Siberian cat     |

  Scenario: Officer reads data about driver
    Then officer is able to see any data he wants
      | name    | Jane          |
      | surName | Doe           |
      | age     | 29            |
      | address | somewhere     |
      | state   | CA            |
      | zipCode | 99999         |
      | phone   | 111-1111-1111 |




