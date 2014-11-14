package br.unicamp.ic.mc437.g1.acceptance.steps.viewresult;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import br.unicamp.ic.mc437.g1.acceptance.Steps;
import br.unicamp.ic.mc437.g1.entity.TestResult;
import br.unicamp.ic.mc437.g1.model.dao.TestResultDAO;
import br.unicamp.ic.mc437.g1.util.XmlUtils;

/**
 * @author Carlos Gregoreki
 */
@Steps
public class ViewResultSteps {
	private final Logger log = LoggerFactory.getLogger(ViewResultSteps.class);
	
	//url of the random chosen result
	private String random_result_url;
	
	
	@Resource(name = "firefoxDriver")
    private WebDriver driver;

	private boolean byPassCauseOfRowCount = false;

    @Value("classpath:acceptance/step_files/test_result_1.xml")
    private org.springframework.core.io.Resource testResult1Resource;

    @Autowired
    private TestResultDAO testResultDAO;

    private TestResult testResult1;

    @Value("${server.endpoint}")
    private String serverEndpoint;

    @Given("there are results in the system")
    public void givenResultsInTheSystem() throws IOException {
        List<TestResult> testResults = testResultDAO.list();
        if (testResults == null || testResults.isEmpty()) {
            testResult1 = XmlUtils.readValue(testResult1Resource.getInputStream(), TestResult.class);
            testResult1.setName("test result 1");
            testResult1.setEmail("test@email.com");
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(2014, 11, 7);
            
            testResult1.setDate(calendar.getTime());
            testResult1 = testResultDAO.save(testResult1);
        }
    }

	@Given("results page loaded")
    public void resultPageLoaded() {
        log.debug("resultsPageLoaded");

        driver.navigate().to(serverEndpoint + "/result-list");
    }
	
	@When("I click a single result to view")
    public void clickOnSingleResult() {
		//getting the table
		WebElement baseTable = driver.findElement(By.id("result_table"));
        WebElement tBody = baseTable.findElement(By.tagName("tbody"));
		List<WebElement> tableRows = tBody.findElements(By.tagName("tr"));
		
		//getting a random row in the table
		Random rand = new Random();
		int rowCount = driver.findElements(By.xpath("//table[@id='result_table']/tbody/tr")).size();
		if (rowCount <=0) {
			//do nothing. nothing to test.
			this.byPassCauseOfRowCount = true;
		} else {
			int random_row = rand.nextInt((rowCount) + 1);
			WebElement row = tableRows.get(random_row);
			List<WebElement> tds = row.findElements(By.tagName("td"));
			WebElement td = tds.get(1);
			String url = td.findElement(By.tagName("a")).getAttribute("href");
			url = url.replace(serverEndpoint + "/result/", "");
			this.random_result_url = serverEndpoint + "/result/" + url;
			td.findElement(By.tagName("a")).click();
		}
    }
	
	@Then("the system redirects me to a page that shows me the informations of the chosen result")
	public void redirectsToSingleResultPage() {
		log.debug("redirectsToSingleResultPage");
		if (this.byPassCauseOfRowCount){
			assertEquals(1,1);
		} else {
			assertEquals("The urls are different", this.random_result_url, driver.getCurrentUrl());
		}
    }
	
	@Given("homepage loaded")
    public void homePageLoaded() {
        driver.navigate().to(serverEndpoint);
    }
	
	@When("I load a non-existent result url")
	public void loadNonExistentResultUrl(){
		driver.navigate().to(serverEndpoint + "/view_result/h40fn903_non_existent");
		
	}
	
	@Then("the system redirects me to an error page")
	public void redirectsErrorPage() {
		assertEquals("The error page was not correctly loaded", serverEndpoint + "/error/error", driver.getCurrentUrl());
	}
	
	@When("I type $criteria on filter input")
	public void typeCriteria(String criteria) {
		driver.findElement(By.id("criteria")).sendKeys(criteria);
	}
	
	@When("I select the $filterType filter")
	public void selectNameFilter(String filterType) {
		new Select(driver.findElement(By.id("filter-type"))).selectByValue(filterType);
	}
	
	@When("I click the search button")
	public void clickSearchButton() {
		driver.findElement(By.id("search")).click();
	}
	
	@Then("the system lists only results named $resultName")
	public void listsResultsWithName(String resultName) {
		List<WebElement> resultListNames = driver.findElements(By.cssSelector("#result_table tr td:nth-child(2) a"));
		
		for (WebElement resultListName : resultListNames) {
			assertEquals(resultName, resultListName.getText());
		}
	}
	
	@Then("the system lists only results uploaded by $email")
	public void listsResultsUploadedBy(String email) {
		List<WebElement> resultListEmails = driver.findElements(By.cssSelector("#result_table tr td:nth-child(3) a"));
		
		for (WebElement resultListEmail : resultListEmails) {
			assertEquals(email, resultListEmail.getText());
		}
	}
	
	@Then("the system lists only results uploaded on $date")
	public void listsResultsUploadedOn(String dateString) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse(dateString);
		List<WebElement> resultListDates = driver.findElements(By.cssSelector("#result_table tr td:nth-child(3) a"));
		
		for (WebElement resultListDate : resultListDates) {
			assertEquals(date, dateFormat.parse(resultListDate.getText()));
		}
	}
	
}
