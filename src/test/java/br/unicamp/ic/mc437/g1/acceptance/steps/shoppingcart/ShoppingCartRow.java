package br.unicamp.ic.mc437.g1.acceptance.steps.shoppingcart;

import org.jbehave.core.annotations.*;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@AsParameters
public class ShoppingCartRow {

    @Parameter(name = "PRODUCT")
    private String productName;

    @Parameter(name = "QTY")
    private Integer quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}