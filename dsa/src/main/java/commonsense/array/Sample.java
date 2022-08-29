package commonsense.array;

import java.util.Objects;

public class Sample {
    public Sample() {
    }

    public static Result getStartMiddleEndElements(int[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("need at least one value in array");
        }
        int start = array[0];
        int middle = array[array.length / 2];
        int end = array[array.length - 1];

        return new Result(start, middle, end);
    }

    public static class Result {
        int start;
        int middle;
        int end;

        public Result(int start, int middle, int end) {
            this.start = start;
            this.middle = middle;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return start == result.start &&
                    middle == result.middle &&
                    end == result.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, middle, end);
        }
    }
}
