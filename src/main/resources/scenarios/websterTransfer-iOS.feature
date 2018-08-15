@websteriOSXfer
Feature: Webster Bnk Mobile App

  Scenario: Transfer Funds Scheduled
 #	Start of the Login Process
    Given I start application by name "Webster Bank"
    And I wait "30" seconds to see the text "Close"
    Then I click the button with text "Close"
    And I wait "20" seconds to see the text "LOG IN"
    And I click on "btn.saveuser"
    When I enter "webuser1007" to "field.username"
    And I enter "password" to "field.password"
    And I click on "btn.login"
# Verification Question
#    And I wait "20" seconds to see the text "Verification Question"
#    And I enter "answer" to "field.verifyX"
#    And I click on "btn.enterX"   
 # Login Ends here   
    And I wait "30" seconds to see the text "ACCOUNTS"
 # I should see Accounts if the Login Process was successful
    And I click on "btn.hmbrgmenu"
    And I wait "20" seconds to see the text "MAIN MENU"
 # Main Menu (Hamburger) and then the Transfer Funds
    And I click on "btn.xferX"
    And I wait "30" seconds for "TRANSFER FUNDS" to appear 
    And I click on "btn.xferX"
    And I wait "30" seconds for "CREATE TRANSFER" to appear
    When I click on "btn.fromAcct"
    And I wait "20" seconds to see the text "Checking9177"
    And I click on "btn.fromChk9177"
    And I wait "10" seconds to see the text "CREATE TRANSFER"
    And I click on "btn.toAcct"
    And I wait "10" seconds to see the text "Checking9160"
    And I click on "btn.toChk9160"
    And I wait "10" seconds to see the text "CREATE TRANSFER"
    And I click on "btn.dollar"
    And I wait "10" seconds to see the text "CREATE TRANSFER"
    And I click on "btn.dollarToXfer"
    And I click on "btn.xferDone"
    And I wait "10" seconds to see the text "CREATE TRANSFER"
    And I click on "btn.xferSubmit"
    And I wait "10" seconds to see the text "Amount"
    And I click on "btn.xferConfirm"
    And I wait "10" seconds to see the text "Confirmation"
    And I click on "btn.xferOK"
    And I wait "10" seconds to see the text "TRANSFER FUNDS"
    And I click on "btn.auxmenu"
    And I wait "20" seconds to see the text "Log Out"
    And I click on "btn.logoutx"
    And I wait "20" seconds to see the text "Close"
    And I click on "btn.logoutx"
    And I close application by name "Webster Bank"