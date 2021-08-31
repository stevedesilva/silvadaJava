package dsa.chapter2;

import java.nio.charset.StandardCharsets;

public class Reversal {
    public String reverseWithStringBuilder(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public String reverseWithCharAt(String input) {
        String result = "";
        for(int i = input.length() -1; i >= 0; i--) {
            result += input.charAt(i);
        }
        return result;
    }

    public String reverseWithBytes(String input) {
        byte[] inputAsBytes = input.getBytes();
        // move inwards swapping chars
        for (int i = 0, j = inputAsBytes.length-1; i < j; i++, j--) {
            byte temp = inputAsBytes[i];
            inputAsBytes[i] = inputAsBytes[j];
            inputAsBytes[j] = temp;
        }
        return new String(inputAsBytes, StandardCharsets.UTF_8);
    }
    public String reverseWithCharAtInline(String input) {
        char[] array = new char[input.length()];
        // move inwards swapping chars
        for (int j = input.length()-1; j >= 0; j--) {
            array[(input.length() -1) - j] = input.charAt(j);
        }
        return new String(array);

    }


}
