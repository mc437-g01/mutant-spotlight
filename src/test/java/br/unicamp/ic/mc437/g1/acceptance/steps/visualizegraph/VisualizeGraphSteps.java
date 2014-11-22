package br.unicamp.ic.mc437.g1.acceptance.steps.visualizegraph;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

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
import org.springframework.beans.factory.annotation.Value;

import br.unicamp.ic.mc437.g1.acceptance.Steps;
import br.unicamp.ic.mc437.g1.acceptance.story.VisualizeGraphStory;
import br.unicamp.ic.mc437.g1.acceptance.steps.viewresult.ViewResultSteps;
import br.unicamp.ic.mc437.g1.entity.TestResult;
import br.unicamp.ic.mc437.g1.model.dao.TestResultDAO;
import br.unicamp.ic.mc437.g1.util.XmlUtils;

@Steps
public class VisualizeGraphSteps {
	@Resource(name = "firefoxDriver")
    private WebDriver driver;
	
	private TestResultDAO testResultDao;
	
	private final Logger log = LoggerFactory.getLogger(VisualizeGraphStory.class);
	
	@Value("${server.endpoint}")
	private String serverEndpoint;
	
	@Value("classpath:acceptance/step_files/test_result_1.xml")
    private org.springframework.core.io.Resource testResult1Resource;
	
	@Then("the percentage of the graph in green for each test case will be: $rows")
	public void thenThePercentageOfTheGraphInGreenForEachTestCaseWillBe(List<TestCaseRow> rows) {
		System.out.println(driver.findElement(By.id("test_set_score1")).getAttribute("score").toString() + " " + rows.get(0).getPercentage().toString() );
		System.out.println(driver.findElement(By.id("test_set_score2")).getAttribute("score").toString() + " " + rows.get(1).getPercentage().toString() );
		assertEquals(driver.findElement(By.id("test_set_score1")).getAttribute("score").toString(), rows.get(0).getPercentage().toString());
		assertEquals(driver.findElement(By.id("test_set_score2")).getAttribute("score").toString(), rows.get(1).getPercentage().toString());
	}

	@Then("a graph of the test set score shoud be shown")
	public void thenAGraphOfTheTestSetScoreShoudBeShown() {
		// TODO
		WebElement grafico;
		try {
			//try to find the graph 
			grafico = driver.findElement(By.id("graph-score-final"));
			//everything was fine. it found the graph. 
			//trivial assertEquals.
			assertEquals(1,1);
		} catch(Exception E) {
			//nope. it didn't find a graph.
			grafico = null;
			//trivial false assertEquals.
			assertEquals(1,0);
		}
			
	}

	@Given("that the user has access to the system")
	//@Pending
	public void givenThatTheUserHasAccessToTheSystem() {
		// TODO
	}
	
	private TestResultDAO testResultDAO;

    private TestResult testResult1;
    private TestResult testResult2;
    private TestResult testResult3;
    
    @Value("classpath:acceptance/step_files/cruise_result.toxml")
    private org.springframework.core.io.Resource cruiseResultResource;
    
    @Value("classpath:acceptance/step_files/cashier_result.toxml")
    private org.springframework.core.io.Resource cachierResultResource;

	
	@Given("a test set has been upload")
	public void givenATestSetHasBeenUpload() {
		try {
			List<TestResult> testResults = testResultDAO.list();
			if (testResults == null || testResults.isEmpty()) {

				// Primeiro teste
				testResult1 = XmlUtils.readValue(
						testResult1Resource.getInputStream(), TestResult.class);
				testResult1.setName("test result 1");
				testResult1.setEmail("test@email.com");
				Calendar calendar = Calendar.getInstance();
				calendar.clear();
				calendar.set(2014, 11, 7);

				testResult1.setDate(calendar.getTime());
				testResult1 = testResultDAO.save(testResult1);

				// Teste 2 - cruise_result.toxml
				testResult2 = XmlUtils
						.readValue(cruiseResultResource.getInputStream(),
								TestResult.class);
				testResult2.setName("cruise result");
				testResult2.setEmail("test@email.com");
				Calendar calendar2 = Calendar.getInstance();
				calendar2.clear();
				calendar2.set(2014, 11, 14);

				testResult2.setDate(calendar2.getTime());
				testResult2 = testResultDAO.save(testResult2);

				// Teste 3 - cachier_result.toxml
				testResult3 = XmlUtils.readValue(
						cachierResultResource.getInputStream(),
						TestResult.class);
				testResult3.setName("cashier result");
				testResult3.setEmail("sender@email.com");
				Calendar calendar3 = Calendar.getInstance();
				calendar3.clear();
				calendar3.set(2014, 11, 14);

				testResult3.setDate(calendar3.getTime());
				testResult3 = testResultDAO.save(testResult3);
			}
			    
		} catch(Exception E){
			E.printStackTrace();
		}
		//TODO
	}

	@Given("the uploaded file is $file")
	public void givenTheUploadedFileIsTest_result_1xml(String filename) throws IOException {
		driver.navigate().to(serverEndpoint + "/new-result");
		driver.findElement(By.id("email-address")).clear();
        driver.findElement(By.id("email-address")).sendKeys("teste@teste.com");
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(filename);
        driver.findElement(By.id("upload-file")).sendKeys(testResult1Resource.getFile().getAbsolutePath());
        driver.findElement(By.id("upload")).submit();
        
		List<TestResult> lista = testResultDao.list();
		//get the last testResult inserted
		TestResult testResult = lista.get(lista.size() -1);
		//get its filename and compare
		assertEquals(filename, testResult.getName()); 
	}

	@Then("the graph of the Test Case will be 100% green")
	public void thenTheGraphOfTheTestCaseWillBe100Green() {
		//get the element that has the score information
		WebElement score_hidden = driver.findElement(By.id("test_result_score"));
		//get the info of score and compares
		assertEquals(score_hidden.getText(), "100%"); 
	}

	@When("the user visualizes the results report")
	public void whenTheUserVisualizesTheResultsReport() {
		driver.navigate().to("http://localhost:8080/mutant-spotlight/result-list");
		//get a table
		WebElement baseTable = driver.findElement(By.id("result_table"));
        WebElement tBody = baseTable.findElement(By.tagName("tbody"));
		List<WebElement> tableRows = tBody.findElements(By.tagName("tr"));
		
		//count the number of rows in the table
		int rowCount = driver.findElements(By.xpath("//table[@id='result_table']/tbody/tr")).size();
		
		//click on the last item on the table
		WebElement row = tableRows.get(rowCount -1);
		List<WebElement> tds = row.findElements(By.tagName("td"));
		WebElement td = tds.get(1);
		td.findElement(By.tagName("a")).click();

	}

	@When("the user visualizes the report of the uploaded file")
	//@Pending
	public void whenTheUserVisualizesTheReportOfTheUploadedFile() {
		// TODO		
		
	}
}