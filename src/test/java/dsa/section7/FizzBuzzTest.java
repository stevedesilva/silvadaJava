package dsa.section7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class FizzBuzzTest {

    @Test
    public void shouldReturn1() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] execute = fizzBuzz.execute(1);
        Assertions.assertArrayEquals(new String[]{"1"}, execute);
    }

    @Test
    public void shouldReturn3() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] execute = fizzBuzz.execute(3);
        Assertions.assertArrayEquals(new String[]{"1","2","Fizz"}, execute);
    }
    @Test
    public void shouldReturn5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] execute = fizzBuzz.execute(5);
        Assertions.assertArrayEquals(new String[]{"1","2","Fizz", "4", "Buzz"}, execute);
    }

    @Test
    public void shouldReturn10() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] execute = fizzBuzz.execute(10);
        Assertions.assertArrayEquals(new String[]{"1","2","Fizz", "4", "Buzz","Fizz","7","8","Fizz","Buzz"}, execute);
    }

    @Test
    public void shouldReturn15() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] execute = fizzBuzz.execute(15);
        Assertions.assertArrayEquals(new String[]{"1","2","Fizz", "4", "Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"}, execute);
    }

}