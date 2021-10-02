package dsa.section12;


import java.util.ArrayList;
import java.util.List;

public class Pyramid {

    public List<String> buildIterative(int maxLevel) {
        List<String> pyramid = new ArrayList<>();
        int colHalf = maxLevel - 1;
        int colMax = maxLevel + maxLevel - 1;
        for (int currentLevel = 0; currentLevel < maxLevel; currentLevel++) {
            List<String> levelArray = new ArrayList<>();
            for (int col = 0; col < colMax; col++) {
                if (col < colHalf - currentLevel || col > colHalf + currentLevel) {
                    levelArray.add(" ");
                } else {
                    levelArray.add("#");
                }
            }
            pyramid.add(String.join("",levelArray));
        }
        return pyramid;
    }

    public List<String>  buildRecursive(int maxLevel) {
        List<String> pyramid = new ArrayList<>();
        int row = 0;
        int col = 0;
        List<String> newLevelArray = new ArrayList<>();
        buildRecursiveSteps(maxLevel, row, col, newLevelArray, pyramid);
        return pyramid;
    }

    private void buildRecursiveSteps(int maxLevel, int currentLevel, int col, List<String> levelArray, List<String> pyramid) {
        int colHalf = maxLevel - 1;
        int colMax = maxLevel + maxLevel - 1;

        // last level of pyramid
        if (maxLevel == currentLevel) {
            return;
        }

        if (col == colMax  ) {
            // add level to pyramid
            pyramid.add(String.join("", levelArray));
            // new level
            List<String> newLevelArray = new ArrayList<>();
            buildRecursiveSteps(maxLevel, currentLevel + 1, 0, newLevelArray, pyramid);
            return;
        }

        if (col < colHalf - currentLevel || col > colHalf + currentLevel) {
            levelArray.add(" ");
        } else {
            levelArray.add("#");
        }

        buildRecursiveSteps(maxLevel, currentLevel, col + 1, levelArray, pyramid);
    }

}
