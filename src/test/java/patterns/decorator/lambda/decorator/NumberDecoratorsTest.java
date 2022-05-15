package patterns.decorator.lambda.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import patterns.decorator.lambda.base.BaseNumber;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class NumberDecoratorsTest {
    @Test
    public void testNumberDecoratorsAddOneStartWithIdentity(){

       //  Function.<Integer>identity() same as this       Function<Integer,Integer> baseNumber = (i) -> i;
        final Integer result =  Function.<Integer>identity()
                .andThen(NumberDecorators::addOne)
                .apply(0);
        Assertions.assertEquals(Integer.valueOf(1),result);
    }

    @Test
    public void testNumberDecoratorsIdentity(){
        //  Function.<Integer>identity() same as this       Function<Integer,Integer> baseNumber = (i) -> i;
        Function<Integer,Integer> baseNumber = (i) -> i;
        final Integer result =  baseNumber
                .apply(10);
        Assertions.assertEquals(Integer.valueOf(10),result);

        final Integer idResult =  Function.<Integer>identity()
                .apply(10);
        Assertions.assertEquals(Integer.valueOf(10),idResult);
    }

    @Test
    public void testNumberDecoratorsAddOne(){
        BaseNumber baseNumber = new BaseNumber();

        final Integer result = baseNumber.andThen(NumberDecorators::addOne)
                .apply(0);
        Assertions.assertEquals(Integer.valueOf(1),result);
    }
    @Test
    public void testNumberDecoratorsAddTwo(){
        BaseNumber baseNumber = new BaseNumber();

        final Integer result = baseNumber.andThen(NumberDecorators::addTwo)
                .apply(0);
        Assertions.assertEquals(Integer.valueOf(2),result);
    }
    @Test
    public void testNumberDecoratorsAddThree(){
        BaseNumber baseNumber = new BaseNumber();

        final Integer result = baseNumber.andThen(NumberDecorators::addThree)
                .apply(0);
        Assertions.assertEquals(Integer.valueOf(3),result);
    }

//    @Test
//    public void testNumberDecorators(){
//        BaseNumber baseNumber = new BaseNumber();
//
//        final Integer result = baseNumber.andThen(NumberDecorators::addOne)
//                .andThen(NumberDecorators::addTwo)
//                .andThen(NumberDecorators::addThree)
//                .apply(0);
//
//        Assertions.assertEquals(6,result);
////       baseNumber.andThen((n) -> n+2).apply(1);
////       baseNumber.andThen((x) -> NumberDecorators.addTwo(x)).apply(1); ??TODO
//    }
}