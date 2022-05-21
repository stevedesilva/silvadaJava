package decorator.alternativelambda.decorator;

import java.time.LocalDateTime;

public class Loggers {
    public static String withTimeStamp(String message) {
        return LocalDateTime.now() + ":" + message;
    }
    public static String upperCase(String message) {
        return message.toUpperCase();
    }
}
