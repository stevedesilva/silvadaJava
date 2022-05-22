package section11;

import java.util.ArrayList;
import java.util.List;

public class PrintingSteps {

    public List<String> executeWithListUsingStringFormat(int num) {
        List<String> steps = new ArrayList<>();
        for (int i = 1; i <= num; i++) {

            String stepsAndSpaces = String.format("%s%s", "#".repeat(i), (" ").repeat(num - i));
            steps.add(stepsAndSpaces);
        }
        printSteps(steps.toArray(new String[steps.size()]));
        return steps;
    }

    public String[] executeWithArrayUsingStringFormat(int num) {
        String[] result = new String[num];
        for (int i = 0; i < num; i++) {
            int count = i + 1;
            String stepsAndSpaces = String.format("%s%s", "#".repeat(count), (" ").repeat(num - count));
            result[i] = stepsAndSpaces;
        }
        printSteps(result);
        return result;
    }

    public String[] executeWithStringArrayUsingNestedForLoops(int maxLevel) {
        String[] pyramid = new String[maxLevel];
        for (int currentLevel = 0; currentLevel < maxLevel; currentLevel++) {
            String[] colRes = new String[maxLevel];
            for (int col = 0; col < maxLevel; col++) {
                if (col <= currentLevel) {
                    colRes[col] = "#";
                } else {
                    colRes[col] = " ";
                }
            }
            pyramid[currentLevel] = String.join("", colRes);
        }
        printSteps(pyramid);
        return pyramid;
    }

    public String[] executeWithCharArrayUsingNestedForLoops(int maxLevel) {
        String[] pyramid = new String[maxLevel];
        for (int currentLevel = 0; currentLevel < maxLevel; currentLevel++) {
            char[] colRes = new char[maxLevel];
            for (int col = 0; col < maxLevel; col++) {
                if (col <= currentLevel) {
                    colRes[col] = '#';
                } else {
                    colRes[col] = ' ';
                }
            }
            pyramid[currentLevel] =  String.valueOf(colRes);
        }
        printSteps(pyramid);
        return pyramid;
    }

    private void printSteps(String[] steps) {
        for (int i = 0; i < steps.length; i++) {
            System.out.println(steps[i]);
        }
    }

    public void executeRecursiveSteps(int maxLevel, int currentLevel, int col, String[] colRes, String[] pyramid) {
        // last level of pyramid
        if (maxLevel == currentLevel) {
            return;
        }
        // last column of the level
        if (maxLevel == col) {
            // add level to pyramid
            pyramid[currentLevel] = String.join("", colRes);

            // reset for next level
            String[] newColRes = new String[maxLevel];
            executeRecursiveSteps(maxLevel, currentLevel + 1, 0, newColRes, pyramid);
            return;
        }
        // add for each column
        if (col <= currentLevel) {
            colRes[col] = "#";
        } else {
            colRes[col] = " ";
        }
        // increment column
        executeRecursiveSteps(maxLevel, currentLevel, col + 1, colRes, pyramid);
    }

    public String[] executeRecursive(int num) {
        String[] result = new String[num];
        int row = 0;
        int col = 0;
        String[] colRes = new String[num];
        executeRecursiveSteps(num, row, col, colRes, result);
        return result;
    }

}
