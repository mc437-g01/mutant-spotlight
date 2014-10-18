package br.unicamp.ic.mc437.g1.acceptance.steps.viewresult;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.unicamp.ic.mc437.g1.acceptance.Steps;
import br.unicamp.ic.mc437.g1.acceptance.steps.SharedSteps;

/**
 * @author Carlos Gregoreki
 */
@Steps
public class ViewResultSteps {
	private static final Logger log = LoggerFactory.getLogger(SharedSteps.class);
	
	//url of the random chosen result
	private String random_result_url;
	
	
	@Resource(name = "firefoxDriver")
    private WebDriver driver;
	
	@Given("results page loaded")
    public void resultPageLoaded() {
        log.debug("resultsPageLoaded");

        driver.navigate().to("http://localhost:8080/mutant-spotlight/results");
    }
	
	@When("I click a single result to view")
    public void clickOnSingleResult() {
		//getting the table
		WebElement baseTable = driver.findElement(By.id("result_table"));
		List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
		
		//getting a random row in the table
		Random rand = new Random();
		int random_row = rand.nextInt((baseTable.getSize().height) + 1);
		String url = tableRows.get(random_row).findElement(By.xpath("/td[1]")).getAttribute("href");
		url = url.replace("http://localhost:8080/mutant-spotlight/view_result/", "");
		this.random_result_url = "http://localhost:8080/mutant-spotlight/view_result/".concat(url);
		tableRows.get(random_row).findElement(By.xpath("/td[1]")).click();		
		
    }
	
	@Then("the system redirects me to a page that shows me the informations of the chosen result")
	public void redirectsToSingleResultPage() {
		log.debug("redirectsToSingleResultPage");
        
        assertEquals("The urls are different", this.random_result_url, driver.getCurrentUrl());
    }
	
	@Given("homepage loaded")
    public void homePageLoaded() {
        driver.navigate().to("http://localhost:8080/mutant-spotlight/");
    }
	
	@When("I load a non-existent result url")
	public void loadNonExistentResultUrl(){
		driver.navigate().to("http://localhost:8080/mutant-spotlight/view_result/h40fn903_non_existent");
		
	}
	
	@Then("the system redirects me to an error page")
	public void redirectsErrorPage(){
		assertEquals("The error page was not correctly loaded", "http://localhost:8080/mutant-spotlight/view_result/view_result_error", driver.getCurrentUrl());
	}
	
	@When("When I load a protected result url")
	@Pending
	public void protectedResultUrl(){
				
	}
		
}
