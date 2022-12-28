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

    public static int executeAlt(int number) {
        // index + position
        // 1(+0), 2(+1), 3(+3), 4(+6), 5(+10)
        if (number <= 1) {
            return number;
        }
        return number + executeAlt(number - 1);
    }

}
