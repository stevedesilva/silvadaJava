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
    @DisplayName("should pop max heap in descending order ")
    public void rootNodeShouldPopElementsInSortedOrder() {
        // given
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(9);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(10);
        maxHeap.insert(3);
        maxHeap.insert(7);
        maxHeap.insert(8);
        maxHeap.insert(4);
        // when
        Integer result = maxHeap.rootNode();
        // then
        MatcherAssert.assertThat("root element should be 10", result, Matchers.equalTo(10));
        MatcherAssert.assertThat("root element should be 9", result, Matchers.equalTo(9));
        MatcherAssert.assertThat("root element should be 8", result, Matchers.equalTo(8));
        MatcherAssert.assertThat("root element should be 7", result, Matchers.equalTo(7));
        MatcherAssert.assertThat("root element should be 6", result, Matchers.equalTo(6));
        MatcherAssert.assertThat("root element should be 5", result, Matchers.equalTo(5));
        MatcherAssert.assertThat("root element should be 4", result, Matchers.equalTo(4));
        MatcherAssert.assertThat("root element should be 3", result, Matchers.equalTo(3));
        MatcherAssert.assertThat("root element should be 2", result, Matchers.equalTo(2));
        MatcherAssert.assertThat("root element should be 1", result, Matchers.equalTo(1));
    }

    @Test
    public void getParentNode(){
        //0,1,2,3,4,5,6,7,8,9,10
        //           0
        //      /          \
        //     1            2
        //    /  \        /  \
        //   3    4      5    6
        //  / \  / \    / \   / \
        // 7  8  9  10 11 12 12 14
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(9);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(10);
        maxHeap.insert(3);
        maxHeap.insert(7);
        maxHeap.insert(8);
        maxHeap.insert(4);
        MatcherAssert.assertThat( MaxHeap.getParentNode(1), Matchers.equalTo(0));
        MatcherAssert.assertThat( MaxHeap.getParentNode(2), Matchers.equalTo(0));
        MatcherAssert.assertThat( MaxHeap.getParentNode(3), Matchers.equalTo(1));
        MatcherAssert.assertThat( MaxHeap.getParentNode(4), Matchers.equalTo(1));
        MatcherAssert.assertThat( MaxHeap.getParentNode(5), Matchers.equalTo(2));
        MatcherAssert.assertThat( MaxHeap.getParentNode(6), Matchers.equalTo(2));
        MatcherAssert.assertThat( MaxHeap.getParentNode(7), Matchers.equalTo(3));
        MatcherAssert.assertThat( MaxHeap.getParentNode(8), Matchers.equalTo(3));
        MatcherAssert.assertThat( MaxHeap.getParentNode(11), Matchers.equalTo(5));
        MatcherAssert.assertThat( MaxHeap.getParentNode(14), Matchers.equalTo(6));


    }

}