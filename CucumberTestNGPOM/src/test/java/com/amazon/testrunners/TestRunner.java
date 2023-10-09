package com.amazon.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@CucumberOptions(
		//features = {"src/test/resources/com/amazon/features/products.feature"},
		features = {"src/test/resources/com/amazon/features"},
		glue = {"com/amazon/stepdefinitions", "com/amazon/apphooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/CucumberReports/CucumberReport.html",
			"timeline:test-output-thread/"},
        monochrome = true,
        publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
