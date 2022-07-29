package decorator.withabstractmethod;

public abstract class IceCreamDecorator implements IceCream{
    private IceCream iceCream;

    public IceCreamDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public int cost() {
        return iceCream.cost() + price();
    }

    public abstract int price();
}
