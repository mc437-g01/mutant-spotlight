package br.unicamp.ic.mc437.g1.acceptance;

import br.unicamp.ic.mc437.g1.AcceptanceTestsConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@ContextConfiguration(classes = AcceptanceTestsConfiguration.class)
@DirtiesContext
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AcceptanceTest {
}
