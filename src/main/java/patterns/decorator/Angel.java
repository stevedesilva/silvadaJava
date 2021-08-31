package patterns.decorator;

public class Angel extends ChristmasTreeDecorator{
    public Angel(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    @Override
    public String additions() {
        return "with an Angel";
    }
}
