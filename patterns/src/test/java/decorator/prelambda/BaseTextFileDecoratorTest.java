package decorator.prelambda;

import decorator.prelambda.base.BaseText;
import decorator.prelambda.decorator.AllCaps;
import decorator.prelambda.decorator.ReplaceThisWithThat;
import decorator.prelambda.decorator.StringConcat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class BaseTextFileDecoratorTest {
    @Test
    public void testDecoratorRunnerBaseText() {
        Text baseText = new BaseText();
        final String result = baseText.format("this is some random text");
        Assertions.assertEquals("this is some random text", result);
    }

    @Test
    public void testDecoratorRunnerAllCaps() {
        Text decorator = new AllCaps(new BaseText());

        final String result = decorator.format("this is some random text");
        Assertions.assertEquals("THIS IS SOME RANDOM TEXT", result);
    }

    @Test
    public void testDecoratorReplaceThisWithThat() {
        Text decorator = new ReplaceThisWithThat(new BaseText());

        final String result = decorator.format("this is some random text");
        Assertions.assertEquals("that is some random text", result);
    }

    @Test
    public void testDecoratorStringConcat() {
        Text decorator = new StringConcat(new BaseText());

        final String result = decorator.format("this is some random text");
        Assertions.assertEquals("this is some random textthis is some random text", result);
    }

    @Test
    public void testDecoratorRunnerReplaceThisWithThat() {
        Text decorator = new ReplaceThisWithThat(new StringConcat(new AllCaps(new BaseText())));

        final String result = decorator.format("this is some random text");
        Assertions.assertEquals("THIS IS SOME RANDOM TEXTthat is some random text", result);
    }

}