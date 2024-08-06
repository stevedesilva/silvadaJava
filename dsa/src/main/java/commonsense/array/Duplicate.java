package commonsense.array;

public class Duplicate {
    public boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i]==array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    /*
    func FindDuplicates(array []string) bool {
	table := make(map[string]bool)
	for _, v := range array {
		if _, ok := table[v]; ok {
			return true
		}
		table[v] = true
	}
	return false
}
*/
    public boolean hasDuplicatesWithMap(int[] array) {
        java.util.Map<Integer, Boolean> table = new java.util.HashMap<>();
        for (int v : array) {
            if (table.containsKey(v)) {
                return true;
            }
            table.put(v, true);
        }
        return false;
    }
    /*

func FindDuplicatesWithSort(array []string) bool {
	// sort array
	sort.Strings(array)

	// compare adjacent elements
	for i := 0; i < len(array)-1; i++ {
		if array[i] == array[i+1] {
			return true
		}
	}
	return false
}
     */

    public boolean hasDuplicatesWithSort(int[] array) {
        // sort array
        java.util.Arrays.sort(array);

        // compare adjacent elements
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return true;
            }
        }
        return false;
    }

}


