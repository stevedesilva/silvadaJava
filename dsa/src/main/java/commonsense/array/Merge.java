package commonsense.array;

public class Merge {

    public int[] mergeArrays(int[] a1, int[] a2) {
        if (a1.length < 1 && a2.length > 1) {
            return a2;
        }
        if (a2.length < 1 && a1.length > 1) {
            return a1;
        }

        int[] result = new int[a1.length + a2.length];

        return result;
    }
}
