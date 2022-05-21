package decorator.prelambda.decorator;


import decorator.prelambda.Text;

public abstract class BaseTextDecorator implements Text {

    protected Text text;

    public BaseTextDecorator(Text text) {
        this.text = text;
    }

    @Override
    public abstract String format(String s);
}
