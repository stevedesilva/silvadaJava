package decorator.lambda.decorator;

import decorator.lambda.base.BaseText;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TextDecoratorsTest {
    @Test
    public void testDecoratorRunnerBaseText() {
        final String result = new BaseText()
                .apply("this is some random textfile");
        Assertions.assertEquals("this is some random textfile", result);
    }

    @Test
    public void testDecoratorRunnerAllCaps() {
        final String result = new BaseText()
                .andThen(TextDecorators::allCaps)
                .apply("this is some random textfile");
        Assertions.assertEquals("THIS IS SOME RANDOM TEXTFILE", result);
    }

    @Test
    public void testDecoratorReplaceThisWithThat() {
        final String result = new BaseText()
                .andThen(TextDecorators::thisWithThat)
                .apply("this is some random textfile");
        Assertions.assertEquals("that is some random textfile", result);
    }

    @Test
    public void testDecoratorStringConcat() {
        final String result = new BaseText()
                .andThen(TextDecorators::concat)
                .apply("this is some random textfile");
        Assertions.assertEquals("this is some random textfilethis is some random textfile", result);

    }

    @Test
    public void testDecoratorRunnerReplaceThisWithThat() {
        final String result = new BaseText()
                .andThen(TextDecorators::allCaps)
                .andThen(TextDecorators::concat)
                .andThen(TextDecorators::thisWithThat)
                .apply("this is some random textfile");
        Assertions.assertEquals("THIS IS SOME RANDOM TEXTFILEthat is some random textfile", result);
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