package appHooks;

import com.qa.factory.DriverFactory;
import com.genericUtils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    private Properties prop;

    @Before(order=0)
    public void getProperties(){
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order=1)
    public void launchBrowser(){
        String browserName=prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.initialiseDriver(browserName);
    }

    @After(order=0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order=1)
    public void takeScreenshotWhenFailure(Scenario scenario){
        if(scenario.isFailed()) {
            String scenarioName = scenario.getName().replaceAll(" ", "_");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenarioName);
        }
    }
}
