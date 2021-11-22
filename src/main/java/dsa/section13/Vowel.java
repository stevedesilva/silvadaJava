package dsa.section13;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vowel {

    public int CalculateNumberOfVowelsIterativeUsingMap(String input) {
        Set<Character> vowels = Set.of('a','e','i','o','u');
        int count = 0;
        String lowerCaseInput = input.toLowerCase();
        for ( int i = 0; i < input.length(); i++) {
            if (vowels.contains(lowerCaseInput.charAt(i))){
                count++;
            }
        }
        return count;
    }

    public int CalculateNumberOfVowelsRegex(String input) {
        Pattern p = Pattern.compile("(?i)([aeiou])", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);

        int count=0;
        while (m.find()){
            count = count + m.group(0).length();
        }
        return count;
    }

}
