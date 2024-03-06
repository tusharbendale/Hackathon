package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".\\FeatureFiles"},
		glue="stepDefinations",
		
		plugin= {"pretty", "html:C_reports/myreport.html", 
				  "rerun:target/rerun.txt",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class runFile {	

}
