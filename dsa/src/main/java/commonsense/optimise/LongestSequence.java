package commonsense.optimise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSequence {

    public static List<Integer> findLongestConsecutiveSequence(int[] nums) {
        // Implementation goes here
        Map numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, true);
        }
        // find the longest sequence
        // if num - 1 is not in the map then it is the start of a sequence
        List<Integer> results = new ArrayList();
        for (int currentNum: nums) {
            List<Integer> tempList = new ArrayList();


            // if start of sequence
            if (!numMap.containsKey(currentNum - 1)) {
                tempList.add(currentNum);
                int nextNum = currentNum + 1;
                while (numMap.containsKey(nextNum)) {
                    tempList.add(nextNum);
                    nextNum++;
                }
            }
            if(tempList.size() > results.size()) {
                results = tempList;
            }
        }

        return results;
    }
}
