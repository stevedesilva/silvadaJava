package dsa.section10;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Capitalisation {
    public String capitaliseFirstWordInSentence(String sentence) {
        String[] words = sentence.split(" ");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            byte[] wordAsBytes = words[i].getBytes();
            byte[] firstLetter = Arrays.copyOfRange(wordAsBytes, 0, 1);
            byte[] tail = Arrays.copyOfRange(wordAsBytes, 1,wordAsBytes.length);
            String start = new String(firstLetter, StandardCharsets.UTF_8).toUpperCase();
            String end = new String(tail, StandardCharsets.UTF_8);

            result.add(String.format("%s%s",start,end));
        }
        return String.join(" ", result);
    }
}
