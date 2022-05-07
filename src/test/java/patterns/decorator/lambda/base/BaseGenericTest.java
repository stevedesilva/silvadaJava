package patterns.decorator.lambda.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import patterns.decorator.lambda.decorator.NumberDecorators;
import patterns.decorator.lambda.decorator.TextDecorators;

class BaseGenericTest {
    @Test
    public void testBaseGenericWithStringTypes() {
        String result = new BaseGeneric<String>()
                .andThen(TextDecorators::addOne)
                .andThen(TextDecorators::addTwo)
                .andThen(TextDecorators::addThree)
                .apply("Zero");
        Assertions.assertEquals("ZeroOneTwoThree", result);
    }

    @Test
    public void testBaseGenericWithIntegerTypes() {
        Integer result = new BaseGeneric<Integer>()
                .andThen(NumberDecorators::addOne)
                .andThen(NumberDecorators::addTwo)
                .andThen(NumberDecorators::addThree)
                .apply(0);
        Assertions.assertEquals(6,result);
    }

}