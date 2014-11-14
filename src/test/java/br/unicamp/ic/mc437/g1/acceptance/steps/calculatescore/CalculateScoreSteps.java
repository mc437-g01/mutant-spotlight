package br.unicamp.ic.mc437.g1.acceptance.steps.calculatescore;

import br.unicamp.ic.mc437.g1.acceptance.Steps;
import br.unicamp.ic.mc437.g1.entity.TestResult;
import br.unicamp.ic.mc437.g1.entity.TestSetResult;
import br.unicamp.ic.mc437.g1.model.dao.TestResultDAO;
import br.unicamp.ic.mc437.g1.util.XmlUtils;
import org.apache.commons.io.FileUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Steps
public class CalculateScoreSteps {

    private final Logger log = LoggerFactory.getLogger(CalculateScoreSteps.class);


    @Resource(name = "firefoxDriver")
    private WebDriver driver;

    @Value("classpath:acceptance/step_files/")
    private org.springframework.core.io.Resource testResourcesBasePath;

    private Map<String, TestResult> loadedTestResults;

    @Autowired
    private TestResultDAO testResultDAO;

    @Value("${server.endpoint}")
    private String serverEndpoint;

    public CalculateScoreSteps() {
        loadedTestResults = new HashMap<String, TestResult>();
    }

	@Given("there is the test $testFileName in the system")
	public void givenThereIsTheTestInTheSystem(String testFileName) throws IOException {
        String basePath = testResourcesBasePath.getFile().getAbsolutePath();

        File file = FileUtils.getFile(basePath + File.separator + testFileName + ".xml");
        TestResult testResultLoaded = XmlUtils.readValue(FileUtils.readFileToString(file), TestResult.class);
        testResultLoaded.setName(testFileName);
        testResultLoaded.setEmail("test@test.com");

        boolean testResultFound = false;
        for (TestResult testResult : testResultDAO.list()) {
            if (testResult.getName().equals(testResult.getName())) {
                // test result found in database
                testResultFound = true;
                break;
            }
        }
        if (!testResultFound) {
            testResultDAO.save(testResultLoaded);
        }

        loadedTestResults.put(testFileName, testResultLoaded);
	}

	@Given("the test list page loaded")
	@Pending
	public void givenTheTestListPageLoaded() {
        log.debug("givenTheTestListPageLoaded");

        driver.navigate().to(serverEndpoint + "/result-list");
	}

    @When("I choose a test")
    @Pending
    public void whenIChooseATest() {

    }

    @When("I choose the test $testFileName")
    @Pending
    public void whenIChooseTheTest(String testFileName) {
        // TODO
    }

	@Then("the system redirects to result show page")
	@Pending
	public void thenTheSystemRedirectsToResultShowPage() {
		// TODO
	}

	@Then("the calculated score for test result is $score%")
	@Pending
	public void thenTheCalculatedScoreForTestResultIs(int score) {
		// TODO
	}

	@Then("show the calulated scores for test sets")
	@Pending
	public void thenShowTheCalulatedScoresForTestSets() {
		// TODO
	}

	@Then("show the calculated score for test result")
	@Pending
	public void thenShowTheCalculatedScoreForTestResult() {
		// TODO
	}

	@Then("the calulated scores for test sets is:$rows")
	@Pending
	public void thenTheCalulatedScoresForTestSetsIs(List<TestSetScore> testSetScores) {
		// TODO
	}
}