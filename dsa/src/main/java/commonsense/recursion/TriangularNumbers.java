package commonsense.recursion;

public class TriangularNumbers {

    public static int execute(int number) {
        return triangularNumbersRec(number, 0, 0);
    }

    public static int triangularNumbersRec(int number, int index, int prev) {
        if (index > number) {
            return prev;
        }
        int triangularNumbers = prev + index;
        return triangularNumbersRec(number, index + 1, triangularNumbers);
    }

}
