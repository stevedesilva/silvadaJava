package decorator.alternativelambda.decorator;

import decorator.alternativelambda.Logger;
import decorator.alternativelambda.base.SimpleLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LoggersTest {
    @Test
    public void testDecoratorLoggerToUppercase(){
        Logger logger = new SimpleLogger();
        Function<String,String> decorators = Stream.<Function<String,String>>of(Loggers::upperCase)
                .reduce(Function.identity(),Function::andThen);

        String result = logger.log(decorators.apply("Test Message"));
        Assertions.assertEquals("TEST MESSAGE", result);
    }

    @Test
    public void testLoggerTimestamp(){
        Logger logger = new SimpleLogger();
        Function<String,String> decorators = Stream.<Function<String,String>>of(Loggers::withTimeStamp)
                .reduce(Function.identity(),Function::andThen);

        final String result = logger.log(decorators.apply("Test Message"));
        final String dateAsStr = result.split(":Test")[0];
        assertDoesNotThrow(() -> {
            LocalDateTime.parse(dateAsStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        });

        assertTrue(result.contains(":Test Message"));
    }

    @Test
    public void testLoggerCombination(){
        Logger logger = new SimpleLogger();
        Function<String,String> decorators = Stream.<Function<String,String>>of(Loggers::withTimeStamp,Loggers::upperCase)
                .reduce(Function.identity(),Function::andThen);

        final String result = logger.log(decorators.apply("Test Message"));
        final String dateAsStr = result.split(":TEST")[0];
        assertDoesNotThrow(() -> {
            LocalDateTime.parse(dateAsStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        });

        assertTrue(result.contains(":TEST MESSAGE"));
    }

}