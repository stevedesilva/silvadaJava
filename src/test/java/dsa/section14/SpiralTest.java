package dsa.section14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiralTest {

    /*
     @ParameterizedTest
    @CsvSource({"A, 1", "a,1", "Hi there!,3", "Why?,0", "Why do you ask?,4", "aa aa aa e e v?,8"})
    public void shouldReturnVowels(String input, int expected) {
        Assertions.assertEquals(expected, new Vowel().CalculateNumberOfVowelsRegex(input));
        Assertions.assertEquals(expected, new Vowel().CalculateNumberOfVowelsIterativeUsingMap(input));
    }
     */

    @Test
    public void shouldReturnOneSpiral() {
        int[][] expected = new int[][]{
                {1}
        };
        Assertions.assertArrayEquals(expected, new Spiral().create(1));
    }

    @Test
    public void shouldReturnTwoSpiral() {
        int[][] expected = new int[][]{
                {1, 2},
                {4, 3},
        };
        Assertions.assertArrayEquals(expected, new Spiral().create(2));
    }

    @Test
    public void shouldReturnThreeSpiral() {
        int[][] expected = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5},
        };
        Assertions.assertArrayEquals(expected, new Spiral().create(3));
    }

    @Test
    public void shouldReturnFourSpiral() {
        int[][] expected = new int[][]{
                { 1,  2,  3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10,  9,  8, 7},
        };
        Assertions.assertArrayEquals(expected, new Spiral().create(4));
    }

    @Test
    public void shouldReturnFiveSpiral() {
        int[][] expected = new int[][]{
                { 1,  2,  3,  4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
        Assertions.assertArrayEquals(expected, new Spiral().create(5));
    }

}