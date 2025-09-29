package commonsense.optimise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSequence {

    public static int[] findLongestConsecutiveSequence(int[] nums) {
        // Implementation goes here
        Map numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, true);
        }
        // find the longest sequence
        // if num - 1 is not in the map then it is the start of a sequence
        List result = new ArrayList();
        for (int num: nums) {

            if (!numMap.containsKey(num + 1)) {
                // start of sequence

            }
        }

        //
        return null;
    }
}
