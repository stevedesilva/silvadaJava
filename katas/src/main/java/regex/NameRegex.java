package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameRegex {

    public static void main(String[] args) {
        System.out.println(isValidName("Steve Jobs"));
        System.out.println(isValidName("Steve DeSilva"));
    }


    private static boolean isValidName(String name) {
        final String regex = "^Steve Jobs$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(name);
        return matcher.find();

    }


}
