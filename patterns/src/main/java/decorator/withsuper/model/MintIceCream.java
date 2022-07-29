package decorator.withsuper.model;


import decorator.withsuper.interfaces.IceCream;
import decorator.withsuper.interfaces.IceCreamDecorator;

import java.math.BigDecimal;

public class MintIceCream extends IceCreamDecorator {

    public MintIceCream(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public BigDecimal cost() {
        return super.cost().add(BigDecimal.valueOf(15.00));
    }
}
