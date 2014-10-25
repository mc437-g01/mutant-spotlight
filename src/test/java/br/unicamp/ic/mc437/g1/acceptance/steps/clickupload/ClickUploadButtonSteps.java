package br.unicamp.ic.mc437.g1.acceptance.steps.clickupload;

import br.unicamp.ic.mc437.g1.acceptance.Steps;
import br.unicamp.ic.mc437.g1.acceptance.steps.SharedSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@Steps
public class ClickUploadButtonSteps {

    private static final Logger log = LoggerFactory.getLogger(SharedSteps.class);

    @Resource(name = "firefoxDriver")
    private WebDriver driver;

    @Value("classpath:acceptance/step_files/test_result_1.xml")
    private org.springframework.core.io.Resource testResult1Resource;

    @Value("classpath:acceptance/step_files/invalid_file_1.xml")
    private org.springframework.core.io.Resource invalidFile11Resource;

    @Value("${server.endpoint}")
    private String serverEndpoint;

    @Given("upload page loaded")
    public void homePageLoaded() {
        log.debug("homePageLoaded");

        driver.navigate().to(serverEndpoint + "/new-result");
    }

    @When("I fill the email input")
    public void fillEmail() {
        driver.findElement(By.id("email-address")).clear();
        driver.findElement(By.id("email-address")).sendKeys("teste@teste.com");
    }

    @When("I fill the name input")
    public void fillName() {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("test result 1");
    }

    @When("I select a file to upload")
    public void selectFile() throws IOException {
        driver.findElement(By.id("upload-file")).sendKeys(testResult1Resource.getFile().getAbsolutePath());
    }

    @When("I select a invalid file to upload")
    public void selectInvalidFile() throws IOException {
        driver.findElement(By.id("upload-file")).sendKeys(invalidFile11Resource.getFile().getAbsolutePath());
    }

    @When("I click on upload button")
    public void clickOnUpload() {
        driver.findElement(By.id("upload")).submit();
    }

    @Then("the system redirects to upload page")
    public void redirectsToUploadPage() {
        log.debug("redirectsToUploadPage");

        assertTrue("Should redirects to result-upload page", driver.getCurrentUrl().startsWith(serverEndpoint + "/result-upload"));
    }

    @Then("the system shows an empty file error")
    public void showsAnEmptyFileError() {
        String display = driver.findElement(By.id("empty-file-error")).getCssValue("display");

        assertEquals("block", display);
    }

    @Then("the system shows an empty email error")
    public void showsAnEmptyEmailError() {
        String display = driver.findElement(By.id("empty-email-error")).getCssValue("display");

        assertEquals("block", display);
    }

    @Then("the system shows an empty name error")
    public void showsAnEmptyNameError() {
        String display = driver.findElement(By.id("empty-name-error")).getCssValue("display");

        assertEquals("block", display);
    }

    @Then("the system shows an invalid file error")
    public void showsAnInvalidFileError() {
        String display = driver.findElement(By.id("invalid-file-error")).getCssValue("display");

        assertEquals("block", display);
    }
}
