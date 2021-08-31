package patterns.decorator;

public class Tinsel extends ChristmasTreeDecorator{
    public Tinsel(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    @Override
    public String additions() {
        return "with tinsel";
    }
}
