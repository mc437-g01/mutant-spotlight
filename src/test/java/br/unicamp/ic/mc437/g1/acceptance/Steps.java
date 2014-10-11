package br.unicamp.ic.mc437.g1.acceptance;

import org.springframework.stereotype.*;

import java.lang.annotation.*;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Steps {
}
