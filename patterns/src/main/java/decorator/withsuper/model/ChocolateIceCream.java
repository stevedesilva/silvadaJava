package decorator.withsuper.model;

import udemy.decorator.withsuper.interfaces.IceCream;
import udemy.decorator.withsuper.interfaces.IceCreamDecorator;

import java.math.BigDecimal;

public class ChocolateIceCream extends IceCreamDecorator {

    public ChocolateIceCream(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public BigDecimal cost() {
        return super.cost().add(BigDecimal.valueOf(20.00));
    }
}
