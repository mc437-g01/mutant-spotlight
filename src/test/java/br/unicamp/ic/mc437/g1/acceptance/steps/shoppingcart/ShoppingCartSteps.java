package br.unicamp.ic.mc437.g1.acceptance.steps.shoppingcart;

import br.unicamp.ic.mc437.g1.acceptance.*;
import br.unicamp.ic.mc437.g1.acceptance.steps.*;
import org.jbehave.core.annotations.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@Steps
public class ShoppingCartSteps {

    private static final Logger log = LoggerFactory.getLogger(SharedSteps.class);

    @Given("empty shopping cart")
    public void emptyShoppingCart() {
        log.debug("emptyShoppingCart");
    }

    @When("products are added to the shopping cart: $rows")
    public void addProducts(List<ShoppingCartRow> rows) {
        log.debug("rows {}", rows);
    }

    @Then("shopping cart is empty")
    public void isEmpty() {
        log.debug("shopping cart is empty");
    }

    @Then("the number of products in shopping cart is $numberOfItems")
    public void numberOfItems(int numberOfItems) {
        log.debug("numberOfItems {}", numberOfItems);
    }

    @Then("total price is $price")
    @Pending
    public void totalPrice(String price) {
        log.debug("totalPrice {}", price);
    }
}
