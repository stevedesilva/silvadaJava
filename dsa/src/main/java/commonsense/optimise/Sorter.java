package commonsense.optimise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sorter {

    public List<Character> sortCharactersInAnyOrder(List<Character> characters) {
        List<Character> sortedList = new ArrayList<>();
        Map<Character, Integer> characterCountMap = new HashMap<>();

        // Count occurrences of each character
        characters.forEach(key -> characterCountMap.put(key, characterCountMap.getOrDefault(key, 0) + 1));
        // Add characters to the sorted list based on their counts
        characterCountMap.forEach((key,value) -> {
            for(int i =0; i < value; i++) {
                sortedList.add(key);
            }
        });

        return sortedList;
    }


}
