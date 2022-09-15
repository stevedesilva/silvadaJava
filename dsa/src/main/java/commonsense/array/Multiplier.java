package commonsense.array;

import java.util.ArrayList;
import java.util.List;

public class Multiplier {

    public static int[] findTheProduct(int[] array) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i < array.length; i++) {
            for (int j=i+1; j < array.length; j++) {
                result.add(array[i]*array[j]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
