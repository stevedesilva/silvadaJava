package commonsense.array;

public class Sample {
    public static class Result {
        int start;
        int middle;
        int end;

        public Result(int start, int middle, int end) {
            this.start = start;
            this.middle = middle;
            this.end = end;
        }
    }

    public static Result arraySample(int[] array) {
        if (array.length < 1) {
            return new Result(0, 0, 0);
        }
        int start = array[0];
        int middle = array[array.length / 2];
        int end = array[array.length - 1];

        return new Result(start, middle, end);
    }
}
