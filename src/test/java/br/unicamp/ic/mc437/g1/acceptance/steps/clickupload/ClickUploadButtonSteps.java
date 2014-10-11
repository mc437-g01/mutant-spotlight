package br.unicamp.ic.mc437.g1.acceptance.steps.clickupload;

import br.unicamp.ic.mc437.g1.acceptance.*;
import br.unicamp.ic.mc437.g1.acceptance.steps.*;
import br.unicamp.ic.mc437.g1.acceptance.steps.shoppingcart.*;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.*;
import java.util.*;

import static org.junit.Assert.assertTrue;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@Steps
public class ClickUploadButtonSteps {

    private static final Logger log = LoggerFactory.getLogger(SharedSteps.class);

    @Resource(name = "firefoxDriver")
    private WebDriver driver;

    private List<WebElement> resultado;

    @Given("homepage loaded")
    public void homePageLoaded() {
        log.debug("homePageLoaded");

        driver.navigate().to("http://www.infoq.com/br");
    }

    @When("I click on upload button")
    public void clickOnUpload() {
        driver.findElement(By.id("keyword")).clear();

        driver.findElement(By.id("keyword")).sendKeys("ignatowicz");

        driver.findElement(By.id("search")).submit();

        resultado = driver.findElements(By
                .className("one_result"));
    }

    @Then("then the system redirects to upload page")
    public void redirectsToUploadPage() {
        log.debug("redirectsToUploadPage");

        assertTrue("devem existir elementos", resultado.size() > 0);
    }
}
