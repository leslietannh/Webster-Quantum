package com.quantum.steps;


import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.utils.DeviceUtils;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@QAFTestStepProvider
public class HelperStepDefs {

    @Then("^I successfully login to the app with username \"(.*?)\" and password \"(.*?)\"$")
    public static void successfulLogin(String username, String password) {

        PerfectoApplicationSteps.waitFor(3);

        //accept the camera access permissions if present
        acceptPermissionsIfVisible("Would Like to Access the Camera", "OK");
        PerfectoApplicationSteps.waitSeeToSeeText(30, "Enter");

        //enter username, password, and click login
        iEnter(username, "Enter User Name");
        iEnter(password, "Enter Password");
        PerfectoApplicationSteps.switchNativeContext();
        PerfectoApplicationSteps.iClick("btn.login");
        //clickButtonText("Login");


        //click to move to next tutorial screen
        PerfectoApplicationSteps.waitSeeToSeeText(20, "Welcome");
        PerfectoApplicationSteps.iClick("btn.tutorialright");

        //click to move to next tutorial screen
        PerfectoApplicationSteps.waitSeeToSeeText(20, "Account Balances");
        PerfectoApplicationSteps.iClick("btn.tutorialright");

        //click get started to finish welcome tutorial
        PerfectoApplicationSteps.waitSeeToSeeText(20, "Cash Management");
        PerfectoApplicationSteps.iClick("btn.getstarted");

        //assert that login was successful
        PerfectoApplicationSteps.waitSeeToSeeText(20, "My Accounts");
        PerfectoApplicationSteps.asserVisualText("Credit Line");
    }

    @Then("^I am on the login screen$")
    public static void onLoginScreen() {
        PerfectoApplicationSteps.waitFor(10);

        acceptPermissionsIfVisible("Would Like to Access the Camera", "OK");
        PerfectoApplicationSteps.asserVisualText("Login");
    }

    @Then("^I logout of the application$")
    public static void logoutOfApp() {
        PerfectoApplicationSteps.switchWebviewContext();
        PerfectoApplicationSteps.waitSeeToSeeText(20, "Menu");
        PerfectoApplicationSteps.iClick("btn.menu");

        PerfectoApplicationSteps.waitSeeToSeeText(20, "Log Out");
        PerfectoApplicationSteps.switchNativeContext();
        PerfectoApplicationSteps.iClick("btn.logout");
        acceptPermissionsIfVisible("Are you sure you want to log out", "Yes");
    }

    @Then("^I should be logged into the app$")
    public static void loggedIntoApp() {
        PerfectoApplicationSteps.waitSeeToSeeText(20, "My Accounts");
        PerfectoApplicationSteps.asserVisualText("Credit Line");
    }



    @Then("^I wait and if the permissions popup with text \"(.*?)\" is present, I press button with text \"(.*?)\"$")
    public static void acceptPermissionsIfVisible(String popupText, String buttonText) {
        HashMap params = new HashMap();
        params.put("content", popupText);
        params.put("timeout", "20");
        Object obj = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params);

        if (obj.toString().contains("true")) {
            PerfectoApplicationSteps.iClick(buttonText);
            PerfectoApplicationSteps.waitFor(10);
        } else {
            System.out.println("Nothing to do here. Permissions popup not present. Moving to next step");
        }
    }

    @Then("^If the permissions popup with text \"(.*?)\" is present, I press button with text \"(.*?)\"$")
    public static void acceptPermissionsIfVisible2(String popupText, String buttonText) {
        HashMap params = new HashMap();
        params.put("content", popupText);
        params.put("index", "2");
        params.put("timeout", "30");
        Object obj = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params);

        if (obj.toString().contains("true")) {
            clickButtonText(buttonText);
            PerfectoApplicationSteps.waitFor(10);
        } else {
            System.out.println("Nothing to do here. Permissions popup not present. Moving to next step");
        }
    }

    @Then("^I make sure the device is prompting for Touch ID$")
    public static void isTouchIdPresented() {
        HashMap params = new HashMap();
        params.put("content", "UBS QA2");
        params.put("timeout", "20");
        Object obj = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params);

        if (obj.toString().contains("true")) {
            System.out.println("Touch ID box is presented");
        } else {
            PerfectoApplicationSteps.iClick("btn.touchidlogin");
        }
    }

    @Then("^I make sure I am on the website with text \"(.*?)\"$")
    public static void validateCurrentWebsite(String partialURL) {
        //assert that the current URL matches the expected URL
        Assert.assertTrue(DeviceUtils.getQAFDriver().getCurrentUrl().contains(partialURL));
    }

    @Then("^I must see the native email screen$")
    public static void validateEmailScreen() {
        PerfectoApplicationSteps.waitFor(3);
        if (DeviceUtils.getQAFDriver().getCapabilities().getCapability("platformName").toString().equals("android")) {
            PerfectoApplicationSteps.asserVisualText("Compose");
            System.out.println("Android native email screen displayed");
        } else {
            PerfectoApplicationSteps.asserVisualText("New Message");
            System.out.println("iPhone native email screen displayed");
        }
    }

    @Then("^I select an account$")
    public static void selectFirstAccount() {
        PerfectoApplicationSteps.waitFor(5);
        List<WebElement> accountList = DeviceUtils.getQAFDriver().findElementsByXPath("//*[contains(text(),'Available to Withdraw')]");
        accountList.get(0).click();
        PerfectoApplicationSteps.waitFor(7);
    }

    @Then("^I complete the transfer form$")
    public static void completeTransferForm() {
        clickButtonText("Transaction Type");
        PerfectoApplicationSteps.waitFor(3);
        PerfectoApplicationSteps.waitSeeToSeeText(20, "Transfer Funds");
        clickButtonText("Transfer Funds");

        PerfectoApplicationSteps.waitFor(3);
        PerfectoApplicationSteps.waitSeeToSeeText(20, "New Transfer");
        clickButtonText2("Account");
        PerfectoApplicationSteps.waitFor(3);
        PerfectoApplicationSteps.waitSeeToSeeText(20, "UBS Accounts");
        PerfectoApplicationSteps.waitFor(3);
        clickButtonText("Available to Withdraw");

        PerfectoApplicationSteps.waitSeeToSeeText(20, "New Transfer");
        clickButtonText("Frequency");
        PerfectoApplicationSteps.waitFor(3);
        PerfectoApplicationSteps.waitSeeToSeeText(20, "Select Frequency");
        clickButtonText("Weekly");

        PerfectoApplicationSteps.waitFor(3);
        PerfectoApplicationSteps.waitSeeToSeeText(20, "New Transfer");
        clickButtonText("Amount");
        PerfectoApplicationSteps.iSet("100", "field.amount");

        clickButtonText("Start Date");
        PerfectoApplicationSteps.waitFor(3);
        clickButtonText("Start Date");
        PerfectoApplicationSteps.waitFor(3);
        PerfectoApplicationSteps.waitSeeToSeeText(20, "Select Start Date");
        clickButtonText("Continue");

        PerfectoApplicationSteps.waitFor(3);
        PerfectoApplicationSteps.waitSeeToSeeText(20, "New Transfer");
        clickButtonText("End Date");
        PerfectoApplicationSteps.waitFor(3);
        PerfectoApplicationSteps.waitSeeToSeeText(20, "Select End Date");
        clickButtonText("Continue");

        PerfectoApplicationSteps.waitFor(3);
        PerfectoApplicationSteps.waitSeeToSeeText(20, "New Transfer");

    }

    @Then("^I enter text \"(.*?)\" into field with text \"(.*?)\"$")
    public static void iEnter(String setText, String fieldText) {
        Map<String, Object> params1 = new HashMap<>();
        params1.put("label", fieldText);
        params1.put("text", setText);
        params1.put("timeout", "20");
        DeviceUtils.getQAFDriver().executeScript("mobile:edit-text:set", params1);
    }


    @Then("^I click the button with text \"(.*?)\"$")
    public static void clickButtonText(String text) {
        Map<String, Object> params1 = new HashMap<>();
        params1.put("label", text);
        params1.put("timeout","20");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params1);
    }

    @Then("^I click the second button with text \"(.*?)\"$")
    public static void clickButtonText2(String text) {
        Map<String, Object> params1 = new HashMap<>();
        params1.put("label", text);
        params1.put("timeout","20");
        params1.put("index", "2");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params1);
    }

    @Then("^I start capturing the Har file$")
    public void getHarFile() {
        Map<String, Object> params = new HashMap<>();
        params.put("generateHarFile", "true");
        DeviceUtils.getQAFDriver().executeScript("mobile:vnetwork:start", params);
    }

    @Then("^I end capturing the Har file$")
    public static void finishHarFile() {
        Map<String, Object> params = new HashMap<>();
        params.put("pcapFile", "true");
        DeviceUtils.getQAFDriver().executeScript("mobile:vnetwork:stop", params);
    }

    @Then("^I scroll down more$")
    public void scrollDownMore() {
        DeviceUtils.swipe("50%,70%", "50%,30%");
    }



}
