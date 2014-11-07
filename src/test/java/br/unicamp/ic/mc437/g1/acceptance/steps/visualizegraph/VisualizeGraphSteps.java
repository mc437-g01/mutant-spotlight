package br.unicamp.ic.mc437.g1.acceptance.steps.visualizegraph;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.unicamp.ic.mc437.g1.acceptance.Steps;
import br.unicamp.ic.mc437.g1.acceptance.steps.clickupload.ClickUploadButtonSteps;
import br.unicamp.ic.mc437.g1.acceptance.story.VisualizeGraphStory;

@Steps
public class VisualizeGraphSteps {
	@Resource(name = "firefoxDriver")
    private WebDriver driver;
	
	private static final Logger log = LoggerFactory.getLogger(VisualizeGraphStory.class);
	
	@Then("the percentage of the graph in green for each test case will be: $rows")
	@Pending
	public void thenThePercentageOfTheGraphInGreenForEachTestCaseWillBe(String rows) {
		// TODO
	}

	@Then("a graph of the test set score shoud be shown")
	@Pending
	public void thenAGraphOfTheTestSetScoreShoudBeShown() {
		// TODO
	}

	@Given("that the user has access to the system")
	@Pending
	public void givenThatTheUserHasAccessToTheSystem() {
		// TODO
	}

	@Given("a test set has been upload")
	@Pending
	public void givenATestSetHasBeenUpload() {
		//TODO
	}

	@Given("the uploaded file is $file")
	@Pending
	public void givenTheUploadedFileIsTest_result_1xml(String filename) {
		// TODO
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