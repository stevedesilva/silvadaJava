package santistation.decorator;

import santistation.Sanitiser;

public abstract class SanitiserDecorator implements Sanitiser {

    private Sanitiser sanitiser;

    public SanitiserDecorator(Sanitiser sanitiser) {
        this.sanitiser = sanitiser;
    }

    @Override
    public String sanitise(String input) {
        return decorate(sanitiser.sanitise(input));
    }

    public abstract String decorate(String input);

}
