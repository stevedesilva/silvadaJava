package decorator.withsuper.model;



import decorator.withsuper.interfaces.IceCream;

import java.math.BigDecimal;

public class BasicIceCream implements IceCream {
    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(1.00);
    }
}
