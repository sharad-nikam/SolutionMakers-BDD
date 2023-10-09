package com.amazon.apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.amazon.driverfactory.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
	 DriverFactory driverFactory;
	 WebDriver driver;
	 public Properties prop;

	@Before(order = 0)
	public void getProperty() {
		driverFactory = new DriverFactory();
		prop = driverFactory.initProp();
	}

	@Before(order = 1)
	public void launchBrowser() {
		prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(prop);

	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}
}
