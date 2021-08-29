package chapter3;

public class Palindrome {

    public boolean isAPalindromeAsBytes(String input) {
        byte[] inputAsBytes = input.getBytes();

        for (int i = 0, j = inputAsBytes.length - 1; i < j; i++, j--) {
            if (inputAsBytes[i] != inputAsBytes[j]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAPalindromeAsChar(String input) {
        for (int i = 0, j = input.length() - 1; i < j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAPalindromeAsArrayList(String input) {
        // reverse
        char[] array = new char[input.length()];
        for (int i = input.length() - 1; i >= 0; i--) {
            array[input.length() - 1 - i] = input.charAt(i);
        }
        // compare with string
        String s = String.valueOf(array);
        return (s.equals(input));
    }

}
