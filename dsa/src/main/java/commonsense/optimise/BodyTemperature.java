package commonsense.optimise;

import java.util.Collections;
import java.util.List;

public class BodyTemperature {

    public List<Double> sortTemperatures(List<Double> temperatures) throws IllegalArgumentException{
        // Using built-in sort for simplicity
        Collections.sort(temperatures);
        return temperatures;
    }
}
