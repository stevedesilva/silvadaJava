package commonsense.heap;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MaxHeapTest {
    // generate test data
    @Test
    @DisplayName("should throw exception when root element found")
    public void rootNodeShouldThrowExceptionWhenRootElementFound() {
        // given
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        // when
        assertThrows(NoSuchElementException.class, maxHeap::rootNode);
    }

    @Test
    @DisplayName("should throw exception when last element found")
    public void rootNodeShouldThrowExceptionWhenLastElementFound() {
        // given
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        // when
        assertThrows(NoSuchElementException.class, maxHeap::lastNode);
    }

    @Test
    @DisplayName("should get root element ")
    public void rootNodeShouldInsertRootElement() {
        // given
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(10);
        // when
        Integer result = maxHeap.rootNode();
        // then
        MatcherAssert.assertThat("root element should be 10", result, Matchers.equalTo(10));
        MatcherAssert.assertThat("root element should be 3", result, Matchers.equalTo(3));
        MatcherAssert.assertThat("root element should be 2", result, Matchers.equalTo(2));
        MatcherAssert.assertThat("root element should be 1", result, Matchers.equalTo(1));
    }

    @Test
    @DisplayName("should get root element ")
    public void rootNodeShouldGetRootElement() {
        // given
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(10);
        // when
        Integer result = maxHeap.rootNode();
        // then
        MatcherAssert.assertThat("root element should be 10", result, Matchers.equalTo(10));
        MatcherAssert.assertThat("root element should be 3", result, Matchers.equalTo(3));
        MatcherAssert.assertThat("root element should be 2", result, Matchers.equalTo(2));
        MatcherAssert.assertThat("root element should be 1", result, Matchers.equalTo(1));
    }

}