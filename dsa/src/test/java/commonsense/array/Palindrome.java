package commonsense.array;

public class Palindrome {

    public static boolean isPalindromeUsingWhileLoop(String word) {
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

    public static boolean isPalindromeUsingForLoop(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++,j--) {
            if (Character.toLowerCase(word.charAt(i)) != Character.toLowerCase(word.charAt(j))) {
                return false;
            }
        }
        return true;
    }


}
