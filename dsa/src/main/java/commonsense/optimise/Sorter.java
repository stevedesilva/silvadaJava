package commonsense.optimise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sorter {

    public List<Character> sortCharactersInAnyOrder(List<Character> array) {
        List<Character> sortedList = new ArrayList<>();
        Map<Character, Integer> characterCountMap = new HashMap<>();

        // Count occurrences of each character
        for (Character c : array) {
            characterCountMap.put(c, characterCountMap.getOrDefault(c, 0) + 1);
        }
        // Add characters to the sorted list based on their counts
        for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
            Character character = entry.getKey();
            Integer count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sortedList.add(character);
            }
        }
        return sortedList;
    }
}
