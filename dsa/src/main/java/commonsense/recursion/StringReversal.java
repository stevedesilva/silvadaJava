package commonsense.recursion;

public class StringReversal {
    public String reverse(String word) throws IllegalArgumentException{
        if (word == null || word.length() < 1){
            throw new IllegalArgumentException("minimum input of one not met");
        }
        return "";
    }
}
