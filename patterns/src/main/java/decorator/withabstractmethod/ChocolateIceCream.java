package decorator.withabstractmethod;

public class ChocolateIceCream extends IceCreamDecorator{

    public ChocolateIceCream(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public int price() {
        return 5;
    }

}
