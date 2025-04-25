package com.cydeo.utlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private Driver() {
    }
    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver>driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){

        if(driverPool.get() == null){

            String browserType = ConfigurationReader.getProperty("browser");

            switch(browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }

        return driverPool.get();
    }

    public static void closeDriver() {
        if(driverPool.get() != null){

            //this line will terminate the currently working existing driver completely. It won't exist going forward

            driverPool.get().quit();
            //We assign the value back to "null" so that my "singleton" can create a newer if needed
            driverPool.remove();
        }

    }
}

