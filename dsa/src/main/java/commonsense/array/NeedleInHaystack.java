package commonsense.array;

public class NeedleInHaystack {
    public static boolean findNeedle(String needle, String haystack) throws IllegalArgumentException {
        if (needle.isEmpty() || haystack.isEmpty()) {
            throw new IllegalArgumentException("needle and haystack input cannot be empty");
        }
        boolean foundNeedle = false;
        for (int i = 0; i < haystack.length(); i++) {
            for (int  j = 0; j < needle.length(); j++) {
                foundNeedle = true;
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    foundNeedle = false;
                    break;
                }
            }
            if (foundNeedle) {
                // return early since we have found our needle
                break;
            }
        }
        return foundNeedle;
    }
}
