package decorator.prelambda.base;


import decorator.prelambda.Text;

public class BaseText implements Text {

    @Override
    public String format(String s) {
        return s;
    }
}
