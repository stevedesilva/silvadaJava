package commonsense.array;

import java.util.ArrayList;
import java.util.List;

public class WordBuilder {
    public List<String> buildTwoLevelWordArray(char[] array) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j= 0; j < array.length; j++) {
                if (i != j) {
                    result.add(String.valueOf(array[i]) + array[j]);
                }
            }
        }
        return result;
    }

    public  List<String> buildThirdLevelWordArray(char[] array) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j= 0; j < array.length; j++) {
                for (int k= 0; k < array.length; k++) {
                    if (i != j && j != k && k != i) {
                        result.add(array[i] + String.valueOf(array[j])  + array[k]);
                    }
                }
            }
        }
        return result;
    }
}
