package patterns.decorator.lambda.decorator;

public class TextDecorators {
    public static String allCaps(String input) {
       return input.toUpperCase();
    }
    public static String concat(String input) {
        return input.concat("this is some random text");
    }
    public static String thisWithThat(String input) {
        return input.replaceAll("this","that");
    }

}
