package decorator.withabstractmethod;

public class MintIceCream extends IceCreamDecorator {
    public MintIceCream(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public int price() {
        return 7;
    }
}
