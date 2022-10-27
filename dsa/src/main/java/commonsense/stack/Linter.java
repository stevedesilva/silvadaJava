package commonsense.stack;

public class Linter implements LinterFunctions {


    private String data;

    public Linter(String data) {
        this.data = data;
    }

    @Override
    public boolean Validate() throws IllegalArgumentException {
        if (data == null || data.length() < 1) {
            throw new IllegalArgumentException(MINIMUM_INPUT_NOT_MET);
        }

        for (int i = 0; i < data.length(); i++) {

        }
        return true;
    }
}
