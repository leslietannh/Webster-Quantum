package com.quantum.steps;


import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {

    /**
     * Returns todays date in the specified format.
     * For a date in the format: Aug 03  use "MMM dd"
     * More examples in the SimpleDateFormat class
     *
     * @param DateFormat
     * @return
     */
    public static String getTimeStamp(String DateFormat) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
        return sdf.format(date);

    }

    /**
     * Returns a time stamp after the offset in days given the current format.
     * For subtracting days, enter a negative number (eg. -7)
     *
     * @param DateFormat
     * @param dayOffSet
     * @return
     */
    public static String getTimeStampWithOffset(String DateFormat, int dayOffSet) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, dayOffSet);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
        return sdf.format(date);

    }

    public static void switchToContext(RemoteWebDriver driver, String context) {
        RemoteExecuteMethod executeMethod = new RemoteExecuteMethod(driver);
        Map<String,String> params = new HashMap<String,String>();
        params.put("name", context);
        executeMethod.execute(DriverCommand.SWITCH_TO_CONTEXT, params);
    }

    public static String getCurrentContextHandle(RemoteWebDriver driver) {
        RemoteExecuteMethod executeMethod = new RemoteExecuteMethod(driver);
        String context =  (String) executeMethod.execute(DriverCommand.GET_CURRENT_CONTEXT_HANDLE, null);
        return context;
    }

    public static List<String> getContextHandles(RemoteWebDriver driver) {
        RemoteExecuteMethod executeMethod = new RemoteExecuteMethod(driver);
        List<String> contexts =  (List<String>) executeMethod.execute(DriverCommand.GET_CONTEXT_HANDLES, null);
        return contexts;
    }

}
