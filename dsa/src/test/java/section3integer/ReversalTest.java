package section3integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReversalTest {

    @Test
    public void shouldReturnOneInteger() {
        Reversal reversal = new Reversal();
        assertEquals(Integer.valueOf(1), reversal.reverseIntegerWithBuilder(1));
        assertEquals(Integer.valueOf(1), reversal.reverseIntegerWithCharAt(1));
        assertEquals(Integer.valueOf(1), reversal.reverseIntegerWithBytes(1));
        assertEquals(Integer.valueOf(1), reversal.reverseIntegerWithCharAtInline(1));

    }

    @Test
    public void shouldReturnTwoInteger() {
        Reversal reversal = new Reversal();
        assertEquals(Integer.valueOf(21), reversal.reverseIntegerWithBuilder(12));
        assertEquals(Integer.valueOf(21), reversal.reverseIntegerWithCharAt(12));
        assertEquals(Integer.valueOf(21), reversal.reverseIntegerWithBytes(12));
        assertEquals(Integer.valueOf(21), reversal.reverseIntegerWithCharAtInline(12));
    }

    @Test
    public void shouldReturnThreeInteger() {
        Reversal reversal = new Reversal();
        final Integer input = 321;
        assertEquals(input, reversal.reverseIntegerWithBuilder(123));
        assertEquals(input, reversal.reverseIntegerWithCharAt(123));
        assertEquals(input, reversal.reverseIntegerWithBytes(123));
        assertEquals(input, reversal.reverseIntegerWithCharAtInline(123));
    }

    @Test
    public void shouldReturnFourInteger() {
        Reversal reversal = new Reversal();
        final Integer expected = Integer.valueOf(4321);
        assertEquals(expected, reversal.reverseIntegerWithBuilder(1234));
        assertEquals(expected, reversal.reverseIntegerWithCharAt(1234));
        assertEquals(expected, reversal.reverseIntegerWithBytes(1234));
        assertEquals(expected, reversal.reverseIntegerWithCharAtInline(1234));
    }

}