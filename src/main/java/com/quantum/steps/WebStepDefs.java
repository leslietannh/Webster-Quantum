package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class WebStepDefs {

    @Given("^I am on the website \"([^\"]*)\"$")
    public void I_am_on_site(String site) throws Throwable {
        new WebDriverTestBase().getDriver().get(site);

        QAFExtendedWebElement usernameElement = new QAFExtendedWebElement("css=#username");
        usernameElement.waitForVisible(10000);
    }

    @Then("^I complete login with credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void completeLoginWeb(String username, String password) {
        PerfectoApplicationSteps.iSet(username, "field.username");
        PerfectoApplicationSteps.iSet(password, "field.password");

        PerfectoApplicationSteps.iClick("btn.submit");
    }




}
