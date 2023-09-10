package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherV1 {

    public static boolean isMatched(String regex, String valueToMatch) {
        final Pattern compile = Pattern.compile(regex);
        final Matcher matcher = compile.matcher(valueToMatch);
        return matcher.find();
    }

    public static void isGroup(String regex, String value) {
        Pattern regexPattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
        final Matcher matcher = regexPattern.matcher(value);
        matcher.group(1);
    }


}
