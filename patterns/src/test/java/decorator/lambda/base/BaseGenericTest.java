package decorator.lambda.base;

import decorator.lambda.decorator.NumberDecorators;
import decorator.lambda.decorator.TextDecorators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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
        Assertions.assertEquals(Integer.valueOf(6),result);
    }

//    @Test
//    public void testBaseGenericWithBothIntegerStringTypes() {
//        MyBaseTest result = new MyBaseTest();
//        result.execute("Test message");
//        final Object o = result.get();
//        System.out.println(o);
//
////                .andThen(NumberDecorators::addOne)
////                .andThen(NumberDecorators::addTwo)
////                .andThen(NumberDecorators::addThree)
////                .andThen(TextDecorators::addOne)
////                .andThen(TextDecorators::addTwo)
////                .andThen(TextDecorators::addThree)
////                .apply(0);
////        Assertions.assertEquals(6,result);
//    }

}