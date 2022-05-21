package decorator.prelambda.decorator;


import decorator.prelambda.Text;

public class AllCaps extends BaseTextDecorator {

    public AllCaps(Text text) {
        super(text);
    }

    @Override
    public String format(String s) {
        return text.format(s).toUpperCase();
    }

}
