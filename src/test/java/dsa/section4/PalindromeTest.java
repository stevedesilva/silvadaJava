package dsa.section4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeTest {

    @Test
    public void singleLetterShouldReturnTrue() {
        Palindrome palindrome = new Palindrome();
        Assertions.assertTrue(palindrome.isAPalindromeAsChar("a"));
        Assertions.assertTrue(palindrome.isAPalindromeAsBytes("a"));
        Assertions.assertTrue(palindrome.isAPalindromeAsArrayList("a"));
    }

    @Test
    public void twoLettersShouldReturnTrue() {
        Palindrome palindrome = new Palindrome();
        Assertions.assertTrue(palindrome.isAPalindromeAsChar("aa"));
        Assertions.assertTrue(palindrome.isAPalindromeAsBytes("aa"));
        Assertions.assertTrue(palindrome.isAPalindromeAsArrayList("aa"));
    }

    @Test
    public void twoLettersShouldReturnFalse() {
        Palindrome palindrome = new Palindrome();
        Assertions.assertFalse(palindrome.isAPalindromeAsChar("ab"));
        Assertions.assertFalse(palindrome.isAPalindromeAsBytes("ab"));
        Assertions.assertFalse(palindrome.isAPalindromeAsArrayList("ab"));
    }

    @Test
    public void threeLettersShouldReturnTrue() {
        Palindrome palindrome = new Palindrome();
        Assertions.assertTrue(palindrome.isAPalindromeAsChar("aba"));
        Assertions.assertTrue(palindrome.isAPalindromeAsBytes("aba"));
        Assertions.assertTrue(palindrome.isAPalindromeAsArrayList("aba"));
    }

    @Test
    public void threeLettersShouldReturnFalse() {
        Palindrome palindrome = new Palindrome();
        Assertions.assertFalse(palindrome.isAPalindromeAsChar("abc"));
        Assertions.assertFalse(palindrome.isAPalindromeAsBytes("abc"));
        Assertions.assertFalse(palindrome.isAPalindromeAsArrayList("abc"));
    }

    @Test
    public void fourLettersShouldReturnTrue() {
        Palindrome palindrome = new Palindrome();
        Assertions.assertTrue(palindrome.isAPalindromeAsChar("abba"));
        Assertions.assertTrue(palindrome.isAPalindromeAsBytes("abba"));
        Assertions.assertTrue(palindrome.isAPalindromeAsArrayList("abba"));
    }

    @Test
    public void fourLettersShouldReturnFalse() {
        Palindrome palindrome = new Palindrome();
        Assertions.assertFalse(palindrome.isAPalindromeAsChar("abcd"));
        Assertions.assertFalse(palindrome.isAPalindromeAsBytes("abcd"));
        Assertions.assertFalse(palindrome.isAPalindromeAsArrayList("abcd"));
    }

    @Test
    public void fiveLettersShouldReturnTrue() {
        Palindrome palindrome = new Palindrome();
        Assertions.assertTrue(palindrome.isAPalindromeAsChar("abcba"));
        Assertions.assertTrue(palindrome.isAPalindromeAsBytes("abcba"));
        Assertions.assertTrue(palindrome.isAPalindromeAsArrayList("abcba"));
    }

    @Test
    public void fiveLettersShouldReturnFalse() {
        Palindrome palindrome = new Palindrome();
        Assertions.assertFalse(palindrome.isAPalindromeAsChar("abcde"));
        Assertions.assertFalse(palindrome.isAPalindromeAsBytes("abcde"));
        Assertions.assertFalse(palindrome.isAPalindromeAsArrayList("abcde"));
    }

}