package commonsense.array;

import java.util.List;

public class ClothingLabel {
    public String[][] markInventory(String[] clothingItems) {
        final int itemSizes = 5;
        String[][] result = new String[clothingItems.length][itemSizes];
        for(int i = 0; i< result.length; i++) {
            for(int j = 0; j< itemSizes; j++) {
                final String item = clothingItems[i] + " Size: " + (j + 1);
                result[i][j] = item;
            }
        }
        return result;
    }
}
