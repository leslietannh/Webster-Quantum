package com.quantum.steps;


import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.utils.DeviceUtils;
import cucumber.api.java.en.Then;

import java.util.HashMap;

@QAFTestStepProvider
public class FingerprintStepDefs {

    @Then("^I enter a \"(.*?)\" fingerprint$")
    public static void enterFingerprint(String fingerprintResult) {

        PerfectoApplicationSteps.waitFor(10);

        HashMap params = new HashMap();
        params.put("identifier", "com.UBS-QA2.ClientMobile");
        params.put("resultAuth", fingerprintResult);
        DeviceUtils.getQAFDriver().executeScript("mobile:fingerprint:set", params);

        PerfectoApplicationSteps.waitFor(10);


    }

}
