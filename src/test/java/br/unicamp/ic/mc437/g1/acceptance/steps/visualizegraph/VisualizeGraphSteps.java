package br.unicamp.ic.mc437.g1.acceptance.steps.visualizegraph;

import static org.junit.Assert.assertEquals;

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

import br.unicamp.ic.mc437.g1.acceptance.Steps;
import br.unicamp.ic.mc437.g1.acceptance.story.VisualizeGraphStory;
import br.unicamp.ic.mc437.g1.acceptance.steps.viewresult.ViewResultSteps;
import br.unicamp.ic.mc437.g1.entity.TestResult;
import br.unicamp.ic.mc437.g1.model.dao.TestResultDAO;

@Steps
public class VisualizeGraphSteps {
	@Resource(name = "firefoxDriver")
    private WebDriver driver;
	
	private TestResultDAO testResultDao;
	
	private static final Logger log = LoggerFactory.getLogger(VisualizeGraphStory.class);
	
	@Then("the percentage of the graph in green for each test case will be: $rows")
	@Pending
	public void thenThePercentageOfTheGraphInGreenForEachTestCaseWillBe(List<TestCaseRow> rows) {
		// TODO
	}

	@Then("a graph of the test set score shoud be shown")
	public void thenAGraphOfTheTestSetScoreShoudBeShown() {
		// TODO
		WebElement grafico;
		try {
			//try to find the graph 
			grafico = driver.findElement(By.id("test-result-set-graph"));
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
	@Pending
	public void givenThatTheUserHasAccessToTheSystem() {
		// TODO
	}
	
	@Given("a test set has been upload")
	public void givenATestSetHasBeenUpload() {
		try {
			(new ViewResultSteps()).givenResultsInTheSystem();
		} catch(Exception E){
			E.printStackTrace();
		}
		//TODO
	}

	@Given("the uploaded file is $file")
	public void givenTheUploadedFileIsTest_result_1xml(String filename) {
		
		List<TestResult> lista = testResultDao.list();
		//get the last testResult inserted
		TestResult testResult = lista.get(lista.size() -1);
		//get its filename and compare
		assertEquals(filename, testResult.getName()); 
	}

	@Then("the graph of the Test Case will be 100% green")
	@Pending
	public void thenTheGraphOfTheTestCaseWillBe100Green() {
		// TODO
	}

	@When("the user visualizes the results report")
	@Pending
	public void whenTheUserVisualizesTheResultsReport() {
		// TODO
	}

	@When("the user visualizes the report of the uploaded file")
	@Pending
	public void whenTheUserVisualizesTheReportOfTheUploadedFile() {
		// TODO		
		
	}
}