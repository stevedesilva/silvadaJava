package commonsense.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Linter implements LinterFunctions {

    private static Set<Character> openBraces =  Set.of('{','[','(');
    private static Map<Character,Character> closingBraces = Map.of('{','}','[',']','(',')');

    private String data;
    private Stack<Character> stack;
    public Linter(String data) {
        this.data = data;
        this.stack= new Stack<>();
    }

    @Override
    public boolean Validate() throws IllegalArgumentException {
        if (data == null || data.length() < 1) {
            throw new IllegalArgumentException(MINIMUM_INPUT_NOT_MET);
        }

        for (int i = 0; i < data.length(); i++) {
            final char value = data.charAt(i);
            if (openBraces.contains(value)){
                stack.push(value);
            } else if (closingBraces.containsKey(value)) {

                if (!closingBraces.get(value).equals(stack.peek())){
                    throw new IllegalArgumentException(LinterFunctions.ERROR_BRACE_MISMATCH);
                }
            }
        }
        if(stack.size() > 0) {
            throw new IllegalArgumentException(LinterFunctions.ERROR_MISSING_CLOSING_BRACE);
        }
        return true;
    }
}
