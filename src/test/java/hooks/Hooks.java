package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

public class Hooks {
    public static RequestSpecification spec;

    @Before(value = "@ApiRegistrant")
    public void setup() {
        spec = new RequestSpecBuilder().
                setBaseUri(ConfigReader.getProperty("base_url")).
                build();
    }

    @AfterStep
    public void tearDown(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshots");

       // Driver.closeDriver();
    }
}
