package br.unicamp.ic.mc437.g1.acceptance.steps.calculatescore;

import br.unicamp.ic.mc437.g1.acceptance.Steps;
import br.unicamp.ic.mc437.g1.entity.TestResult;
import br.unicamp.ic.mc437.g1.model.dao.TestResultDAO;
import br.unicamp.ic.mc437.g1.model.service.ScoreService;
import br.unicamp.ic.mc437.g1.util.XmlUtils;
import com.google.common.collect.Sets;
import org.apache.commons.io.FileUtils;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@Steps
public class CalculateScoreSteps {

    private final Logger log = LoggerFactory.getLogger(CalculateScoreSteps.class);


    @Resource(name = "firefoxDriver")
    private WebDriver driver;

    @Value("classpath:acceptance/step_files/")
    private org.springframework.core.io.Resource testResourcesBasePath;

    private Map<String, TestResult> loadedTestResults;

    private WebElement fileLinkFound;

    @Autowired
    private TestResultDAO testResultDAO;

    @Autowired
    private ScoreService scoreService;

    @Value("${server.endpoint}")
    private String serverEndpoint;

    private Integer testResultScore;
    private Map<String, Integer> testSetScoreMap;

    public CalculateScoreSteps() {
        loadedTestResults = new HashMap<String, TestResult>();
    }

    @BeforeScenario
    public void beforeScenario() {
        testSetScoreMap = new HashMap<String, Integer>();
        testResultScore = null;
    }

	@Given("there is the test $testFileName in the system")
	public void givenThereIsTheTestInTheSystem(String testFileName) throws IOException {
        if (!loadedTestResults.containsKey(testFileName)) {
            String basePath = testResourcesBasePath.getFile().getAbsolutePath();

            File file = FileUtils.getFile(basePath + File.separator + testFileName + ".xml");
            TestResult testResultLoaded = XmlUtils.readValue(FileUtils.readFileToString(file), TestResult.class);
            testResultLoaded.setName(testFileName);
            testResultLoaded.setEmail("test@test.com");

            boolean testResultFound = false;
            for (TestResult testResult : testResultDAO.list()) {
                if (testResult.getName().equals(testResultLoaded.getName())) {
                    // test result found in database
                    testResultFound = true;
                    break;
                }
            }
            if (!testResultFound) {
                scoreService.calculateScore(testResultLoaded);
                testResultDAO.save(testResultLoaded);
            }

            loadedTestResults.put(testFileName, testResultLoaded);
        }
	}

	@Given("the test list page loaded")
	public void givenTheTestListPageLoaded() {
        log.debug("givenTheTestListPageLoaded");

        driver.navigate().to(serverEndpoint + "/result-list");
	}

    @When("I choose a test")
    public void whenIChooseATest() {
        List<WebElement> tableRows = retrieveTableRows();

        WebElement td;
        Set<Integer> sortedRows = new HashSet<Integer>();
        do {
            int randomRow = new Random().nextInt((tableRows.size()));
            sortedRows.add(randomRow);

            WebElement tableRow = tableRows.get(randomRow);
            List<WebElement> tds = tableRow.findElements(By.tagName("td"));
            td = tds.get(1);

            // check if the test result is valid for this test
            WebElement nameTd = tds.get(1).findElement(By.tagName("a")); // get the name column
            String currentTestFileName = nameTd.getText();
            if (!isValidTestResult(loadedTestResults.keySet(), currentTestFileName)) {
                td = null;
            }
        } while (td == null && sortedRows.size() < tableRows.size());

        Assert.assertNotNull("It was not found a valid test set result in the list", td);
        fileLinkFound = td.findElement(By.tagName("a"));

        Assert.assertNotNull("The file was not found in the test result list", fileLinkFound);
    }

    private boolean isValidTestResult(Set<String> validTestSetResults, String currentTestFileName) {
        for (String validTestSetResult : validTestSetResults) {
            if (validTestSetResult.equalsIgnoreCase(currentTestFileName)) {
                return true;
            }
        }
        return false;
    }

    @When("I choose the test $testFileName")
    public void whenIChooseTheTest(String testFileName) {
        List<WebElement> tableRows = retrieveTableRows();
        for (WebElement tableRow : tableRows) {
            List<WebElement> tds = tableRow.findElements(By.tagName("td"));
            WebElement nameTd = tds.get(1).findElement(By.tagName("a")); // get the name column
            String currentTestFileName = nameTd.getText();
            if (testFileName.equals(currentTestFileName)) {
                fileLinkFound = nameTd;
                break;
            }
        }
        Assert.assertNotNull("The file was not found in the test result list", fileLinkFound);

    }

	@Then("the system redirects to result show page")
	public void thenTheSystemRedirectsToResultShowPage() {
        fileLinkFound.click(); // redirects to found test file
	}

    @Then("show the calculated score for test result")
    public void thenShowTheCalculatedScoreForTestResult() {
        String attribute = driver.findElement(By.id("test_result_score")).getAttribute("score");
        Assert.assertNotNull("Test result score could not be found", attribute);

        testResultScore = parseInt(attribute);
    }

    @Then("show the calculated scores for test sets")
    public void thenShowTheCalculatedScoresForTestSets() {
        List<WebElement> testSetScoreElements = driver.findElements(By.xpath("//div[@id='test_set_score']"));
        Assert.assertTrue("Test result score could not be found", testSetScoreElements != null && !testSetScoreElements.isEmpty());

        testSetScoreMap = new HashMap<String, Integer>();
        for (final WebElement testSetScoreElement : testSetScoreElements) {
            String testSetId = testSetScoreElement.getAttribute("test_set_id");
            Integer score = parseInt(testSetScoreElement.getAttribute("score"));

            Assert.assertNotNull("TestSetId must not be null", testSetId);
            Assert.assertNotNull("Score of testSetId " + testSetId + " must not be null", score);
            testSetScoreMap.put(testSetId, score);
        }
    }

	@Then("the calculated score for test result is $score%")
	public void thenTheCalculatedScoreForTestResultIs(Integer score) {
		Assert.assertEquals(score, testResultScore);
	}

	@Then("the calculated scores for test sets is:$rows")
	public void thenTheCalculatedScoresForTestSetsIs(List<TestSetScore> testSetScores) {
        for (final TestSetScore testSetScore : testSetScores) {
            Integer score = testSetScoreMap.get(testSetScore.getTestSetId());
            Assert.assertEquals(testSetScore.getScore(), score);
        }
	}

    private Integer parseInt(Object value) {
        if (value instanceof Integer) {
            return (Integer) value;
        }
        try {
            return Integer.valueOf(value.toString());
        } catch (Exception e) {
            // ignore
        }
        return null;
    }

    private List<WebElement> retrieveTableRows() {
        //getting the table
        WebElement baseTable = driver.findElement(By.id("result_table"));
        WebElement tBody = baseTable.findElement(By.tagName("tbody"));
        List<WebElement> tableRows = tBody.findElements(By.tagName("tr"));

        //getting a random row in the table
        int rowCount = driver.findElements(By.xpath("//table[@id='result_table']/tbody/tr")).size();
        Assert.assertTrue("No lines were found in the list results page", rowCount > 0);

        return tableRows;
    }
}