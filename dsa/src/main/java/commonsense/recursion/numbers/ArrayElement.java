package commonsense.recursion.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayElement implements Element<List<Element>> {
    public List<Element> get() {
        return elements;
    }

    private List<Element> elements;

    private ArrayElement(List<Element> elements) {
        this.elements = elements;
    }
    public static ArrayElement of(Element... elements) {
        List<Element> tempElement = new ArrayList<>();
        Arrays.stream(elements).forEach( e -> {
            tempElement.add(e);
        });
        return new ArrayElement(tempElement);
    }

}
