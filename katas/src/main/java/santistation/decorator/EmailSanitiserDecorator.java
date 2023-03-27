package santistation.decorator;

import santistation.Sanitiser;
import santistation.decorator.SanitiserDecorator;

public class EmailSanitiserDecorator extends SanitiserDecorator {
    private static String emailPattern = "[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";



    public EmailSanitiserDecorator(Sanitiser sanitiser) {
        super(sanitiser);
    }

    @Override
    public String decorate(String input) {
        //        String testEmail = "The is my test with email chris@tescointerview.co.uk, and some other text";
        //        String expected = "The is my test with email REDACTED, and some other text";

        return input.replaceAll(emailPattern, REDACTED);


    }

}
