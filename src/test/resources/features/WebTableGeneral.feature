@General_WebTable
Feature: Some of the general functionality verifications

  @OrderPage
  Scenario: Dropdown option verifications
    Given User is already logged in to the Web table app
    When User is on the Order page
    Then User sees below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |

  @RadioButton
  Scenario: Payment options verification
    Given User is already logged in to the Web table app
    When User is on the Order page
    Then User sees VISA as enabled payment option
    Then User sees MasterCard as enabled payment option
    Then User sees American Express as enabled payment option

  @OrderPlacementScenario
  Scenario: Order placement scenario
    Given User is already logged in to the Web table app
    When User is on the Order page
    And User enters quantity "2"
    And User clicks to calculate button
    And User enters costumer name "Jane Doe"
    And User enters street "7th Street"
    And User enters city "New York"
    And User enters state "New York"
    And User enters zip code "99999"
    And User selects payment option "American Express"
    And User enters credit card number "1111222233334444"
    And User enters expiration date "12/25"
    And User clicks to process order button
    Then User should see "Jane Doe" in the first row of the web table

  @OrderPlacementScenarioTwo
  Scenario Outline: Order placement scenario
    Given User is already logged in to the Web table app
    When User is on the Order page
    And User enters quantity "<quantity>"
    And User clicks to calculate button
    And User enters costumer name "<costumerName>"
    And User enters street "<street>"
    And User enters city "<city>"
    And User enters state "<state>"
    And User enters zip code "<zipCode>"
    And User selects payment option "<paymentType>"
    And User enters credit card number "<cardNumber>"
    And User enters expiration date "<expDate>"
    And User clicks to process order button
    Then User should see "<expectedName>" in the first row of the web table

    Examples:
      | quantity | costumerName     | street        | city        | state | zipCode | paymentType | cardNumber       | expDate | expectedName     |
      | 2        | John Doe         | 7th ST        | New York    | NY    | 99999   | Visa        | 1111222233334444 | 12/25   | John Doe         |
      | 2        | Alexandra Gray   | 7 Miller St   | Chicago     | IL    | 74853   | MasterCard  | 4444222233331111 | 11/24   | Alexandra Gray   |
      | 4        | John Doe         | 12 Cherry Ave | Arlington   | VA    | 53421   | Visa        | 2222111144443333 | 05/25   | John Doe         |
      | 2        | Stewart Dawidson | 19 Victor Ave | Cate Island | NY    | 12345   | MasterCard  | 1111333322224444 | 08/24   | Stewart Dawidson |
      | 3        | Bart Fisher      | 35 Stone St   | McLean      | VA    | 13579   | Visa        | 5555111133332222 | 02/28   | Bart Fisher      |
      | 2        | Ned Stark        | 17 Rose ST    | New Castle  | PA    | 74853   | MasterCard  | 5555111122224444 | 05/29   | Ned Stark        |
