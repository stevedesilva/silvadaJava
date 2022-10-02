package commonsense.array;

public class Merge {

    public int[] mergeArrays(int[] a1, int[] a2) {

        int[] result = new int[a1.length + a2.length];
        int idx = 0, i = 0, j = 0;
        while (i < a1.length || j < a2.length) {
            if (i < a1.length && j >= a2.length) {
                result[idx] = a1[i];
                i++;
            } else if (j < a2.length && i >= a1.length) {
                result[idx] = a2[j];
                j++;
            } else if (a1[i] <= a2[j]) {
                result[idx] = a1[i];
                i++;
            } else {
                result[idx] = a2[j];
                j++;
            }
            idx++;
        }
        return result;
    }
}
