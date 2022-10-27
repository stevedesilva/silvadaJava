package commonsense.stack;

public interface LinterFunctions {
    boolean Validate() throws IllegalArgumentException;
    String MINIMUM_INPUT_NOT_MET = "minimum input not met";
    String ERROR_MISSING_OPENING_BRACE = "missing opening brace";
    String ERROR_MISSING_CLOSING_BRACE = "missing closing brace";
    String ERROR_BRACE_MISMATCH = "brace mismatch";
}
