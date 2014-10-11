package br.unicamp.ic.mc437.g1.acceptance.steps;

import br.unicamp.ic.mc437.g1.acceptance.*;
import org.jbehave.core.annotations.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@Steps
public class SharedSteps {

    private static final Logger log = LoggerFactory.getLogger(SharedSteps.class);

    @Given("product $name with SKU $sku")
    public void product(String name, String sku) {
        log.debug("product {}, sku {}", name, sku);
    }

    @Given("product $name price is $price")
    public void price(String name, String price) {
        log.debug("name {}, price {}", name, price);
    }
}
