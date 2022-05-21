package decorator.prelambda.decorator;


import decorator.prelambda.Text;

public class StringConcat extends BaseTextDecorator {

    public StringConcat(Text text) {
        super(text);
    }

    @Override
    public String format(String s) {
        return text.format(s).concat(s);
    }

}
