package commonsense.array;

import java.util.ArrayList;
import java.util.List;

public class PasswordCracker {
    public String[] generateCombinations(char[] setOfChars, int combinationLength){
        List<String> collector = new ArrayList<>();
        generateCombinationsRec(setOfChars, setOfChars.length, "", combinationLength, collector);

        return collector.toArray(String[]::new);
    }

    public void generateCombinationsRec(char[] charSet, int  setOfCharsLength, String prefix, int combinationLength,List<String> collector){

        // Base case
        if (combinationLength == 0) {
            System.out.println(prefix);
            collector.add(prefix);
            return;
        }
        // for each letter in charSet recursive call to find all possible collector
        //   a     b
        // a   b a   b
        for (int i=0; i < setOfCharsLength; i++){
            String updatedPrefix = prefix+charSet[i];
            generateCombinationsRec(charSet, charSet.length, updatedPrefix, combinationLength-1, collector);
        }

    }

    public static void main(String[] args) {
        final String[] strings = new PasswordCracker().generateCombinations(new char[]{'a', 'b'}, 3);
    }
}
