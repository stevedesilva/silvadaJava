package commonsense.recursion;

public class StringReversal {
    public static final String MINIMUM_INPUT_OF_ONE_NOT_MET = "minimum input of one not met";

    public static String reverse(String word) throws IllegalArgumentException{
        if (word == null || word.length() < 1){
            throw new IllegalArgumentException(MINIMUM_INPUT_OF_ONE_NOT_MET);
        }
        return "";
    }
}
