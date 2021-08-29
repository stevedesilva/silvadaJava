package chapter4.integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversalTest {

    @Test
    public void shouldReturnOneInteger() {
        Reversal reversal = new Reversal();
        assertEquals(1, reversal.reverseIntegerWithBuilder(1));
        assertEquals(1, reversal.reverseIntegerWithCharAt(1));
        assertEquals(1, reversal.reverseIntegerWithBytes(1));
        assertEquals(1, reversal.reverseIntegerWithCharAtInline(1));

    }

    @Test
    public void shouldReturnTwoInteger() {
        Reversal reversal = new Reversal();
        assertEquals(21, reversal.reverseIntegerWithBuilder(12));
        assertEquals(21, reversal.reverseIntegerWithCharAt(12));
        assertEquals(21, reversal.reverseIntegerWithBytes(12));
        assertEquals(21, reversal.reverseIntegerWithCharAtInline(12));
    }

    @Test
    public void shouldReturnThreeInteger() {
        Reversal reversal = new Reversal();
        assertEquals(321, reversal.reverseIntegerWithBuilder(123));
        assertEquals(321, reversal.reverseIntegerWithCharAt(123));
        assertEquals(321, reversal.reverseIntegerWithBytes(123));
        assertEquals(321, reversal.reverseIntegerWithCharAtInline(123));
    }

    @Test
    public void shouldReturnFourInteger() {
        Reversal reversal = new Reversal();
        assertEquals(4321, reversal.reverseIntegerWithBuilder(1234));
        assertEquals(4321, reversal.reverseIntegerWithCharAt(1234));
        assertEquals(4321, reversal.reverseIntegerWithBytes(1234));
        assertEquals(4321, reversal.reverseIntegerWithCharAtInline(1234));
    }

}