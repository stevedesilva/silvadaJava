package commonsense.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AverageCelsuisReader {
    public long getAverageCelsuisReading(int[] fahrenheitNumbers) throws IllegalArgumentException{
        if (fahrenheitNumbers.length <= 0) {
            throw new IllegalArgumentException("input parameter cannot be empty");
        }
        List<Long> celsuisList = new ArrayList<>();
        for (int i = 0; i < fahrenheitNumbers.length; i++) {
            celsuisList.add(Math.round((fahrenheitNumbers[i] - 32) * 0.5556));
        }
        final Optional<Long> sum = celsuisList.stream().reduce((a, b) -> a + b);
        final Long result = sum.get() / celsuisList.size();
        return result;
    }
}
