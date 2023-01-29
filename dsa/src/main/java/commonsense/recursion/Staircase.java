package commonsense.recursion;

import java.util.HashMap;
import java.util.Map;

public class Staircase {
    public static int countNumberOfPathsAlt(int steps) {
        // 9 = 8r + 7r + 6r =
        // 8 = 7r(44) + 6r(24) + 5r(13) = 81
        // 7 = 6r + 5r + 4r  = 24 + 13 + 7 = 44
        // 6 = 5r + 4r + 3(4) = 13 + 7 + 4 = 24
        // 5 = 4r + 3(4) + 2(2) = 7 + 4 + 2 = 13
        // 4 = 3(4) + 2(2) + 1(1) = 7
        // 3 = 4
        // 2 = 2
        // 1 = 1
        if (steps < 0) return 0;
        if (steps == 1 || steps == 0) return 1;

        /*
        // 0 = 0
        // 1 = 1
		// 2 = 11, 2
		// 3 = 111, 12, 21, 3
		//
		// 4 = 1111, 112, 121, 211, 22, 31, 13
		// 5 = 11111, 1112, 1121, 1211, 2111, 221, 212, 122, 311, 131, 113, 32, 23
		// 6 = 111111, 11112, 11121, 11211, 12111, 21111, 2211,2121,2112,222,231,213, 3111,1311,1131,1113, 321,312, 33
         */
        return countNumberOfPathsAlt(steps -1) + countNumberOfPathsAlt( steps - 2) + countNumberOfPathsAlt(steps - 3);
    }
    public static int countNumberOfPaths(int steps) {
        // 9 = 8r + 7r + 6r =
        // 8 = 7r(44) + 6r(24) + 5r(13) = 81
        // 7 = 6r + 5r + 4r  = 24 + 13 + 7 = 44
        // 6 = 5r + 4r + 3(4) = 13 + 7 + 4 = 24
        // 5 = 4r + 3(4) + 2(2) = 7 + 4 + 2 = 13
        // 4 = 3(4) + 2(2) + 1(1) = 7
        // 3 = 4
        // 2 = 2
        // 1 = 1
        if (steps <= 0) return 0;
        if (steps == 1) return 1;
        if (steps == 2) return 2;
        if (steps == 3) return 4;
        /*
        // 0 = 0
        // 1 = 1
		// 2 = 11, 2
		// 3 = 111, 12, 21, 3
		//
		// 4 = 1111, 112, 121, 211, 22, 31, 13
		// 5 = 11111, 1112, 1121, 1211, 2111, 221, 212, 122, 311, 131, 113, 32, 23
		// 6 = 111111, 11112, 11121, 11211, 12111, 21111, 2211,2121,2112,222,231,213, 3111,1311,1131,1113, 321,312, 33
         */
        return countNumberOfPaths(steps -1) + countNumberOfPaths( steps - 2) + countNumberOfPaths(steps - 3);
    }

    public static int countNumberOfPathsForOneStep(int steps) {

        // 3 = 4
        // 2 = 2
        // 1 = 1
        if (steps <= 0) return 0;
        if (steps == 1) return 1;
        return 1 + countNumberOfPathsForOneStep(steps -1);
    }

    public static int countNumberOfPathsForTwoStep(int steps) {
        // 5 = 11111, 1112, 1121, 1211, 2111, 122, 212, 221,
        // 4 = 1111, 112, 121, 211, 22
        // 3 = 111, 21, 12
        // 2 = 11,2
        // 1 = 1
        if (steps <= 0) return 0;
        if (steps == 1) return 1;
        if (steps == 2) return 2;
        // 5 (4r)5 + (3r)3
        // 4 (3r)3 + (2r)2 = 5
        // 3 (2r)2 + (1r)1 = 3
        // 2
        // 1
        return countNumberOfPathsForTwoStep(steps -1) + countNumberOfPathsForTwoStep(steps -2);
    }

    public static int countNumberOfPathsWithMemoization(int steps) {


        /*
        // 0 = 0
        // 1 = 1
		// 2 = 11, 2
		// 3 = 111, 12, 21, 3
		//
		// 4 = 1111, 112, 121, 211, 22, 31, 13
		// 5 = 11111, 1112, 1121, 1211, 2111, 221, 212, 122, 311, 131, 113, 32, 23
		// 6 = 111111, 11112, 11121, 11211, 12111, 21111, 2211,2121,2112,222,231,213, 3111,1311,1131,1113, 321,312, 33
         */
        // 9 = 8r + 7r + 6r =
        // 8 = 7r(44) + 6r(24) + 5r(13) = 81
        // 7 = 6r + 5r + 4r  = 24 + 13 + 7 = 44
        // 6 = 5r + 4r + 3(4) = 13 + 7 + 4 = 24
        // 5 = 4r + 3(4) + 2(2) = 7 + 4 + 2 = 13
        // 4 = 3(4) + 2(2) + 1(1) = 7
        // 3 = 4
        // 2 = 2
        // 1 = 1
        Map<Integer,Integer> cache = new HashMap<>();
        return countNumberOfPathsWithMemoizationRec(steps -1, cache) + countNumberOfPathsWithMemoizationRec( steps - 2, cache) + countNumberOfPathsWithMemoizationRec(steps - 3, cache);
    }
    private static int countNumberOfPathsWithMemoizationRec(int steps, Map<Integer,Integer> cache) {
        if (steps < 0) return 0;
        if (steps == 1 || steps == 0) return 1;
        if (!cache.containsKey(steps)) {
            Integer result = countNumberOfPathsWithMemoizationRec(steps -1, cache) + countNumberOfPathsWithMemoizationRec( steps - 2, cache) + countNumberOfPathsWithMemoizationRec(steps - 3, cache);
            cache.put(steps,result);
        }
        return cache.get(steps);

    }
}
