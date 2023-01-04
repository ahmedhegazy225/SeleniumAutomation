@smoke
  Feature: Search | users could using product name and sku
    Scenario Outline: user could search using product name
      When  Write product "<name>"
      And press search button
      Then  search results contains "<name>"

      Examples:
        | name |
        | book |
        | laptop|
        | nike |

    Scenario Outline: user could search using Sku
      Given  Write product "<name>" using Sku
      And   press search button after search
      Then  search results contains "<name>" using Sku

      Examples:
        | name |
        | SCI_FAITH |
        | APPLE_CAM|
        | SF_PRO_11 |