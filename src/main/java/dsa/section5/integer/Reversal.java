package dsa.section5.integer;

import java.nio.charset.StandardCharsets;

public class Reversal {

    public Integer reverseIntegerWithBuilder(Integer input) {
        String reversedStr = new StringBuilder(input.toString()).reverse().toString();
        return Integer.valueOf(reversedStr);
    }

    public Integer reverseIntegerWithCharAt(Integer num) {
        String input = num.toString();
        String result = "";
        for(int i = input.length() -1; i >= 0; i--) {
            result += input.charAt(i);
        }
        return Integer.valueOf(result);
    }

    public Integer reverseIntegerWithBytes(Integer input) {
        byte[] inputAsBytes = input.toString().getBytes();
        // move inwards swapping chars
        for (int i = 0, j = inputAsBytes.length-1; i < j; i++, j--) {
            byte temp = inputAsBytes[i];
            inputAsBytes[i] = inputAsBytes[j];
            inputAsBytes[j] = temp;
        }
        return Integer.valueOf(new String(inputAsBytes, StandardCharsets.UTF_8));
    }

    public Integer reverseIntegerWithCharAtInline(Integer num) {

        char[] array = new char[num.toString().length()];
        String input = num.toString();
        // move inwards swapping chars
        for (int j = input.length()-1; j >= 0; j--) {
            array[(input.length() -1) - j] = input.charAt(j);
        }
        return Integer.valueOf(new String(array));

    }


}
