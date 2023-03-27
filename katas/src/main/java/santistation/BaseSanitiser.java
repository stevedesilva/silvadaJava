package santistation;

public class BaseSanitiser implements Sanitiser {

    private String input;

    public BaseSanitiser(String input) {
        this.input = input;
    }

    @Override
    public String sanitise(String input) {
        return input;
    }

}
