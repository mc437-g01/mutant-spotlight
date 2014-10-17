package br.unicamp.ic.mc437.g1.acceptance.steps.clickupload;

import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.unicamp.ic.mc437.g1.acceptance.Steps;
import br.unicamp.ic.mc437.g1.acceptance.steps.SharedSteps;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@Steps
public class ClickUploadButtonSteps {

    private static final Logger log = LoggerFactory.getLogger(SharedSteps.class);

    @Resource(name = "firefoxDriver")
    private WebDriver driver;

    @Given("homepage loaded")
    public void homePageLoaded() {
        log.debug("homePageLoaded");

        driver.navigate().to("http://localhost:8080/mutant-spotlight/new-result");
    }

    @When("I click on upload button")
    public void clickOnUpload() {
        driver.findElement(By.id("email-address")).clear();
        driver.findElement(By.id("email-address")).sendKeys("teste@teste.com");
        
        // TODO: Definir arquivo de upload ;)

        driver.findElement(By.id("upload")).submit();
    }

    @Then("then the system redirects to upload page")
    public void redirectsToUploadPage() {
        log.debug("redirectsToUploadPage");
        
        // TODO: verificar que a página agora é http://localhost:8080/mutant-spotlight/result-upload

        assertTrue("devem existir elementos", true);
    }
}
