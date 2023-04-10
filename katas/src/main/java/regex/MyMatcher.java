package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMatcher {
    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{3})-");
//        final Matcher matcher = pattern.matcher("this is my 012-000-000-123 test string.");
//        System.out.println("found: " + matcher.find());
//        System.out.println("replace: " + matcher.replaceAll("xxx-xxx-xxx-"));

        Pattern pattern = Pattern.compile("^(\\d+) divided by (\\d+)$");
        final Matcher matcher = pattern.matcher("10 divided by 2");
        if (matcher.find()) {

        }
        System.out.println("found: " + matcher.find());
        System.out.println("update: " + matcher.replaceFirst("$1/$2"));
        System.out.println("update: " + matcher.group(1));
        System.out.println("update: " + matcher.group(2));

    }


}
