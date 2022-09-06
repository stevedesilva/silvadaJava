package commonsense.array;

public class ClothingLabel {
    public String[] markInventory(String[] clothingItems) {
        if (clothingItems.length <= 0) {
            throw new IllegalArgumentException("no input provided");
        }
        final int itemSizes = 5;
        String[] result = new String[clothingItems.length * itemSizes];
        for(int i = 0; i< clothingItems.length; i++) {
            int block = itemSizes * i;
            for(int j = 0; j< itemSizes; j++) {
                final String item = clothingItems[i] + " Size: " + (j + 1);
                result[block+j] = item;
            }
        }
        return result;
    }
}
