package decorator.withsuper.interfaces;

import java.math.BigDecimal;

public class IceCreamDecorator implements IceCream {
    private IceCream iceCream;

    public IceCreamDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public BigDecimal cost() {
        return iceCream.cost();
    }
}
