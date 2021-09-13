package dsa.section11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintingSteps {

    public List<String> executeWithList(int num) {
        List<String> steps= new ArrayList<>();
        for (int i = 1; i <= num; i++) {

            String stepsAndSpaces = String.format("%s%s", "#".repeat(i), (" ").repeat(num - i));
            steps.add(stepsAndSpaces);
        }
        printSteps(steps.toArray(new String[steps.size()]));
        return steps;
    }

    public String[] executeWithArray(int num) {
        String[] result = new String[num];
        for (int i = 0; i < num; i++) {
            int count = i + 1;
            String stepsAndSpaces = String.format("%s%s", "#".repeat(count), (" ").repeat(num  - count));
            result[i]=stepsAndSpaces;
        }
        printSteps(result);
        return result;
    }

    public String[] executeWithArrayNaive(int num) {
        String[] result = new String[num];
        for (int row = 0; row < num; row++) {
            String[] colRes = new String[num];
            for (int col = 0; col < num; col++) {
                if (col <= row) {
                    colRes[col] = "#";
                } else {
                    colRes[col] = " ";
                }
            }
            result[row] = String.join("",colRes);
        }
        printSteps(result);
        return result;
    }

    private void printSteps(String[] steps){
        for (int i = 0; i < steps.length; i++) {
            System.out.println(steps[i]);
        }
    }

}
