package com.cydeo.step_definitions;

import com.cydeo.utlities.BrowserUtils;
import com.cydeo.utlities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In this class we will be able to create "pre" and "post" condition for All the SCENARIOS and even STEPS
 */
public class Hooks {
    //import the@Before coming from io.cucumber.java

    @Before
    public void setupMethod(){
        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");
    }
    /*@Before (value = "@login", order = 2)
    public void login_scenario_before(){
        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");
    }

     */

    @After
    public void teardownMethod(Scenario scenario){


        if(scenario.isFailed()) {
           /* scenario.attach(((TakesScreenshot) Driver.getDriver())
        .getScreenshotAs(OutputType.BYTES, "image/png",scenario.getName());
            */

            //This One more cleaner and readable code
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
            System.out.println("---> @After: RUNNING AFTER EACH SCENARIO");
            BrowserUtils.sleep(2);
            Driver.closeDriver();

    }





     /*
    @BeforeStep
    public void setupStep(){
        System.out.println("---> @BeforeStep: @BeforeStep: RUNNING BEFORE EACH STEP");
    }

    @AfterStep
    public void teardownStep(){
        System.out.println("---> @BeforeStep: @AfterStep: RUNNING AFTER EACH STEP");
    }

      */

}
