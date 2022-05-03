package patterns.decorator.prelambda.decorator;

import patterns.decorator.prelambda.Text;

public class AllCaps extends BaseTextDecorator {

    public AllCaps(Text text) {
        super(text);
    }

    @Override
    public String format(String s) {
        return text.format(s).toUpperCase();
    }

}
