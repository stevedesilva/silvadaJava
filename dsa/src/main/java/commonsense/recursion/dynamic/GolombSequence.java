package commonsense.recursion.dynamic;

import java.util.HashMap;
import java.util.Map;

public class GolombSequence {
    /**
     * In mathematics, the Golomb sequence, named after Solomon W. Golomb
     * (but also called Silverman's sequence), is a monotonically increasing integer sequence where an is the number of
     * times that n occurs in the sequence, starting with a1 = 1, and with the property that for n > 1 each an is the
     * smallest unique integer which makes it possible to satisfy the condition. For example, a1 = 1 says that 1 only
     * occurs once in the sequence, so a2 cannot be 1 too, but it can be, and therefore must be, 2. The first few values are
     * <p>
     * 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12
     *
     * @return
     */
    public static int execute(Integer number) {
        return golomb(number, new HashMap<>());
    }

    /*
    func golomb(number int, cache map[int]int) int {
	if number == 1 {
		return 1
	}
	if val, ok := cache[number]; ok {
		fmt.Printf("cached number%d= %d \n", number, val)
		return val
	}
	cache[number] = 1 + golomb(number-golomb(golomb(number-1, cache), cache), cache)
	return cache[number]
}

     */
    private static int golomb(Integer number, Map<Integer, Integer> cache) {
        if (number == 1) {
            return 1;
        }
        if (cache.containsKey(number)) {
            System.out.println("Cached value: " + number);
            return cache.get(number);
        }

        cache.put(number, 1 + golomb(number-golomb(golomb(number-1, cache), cache),cache));
        return cache.get(number);
    }

}
