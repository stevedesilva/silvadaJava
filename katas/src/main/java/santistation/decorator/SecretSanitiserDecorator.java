package santistation.decorator;

import santistation.Sanitiser;

public class SecretSanitiserDecorator extends SanitiserDecorator {
    public SecretSanitiserDecorator(Sanitiser sanitiser) {
        super(sanitiser);
    }

    @Override
    public String decorate(String input) {
        return input;
    }

}
