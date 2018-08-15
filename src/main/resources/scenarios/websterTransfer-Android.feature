@websterXfer
Feature: Webster Bnk Mobile App

  Scenario: Transfer Funds Scheduled
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
    And I wait "20" seconds for "btn.hamburmenu" to appear
    And I click on "btn.hamburmenu"
    And I wait "20" seconds to see the text "MAIN MENU"
    And I click on "btn.xfer"
    And I wait "20" seconds to see the text "TRANSFER FUNDS"
    And I click on "btn.movefunds"
    And I wait "20" seconds to see the text "CREATE TRANSFER"
    And I enter "1" to "field.currency"
    And I click on "btn.xferdate"
    And I wait "20" seconds to see the text "August"
    And I click on "btn.xferaugust"
    And I click on "btn.xferOK"
    And I wait "20" seconds to see the text "Submit"
    And I click on "btn.xferSubmit"
    And I wait "20" seconds to see the text "SUBMIT TRANSFER"
    And I click on "btn.xferConfirm"
    And I wait "30" seconds for "btn.confirm1" to appear
    And I click on "btn.confirm1"
    And I wait "20" seconds for "btn.auxmenu" to appear 
    And I click on "btn.auxmenu"
    And I click the button with text "Log Out"
    And I wait "20" seconds to see the text "Confirm"
    And I click on "btn.confirm1"
    And I wait "20" seconds to see the text "webu*****"
    
    
    