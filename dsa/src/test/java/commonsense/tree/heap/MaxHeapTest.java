package commonsense.tree.heap;


import commonsense.tree.heap.MaxHeap;
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
        //    10
        //   / \
        //  3   2
        // /
        // 1
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
    }

    @Test
    @DisplayName("should get root element ")
    public void rootNodeShouldInsertRootElementInsertLargestFirst() {
        //    10
        //   / \
        //  3   2
        // /
        // 1
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
    }

    @Test
    @DisplayName("should pop max heap in descending order ")
    public void rootNodeShouldPopElementsInSortedOrderSingle() {
        // given
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(9);

        MatcherAssert.assertThat("root element should be 9", maxHeap.delete(), Matchers.equalTo(9));

        assertThrows(NoSuchElementException.class, maxHeap::lastNode);
    }
    @Test
    public void rootNodeShouldPopElementsInSortedOrderWithChildren() {
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
        MatcherAssert.assertThat("root element should be 10", maxHeap.rootNode(), Matchers.equalTo(10));
        MatcherAssert.assertThat("root element should be 10", maxHeap.delete(), Matchers.equalTo(10));

        MatcherAssert.assertThat("root element should be 9", maxHeap.rootNode(), Matchers.equalTo(9));
        MatcherAssert.assertThat("root element should be 9", maxHeap.delete(), Matchers.equalTo(9));

        MatcherAssert.assertThat("root element should be 8", maxHeap.rootNode(), Matchers.equalTo(8));
        MatcherAssert.assertThat("root element should be 8", maxHeap.delete(), Matchers.equalTo(  8));

        MatcherAssert.assertThat("root element should be 7", maxHeap.rootNode(), Matchers.equalTo(7));
        MatcherAssert.assertThat("root element should be 7", maxHeap.delete(), Matchers.equalTo(  7));

        MatcherAssert.assertThat("root element should be 6", maxHeap.rootNode(), Matchers.equalTo(6));
        MatcherAssert.assertThat("root element should be 6", maxHeap.delete(), Matchers.equalTo(  6));

        MatcherAssert.assertThat("root element should be 5", maxHeap.rootNode(), Matchers.equalTo(5));
        MatcherAssert.assertThat("root element should be 5", maxHeap.delete(), Matchers.equalTo(  5));

        MatcherAssert.assertThat("root element should be 4", maxHeap.rootNode(), Matchers.equalTo(4));
        MatcherAssert.assertThat("root element should be 4", maxHeap.delete(), Matchers.equalTo(  4));

        MatcherAssert.assertThat("root element should be 3", maxHeap.rootNode(), Matchers.equalTo(3));
        MatcherAssert.assertThat("root element should be 3", maxHeap.delete(), Matchers.equalTo(  3));

        MatcherAssert.assertThat("root element should be 2", maxHeap.rootNode(), Matchers.equalTo(2));
        MatcherAssert.assertThat("root element should be 2", maxHeap.delete(), Matchers.equalTo(  2));

        MatcherAssert.assertThat("root element should be 1", maxHeap.rootNode(), Matchers.equalTo(1));
        MatcherAssert.assertThat("root element should be 1", maxHeap.delete(), Matchers.equalTo(  1));

        assertThrows(NoSuchElementException.class, maxHeap::lastNode);
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

    @Test
    public void getChildNode(){
        //0,1,2,3,4,5,6,7,8,9,10
        //           0
        //      /          \
        //     1            2
        //    /  \        /  \
        //   3    4      5    6
        //  / \  / \    / \   / \
        // 7  8  9  10 11 12 13 14
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
        MatcherAssert.assertThat( MaxHeap.getLeftChildNode(0), Matchers.equalTo(1));
        MatcherAssert.assertThat( MaxHeap.getRightChildNode(0), Matchers.equalTo(2));
        MatcherAssert.assertThat( MaxHeap.getLeftChildNode(1), Matchers.equalTo(3));
        MatcherAssert.assertThat( MaxHeap.getRightChildNode(1), Matchers.equalTo(4));
        MatcherAssert.assertThat( MaxHeap.getLeftChildNode(2), Matchers.equalTo(5));
        MatcherAssert.assertThat( MaxHeap.getRightChildNode(2), Matchers.equalTo(6));
        MatcherAssert.assertThat( MaxHeap.getLeftChildNode(3), Matchers.equalTo(7));
        MatcherAssert.assertThat( MaxHeap.getRightChildNode(3), Matchers.equalTo(8));
        MatcherAssert.assertThat( MaxHeap.getLeftChildNode(4), Matchers.equalTo(9));
        MatcherAssert.assertThat( MaxHeap.getRightChildNode(4), Matchers.equalTo(10));
        MatcherAssert.assertThat( MaxHeap.getLeftChildNode(5), Matchers.equalTo(11));
        MatcherAssert.assertThat( MaxHeap.getRightChildNode(5), Matchers.equalTo(12));
        MatcherAssert.assertThat( MaxHeap.getLeftChildNode(6), Matchers.equalTo(13));
        MatcherAssert.assertThat( MaxHeap.getRightChildNode(6), Matchers.equalTo(14));
    }


}