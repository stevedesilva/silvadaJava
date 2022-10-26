package commonsense.stack;

public class Linter implements LinterFunctions{

    private String data;

    public Linter(String data) {
        this.data = data;
    }

    @Override
    public boolean Validate() throws IllegalArgumentException {
        return false;
    }
}
