@webster
Feature: Webster Bnk Mobile App

  Scenario: Verify Save Username Functionality
    Given I start application by name "Webster"
    And I wait "30" seconds to see the text "CLOSE"
    Then I click the button with text "CLOSE"
    And I wait "20" seconds to see the text "LOG IN"
    And I click on "btn.save"
    When I enter "webuser1007" to "field.username"
    And I enter "password" to "field.password"
    And I click on "btn.submit"
    And I wait "20" seconds to see the text "Verification"
    And I enter "answer" to "field.verify"
    And I click on "btn.confirm1"
    And I wait "20" seconds to see the text "ACCOUNTS"
    And I click on "btn.auxmenu"
    And I wait "20" seconds to see the text "MENU"
    And I click the button with text "Log Out"
    And I wait "20" seconds to see the text "Confirm"
    And I click on "btn.confirm1"
    And I wait "20" seconds to see the text "webu*****"
    And I close application by name "Webster"