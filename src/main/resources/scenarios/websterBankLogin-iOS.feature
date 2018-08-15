@websteriOS
Feature: Webster Bnk Mobile App

  Scenario: Verify Save Username Functionality
    Given I start application by name "Webster Bank"
    And I wait "30" seconds to see the text "Close"
    Then I click the button with text "Close"
    And I wait "20" seconds to see the text "LOG IN"
    And I click on "btn.saveuser"
    When I enter "webuser1007" to "field.username"
    And I enter "password" to "field.password"
    And I click on "btn.login"
#    And I wait "20" seconds to see the text "Verification Question"
#    And I enter "answer" to "field.verifyX"
#    And I click on "btn.enterX"
    And I wait "20" seconds to see the text "ACCOUNTS"
    And I click on "btn.auxmenu"
    And I wait "20" seconds to see the text "Log Out"
    And I click on "btn.logoutx"
    And I wait "20" seconds to see the text "Close"
    And I click on "btn.logoutx"
    And I wait "20" seconds to see the text "webu*****"
    And I close application by name "Webster Bank"