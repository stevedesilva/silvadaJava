package patterns.decorator.prelambda.base;

import patterns.decorator.prelambda.Text;

public class BaseText implements Text {

    @Override
    public String format(String s) {
        return s;
    }
}
