package br.unicamp.ic.mc437.g1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@Configuration
@Import({MainTestConfiguration.class})
@ComponentScan
public class AcceptanceTestsConfiguration {

    @Bean(destroyMethod = "close")
    @Qualifier("firefoxDriver")
    @Primary
    public WebDriver firefoxDriver() {
    	FirefoxProfile profile = new FirefoxProfile();
    	profile.setPreference("general.useragent.override", "JBehave");
        return new FirefoxDriver(profile);
    }

//    @Bean(destroyMethod = "close")
//    @Qualifier("chromeDriver")
//    public WebDriver chromeDriver() {
//        return new ChromeDriver();
//    }
}
