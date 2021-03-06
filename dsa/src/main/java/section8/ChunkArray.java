package section8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChunkArray {
    public List<List<Integer>> separateListIntoChunks(int[] nums, int chunk) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i += chunk) {
            int endIdx = i + chunk;
            if (endIdx > nums.length) {
                endIdx = nums.length;
            }
            int[] ints = Arrays.copyOfRange(nums, i, endIdx);
            List<Integer> curr = Arrays.stream(ints)
                    .boxed()
                    .collect(Collectors.toList());
            result.add(curr);
        }

        return result;
    }
}
