package commonsense.array;

public class Palindrome {

    public static boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (Character.toLowerCase(word.charAt(start)) != Character.toLowerCase(word.charAt(end))) {
                return false;
            }
            start++;
            end--;

        }
        return true;
    }
}
