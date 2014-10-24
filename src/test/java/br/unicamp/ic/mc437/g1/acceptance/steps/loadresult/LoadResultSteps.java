package br.unicamp.ic.mc437.g1.acceptance.steps.loadresult;

import javax.annotation.Resource;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import br.unicamp.ic.mc437.g1.acceptance.steps.SharedSteps;
public class LoadResultSteps {
	
	private static final Logger log = LoggerFactory.getLogger(SharedSteps.class);

	@Resource(name = "firefoxDriver")
	private WebDriver driver;

    @Value("classpath:acceptance/step_files/test_result_1.xml")
    private org.springframework.core.io.Resource testResult1Resource;

    @Value("${server.endpoint}")
    private String serverEndpoint;

    @Given("upload page loaded")
    public void homePageLoaded() {
        log.debug("homePageLoaded");

        driver.navigate().to(serverEndpoint + "/new-result");
    }
	
	@Given("that the user uploaded an xml file")
	@Pending
	public void givenThatTheUserUploadedAnXmlFile(){
		 //TODO 
	}
	
	@Then("the results of that xml file will be saved on the system")
	@Pending
	public void thenTheResultsOfThatXmlFileWillBeSavedOnTheSystem(){
		 //TODO 
	}

	@Then("the system shows an error message")
	@Pending
	public void thenTheSystemShowsAnErrorMessage(){
		 //TODO 
	}
}