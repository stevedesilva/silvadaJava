package commonsense.stack;


import java.util.ArrayList;
import java.util.List;

public class ReverseString {

    public static String MINIMUM_INPUT_NOT_MET = "minimum input not met";
    public static String reverse(String data) throws IllegalArgumentException{
        if (data == null || data.length() < 1) {
            throw new IllegalArgumentException(MINIMUM_INPUT_NOT_MET);
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < data.length(); i++) {
            stack.push(data.charAt(i));
        }
        List<Character> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            sb.append(stack.pop());
        }
       return sb.toString();
    }
}
