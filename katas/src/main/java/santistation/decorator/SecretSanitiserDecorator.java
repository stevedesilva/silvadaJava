package santistation.decorator;

import santistation.Sanitiser;

public class SecretSanitiserDecorator extends SanitiserDecorator {

//    private static String regex = "Secret:X";
    private static String regex = "Secret:\\w";
    public SecretSanitiserDecorator(Sanitiser sanitiser) {
        super(sanitiser);
    }

    @Override
    public String decorate(String input) {
        return input.replaceAll(regex,Sanitiser.REDACTED);
    }

}
