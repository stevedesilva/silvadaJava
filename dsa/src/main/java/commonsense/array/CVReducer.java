package commonsense.array;

import java.util.Arrays;

public class CVReducer {
    public static final String MINIMUM_VALUES_REQUIRED = "minimum of 1 value is required";

    public static String pickResume(String[] resumes) throws IllegalArgumentException {
        if (resumes == null || resumes.length < 1) {
            throw new IllegalArgumentException(MINIMUM_VALUES_REQUIRED);
        }
        boolean top = true;
        while(resumes.length > 1) {
            if (top) {
                final int from = resumes.length / 2;
                final int to = resumes.length;
                resumes = Arrays.copyOfRange(resumes, from, to);
            } else {
                final int to = resumes.length / 2;
                resumes = Arrays.copyOfRange(resumes,0, to);
            }
            // switch
            top = !top;
        }


        return resumes[0];
    }
}
