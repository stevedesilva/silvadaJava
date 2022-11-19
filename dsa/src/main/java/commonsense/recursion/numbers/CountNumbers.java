package commonsense.recursion.numbers;

import java.util.ArrayList;
import java.util.List;

public class CountNumbers {
    public List<Integer> collectNumbers(Element element) {
        final ArrayList<Integer> result = new ArrayList<>();
        collectNumbers(element, result);
        return result;
    }

    public List<Integer> collectNumbers(Element elements, List<Integer> result) {
        if (elements instanceof IntegerElement) {
            final Integer e = ((IntegerElement) elements).get();
            result.add(e);
        } else if (elements instanceof ArrayElement){
            for(Element element : ((ArrayElement) elements).get()) {
                if (element instanceof IntegerElement) {
                    final Integer e = ((IntegerElement) element).get();
                    result.add(e);
                } else {
                    collectNumbers(element, result);
                }
            }
        }
        return result;
    }
    
}

