package br.unicamp.ic.mc437.g1.acceptance.steps.clickupload;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.internal.FileExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.unicamp.ic.mc437.g1.acceptance.Steps;
import br.unicamp.ic.mc437.g1.acceptance.steps.SharedSteps;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;

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

    @Value("${server.endpoint}")
    private String serverEndpoint;

    @Given("upload page loaded")
    public void homePageLoaded() {
        log.debug("homePageLoaded");

        driver.navigate().to(serverEndpoint + "/new-result");
    }
    
    @When("I fill the email input")
    public void fillEmail () {
        driver.findElement(By.id("email-address")).clear();
        driver.findElement(By.id("email-address")).sendKeys("teste@teste.com");
    }
    
    @When("I select a file to upload")
    public void selectFile() throws IOException {
//        driver.findElement(By.id("upload-file")).clear();

        driver.findElement(By.id("upload-file")).sendKeys(testResult1Resource.getFile().getAbsolutePath());
    }

    @When("I click on upload button")
    public void clickOnUpload() {
        driver.findElement(By.id("upload")).submit();
    }

    @Then("the system redirects to upload page")
    public void redirectsToUploadPage() {
        log.debug("redirectsToUploadPage");
        
        assertEquals("devem existir elementos", serverEndpoint + "/result-upload", driver.getCurrentUrl());
    }
    
    @Then("the system shows an empty file error")
    public void showsAnEmptyFileError () {
        String hiddenAttr = driver.findElement(By.id("empty-file-error")).getAttribute("hidden");
        
        assertEquals("false", hiddenAttr);
    }
    
    @Then("the system shows an empty email error")
    public void showsAnEmptyEmailError () {
        String hiddenAttr = driver.findElement(By.id("empty-email-error")).getAttribute("hidden");
        
        assertEquals("false", hiddenAttr);
    }
    
    @Then("the system shows an invalid file error")
    public void showsAnInvalidFileError () {
    	String hiddenAttr = driver.findElement(By.id("invalid-file-error")).getAttribute("hidden");
        
        assertEquals("false", hiddenAttr);
    }
}
