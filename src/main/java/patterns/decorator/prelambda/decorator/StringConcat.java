package patterns.decorator.prelambda.decorator;

import patterns.decorator.prelambda.Text;

public class StringConcat extends BaseTextDecorator {

    public StringConcat(Text text) {
        super(text);
    }

    @Override
    public String format(String s) {
        return text.format(s).concat(s);
    }

}
