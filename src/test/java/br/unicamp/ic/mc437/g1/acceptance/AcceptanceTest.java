package br.unicamp.ic.mc437.g1.acceptance;

import br.unicamp.ic.mc437.g1.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.*;

import java.lang.annotation.*;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@ContextConfiguration(classes = AcceptanceTestsConfiguration.class)
@DirtiesContext
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AcceptanceTest {
}
