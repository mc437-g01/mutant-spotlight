package br.unicamp.ic.mc437.g1;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@Configuration
@ComponentScan
@PropertySource("classpath:test.properties")
public class MainTestConfiguration {
}
