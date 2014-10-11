package br.unicamp.ic.mc437.g1;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@Configuration
@Import({MainTestConfiguration.class})
@ComponentScan
public class UnitTestsConfiguration {

}
