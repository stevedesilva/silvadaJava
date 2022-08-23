package commonsense.array;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    public int[] findTheIntersection(int[] a,int[] b) {
        List<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] == b[j]) {
                    intersection.add(a[i]);
                }
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
