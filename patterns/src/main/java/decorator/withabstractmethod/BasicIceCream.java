package decorator.withabstractmethod;

public class BasicIceCream implements IceCream {
    private int cost;

    public BasicIceCream() {
        this.cost = 5;
    }

    @Override
    public int cost() {
        return cost;
    }
}
