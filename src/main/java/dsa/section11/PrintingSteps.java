package dsa.section11;

import java.util.ArrayList;
import java.util.List;

public class PrintingSteps {


    public List<String> executeWithList(int num) {
        List<String> steps= new ArrayList<>();
        for (int i = 1; i <= num; i++) {

            String stepsAndSpaces = String.format("%s%s\n", "#".repeat(i), (" ").repeat(num - i));
            steps.add(stepsAndSpaces);
            System.out.print(stepsAndSpaces);

        }
        return steps;
    }

    public String[] executeWithArray(int num) {
        String[] result = new String[num];
        for (int i = 0; i < num; i++) {
            int count = i + 1;
            String stepsAndSpaces = String.format("%s%s\n", "#".repeat(count), (" ").repeat(num  - count));
            result[i]=stepsAndSpaces;
            System.out.print(stepsAndSpaces);
        }
        return result;
    }

}
