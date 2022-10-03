package commonsense.array;

import java.nio.charset.Charset;

public class NeedleInHaystack {
    public static boolean findNeedle(String needle, String haystack) {
        if (needle.isEmpty() || haystack.isEmpty()) {
            throw new IllegalArgumentException("needle and haystack input cannot be empty");
        }
        for (int i = 0; i < haystack.length(); i++) {
            for (int  j = 0; j < needle.length(); j++) {

//                if (needle[j]. != haystack[i]) {
//
//                }
            }
        }
        return false;
    }
}
