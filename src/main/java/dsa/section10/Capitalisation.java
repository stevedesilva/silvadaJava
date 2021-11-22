package dsa.section10;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Capitalisation {

    public String capitaliseFirstWordInSentenceUsingByteArray(String sentence) {
        String[] words = sentence.split(" ");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            byte[] wordAsBytes = words[i].getBytes();
            byte[] firstLetter = Arrays.copyOfRange(wordAsBytes, 0, 1);
            byte[] tail = Arrays.copyOfRange(wordAsBytes, 1, wordAsBytes.length);
            String start = new String(firstLetter, StandardCharsets.UTF_8).toUpperCase();
            String end = new String(tail, StandardCharsets.UTF_8);

            result.add(String.format("%s%s", start, end));
        }
        return String.join(" ", result);
    }

    public String capitaliseFirstCharInWordUsingCharArray(String sentence) {
        String[] words = sentence.split(" ");
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();

            word[0] = Character.toUpperCase(word[0]);
            result.add(new String(word));
        }
        return String.join(" ", result);
    }

    public String capitaliseFirstCharInWordUsingSubstring(String sentence) {
        String[] words = sentence.split(" ");
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = Character.toUpperCase(word.charAt(0));
            result.add(firstChar + word.substring(1));
        }
        return String.join(" ", result);
    }

}
