package dsa.chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversalTest {

    @Test
    public void shouldReturnEmptyString() {
        Reversal reversal = new Reversal();
        assertEquals("", reversal.reverseWithCharAt(""));
        assertEquals("", reversal.reverseWithStringBuilder(""));
        assertEquals("", reversal.reverseWithBytes(""));
        assertEquals("", reversal.reverseWithCharAtInline(""));
    }

    @Test
    public void shouldReturnReversedString3Letters() {
        Reversal reversal = new Reversal();
        assertEquals("cba", reversal.reverseWithCharAt("abc"));
        assertEquals("cba", reversal.reverseWithStringBuilder("abc"));
        assertEquals("cba", reversal.reverseWithBytes("abc"));
        assertEquals("cba", reversal.reverseWithCharAtInline("abc"));
    }

    @Test
    public void shouldReturnReversedStringFourLetters() {
        Reversal reversal = new Reversal();
        assertEquals("dcba", reversal.reverseWithCharAt("abcd"));
        assertEquals("dcba", reversal.reverseWithStringBuilder("abcd"));
        assertEquals("dcba", reversal.reverseWithBytes("abcd"));
        assertEquals("dcba", reversal.reverseWithCharAtInline("abcd"));
    }

    @Test
    public void shouldReturnReversedStringFiveLetters() {
        Reversal reversal = new Reversal();
        assertEquals("edcba", reversal.reverseWithCharAt("abcde"));
        assertEquals("edcba", reversal.reverseWithStringBuilder("abcde"));
        assertEquals("edcba", reversal.reverseWithBytes("abcde"));
        assertEquals("edcba", reversal.reverseWithCharAtInline("abcde"));
    }
}