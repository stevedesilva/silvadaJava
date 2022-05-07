package patterns.decorator.lambda.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import patterns.decorator.lambda.base.BaseText;


class TextDecoratorsTest {
    @Test
    public void testDecoratorRunnerBaseText() {
        final String result = new BaseText()
                .apply("this is some random text");
        Assertions.assertEquals("this is some random text", result);
    }

    @Test
    public void testDecoratorRunnerAllCaps() {
        final String result = new BaseText()
                .andThen(TextDecorators::allCaps)
                .apply("this is some random text");
        Assertions.assertEquals("THIS IS SOME RANDOM TEXT", result);
    }

    @Test
    public void testDecoratorReplaceThisWithThat() {
        final String result = new BaseText()
                .andThen(TextDecorators::thisWithThat)
                .apply("this is some random text");
        Assertions.assertEquals("that is some random text", result);
    }

    @Test
    public void testDecoratorStringConcat() {
        final String result = new BaseText()
                .andThen(TextDecorators::concat)
                .apply("this is some random text");
        Assertions.assertEquals("this is some random textthis is some random text", result);

    }

    @Test
    public void testDecoratorRunnerReplaceThisWithThat() {
        final String result = new BaseText()
                .andThen(TextDecorators::allCaps)
                .andThen(TextDecorators::concat)
                .andThen(TextDecorators::thisWithThat)
                .apply("this is some random text");
        Assertions.assertEquals("THIS IS SOME RANDOM TEXTthat is some random text", result);
    }

    @Test
    public void testDecoratorRunnerOneTwoThree() {
        final String result = new BaseText()
                .andThen(TextDecorators::addOne)
                .andThen(TextDecorators::addTwo)
                .andThen(TextDecorators::addThree)
                .apply("Zero");
        Assertions.assertEquals("ZeroOneTwoThree", result);
    }

    @Test
    public void testDecoratorRunnerOneTwoThree() {
        final String result = new BaseText()
                .andThen(TextDecorators::addOne)
                .andThen(TextDecorators::addTwo)
                .andThen(TextDecorators::addThree)
                .apply("Zero");
        Assertions.assertEquals("ZeroOneTwoThree", result);
    }
}