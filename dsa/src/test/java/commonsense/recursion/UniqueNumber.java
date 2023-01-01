package commonsense.recursion;

public class UniqueNumber {
    public static int findUniqueNumbers(int rows, int columns) {
        if (rows == 1 || columns == 1) {
            return 1;
        }
        return findUniqueNumbers(rows - 1, columns) + findUniqueNumbers( rows,columns-1);
    }
}

