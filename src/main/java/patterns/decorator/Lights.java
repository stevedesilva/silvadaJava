package patterns.decorator;

public class Lights extends ChristmasTreeDecorator{
    public Lights(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    @Override
    public String additions() {
        return "with lights";
    }
}
