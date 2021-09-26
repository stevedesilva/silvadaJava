package dsa.section12;


import java.util.ArrayList;
import java.util.List;

public class Pyramid {

    public List<String> build(int level) {
        List<String> result = new ArrayList<>();
        int colHalf = level - 1;
        int colMax = level + level - 1;
        for (int row = 0; row < level; row++) {
            List<String> rowArray = new ArrayList<>();
            for (int col = 0; col < colMax; col++) {
                if (col < colHalf - row || col > colHalf + row) {
                    rowArray.add(" ");
                } else {
                    rowArray.add("#");
                }
            }
            result.add(String.join("",rowArray));
        }
        return result;
    }

}
