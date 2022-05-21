package decorator.lambda.decorator;

public class TextDecorators {
    public static String allCaps(String input) {
       return input.toUpperCase();
    }
    public static String concat(String input) {
        return input.concat("this is some random textfile");
    }
    public static String thisWithThat(String input) {
        return input.replaceAll("this","that");
    }

    public static String addOne(String input) {
        return input.concat("One");
    }
    public static String addTwo(String input) {
        return input.concat("Two");
    }
    public static String addThree(String input) {
        return input.concat("Three");
    }

}
