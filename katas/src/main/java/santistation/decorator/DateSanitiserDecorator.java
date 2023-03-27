package santistation.decorator;

import santistation.Sanitiser;
import santistation.decorator.SanitiserDecorator;

public class DateSanitiserDecorator extends SanitiserDecorator {


    public DateSanitiserDecorator(Sanitiser sanitiser) {
        super(sanitiser);
    }

    @Override
    public String decorate(String input) {
        return input + "date";
    }

}
