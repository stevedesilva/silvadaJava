package santistation;

public interface Sanitiser {
    public static String REDACTED = "REDACTED";
    public String sanitise(String input);
}
