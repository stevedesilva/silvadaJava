package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameRegex {

    public static void main(String[] args) {
        System.out.println(isValidName("Steve Jobs"));
    }


    public static boolean isValidName(String name) {
        final Pattern compile = Pattern.compile("^[A-Z][a-z]+( [A-Z][a-z]+)*$");
        final Matcher matcher = compile.matcher(name);
        return matcher.find();
    }
}
