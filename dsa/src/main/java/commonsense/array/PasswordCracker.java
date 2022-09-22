package commonsense.array;

import java.util.ArrayList;
import java.util.List;

public class PasswordCracker {

    public static void generateCombinations(char[] setOfChars, int combinationLength){
        final List<String> results = generateCombinationsRec(setOfChars, setOfChars.length, "", combinationLength);
        System.out.printf("Results: \n %s", results);
    }
    public static List<String> generateCombinationsRec(char[] charSet, int  setOfCharsLength, String prefix, int combinationLength){
        List<String> combinations = new ArrayList<>();
        // Base case
        if (combinationLength == 0) {
            System.out.println(prefix);
            combinations.add(prefix);
            return combinations;
        }
        // for each letter in charSet recursive call to find all possible combinations
        //   a     b
        // a   b a   b
        for (int i=0; i < setOfCharsLength; i++){
            String updatedPrefix = prefix+charSet[i];
            generateCombinationsRec(charSet, charSet.length, updatedPrefix, combinationLength-1);
        }

        return combinations;

    }

    public static void main(String[] args) {
        generateCombinations(new char[]{'a','b'},3);
    }
}
