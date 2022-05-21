package decorator.prelambda.decorator;

import decorator.prelambda.Text;

public class ReplaceThisWithThat extends BaseTextDecorator {

    public ReplaceThisWithThat(Text text) {
        super(text);
    }

    @Override
    public String format(String s) {
        return text.format(s).replaceAll("this","that");
    }

}
