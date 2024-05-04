package commonsense.tree.heap;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MinHeapTest {
    // generate test data
    @Test
    @DisplayName("should throw exception when root element found")
    public void rootNodeShouldThrowExceptionWhenRootElementFound() {
        // given
        MinHeap<Integer> minHeap = new MinHeap<>();
        // when
        assertThrows(NoSuchElementException.class, minHeap::rootNode);
    }

    @Test
    @DisplayName("should throw exception when last element found")
    public void rootNodeShouldThrowExceptionWhenLastElementFound() {
        // given
        MinHeap<Integer> minHeap = new MinHeap<>();
        // when
        assertThrows(NoSuchElementException.class, minHeap::lastNode);
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
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(10);
        // when
        Integer result = minHeap.rootNode();
        // then
        MatcherAssert.assertThat("root element should be 1", result, Matchers.equalTo(1));
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
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(9);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(4);
        // when
        Integer result = minHeap.rootNode();
        // then
        MatcherAssert.assertThat("root element should be 1", result, Matchers.equalTo(1));
    }

    @Test
    @DisplayName("should pop max heap in descending order ")
    public void rootNodeShouldPopElementsInSortedOrderSingle() {
        // given
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(9);

        MatcherAssert.assertThat("root element should be 9", minHeap.delete(), Matchers.equalTo(9));

        assertThrows(NoSuchElementException.class, minHeap::lastNode);
    }
    @Test
    public void rootNodeShouldPopElementsInSortedOrderWithChildren() {
        // given
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(9);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(4);

        MatcherAssert.assertThat("root element should be 1", minHeap.rootNode(), Matchers.equalTo(1));
        MatcherAssert.assertThat("root element should be 1", minHeap.delete(), Matchers.equalTo(  1));

        MatcherAssert.assertThat("root element should be 2", minHeap.rootNode(), Matchers.equalTo(2));
        MatcherAssert.assertThat("root element should be 2", minHeap.delete(), Matchers.equalTo(  2));

        MatcherAssert.assertThat("root element should be 3", minHeap.rootNode(), Matchers.equalTo(3));
        MatcherAssert.assertThat("root element should be 3", minHeap.delete(), Matchers.equalTo(  3));

        MatcherAssert.assertThat("root element should be 4", minHeap.rootNode(), Matchers.equalTo(4));
        MatcherAssert.assertThat("root element should be 4", minHeap.delete(), Matchers.equalTo(  4));

        MatcherAssert.assertThat("root element should be 5", minHeap.rootNode(), Matchers.equalTo(5));
        MatcherAssert.assertThat("root element should be 5", minHeap.delete(), Matchers.equalTo(  5));

        MatcherAssert.assertThat("root element should be 6", minHeap.rootNode(), Matchers.equalTo(6));
        MatcherAssert.assertThat("root element should be 6", minHeap.delete(), Matchers.equalTo(  6));

        MatcherAssert.assertThat("root element should be 7", minHeap.rootNode(), Matchers.equalTo(7));
        MatcherAssert.assertThat("root element should be 7", minHeap.delete(), Matchers.equalTo(  7));

        MatcherAssert.assertThat("root element should be 8", minHeap.rootNode(), Matchers.equalTo(8));
        MatcherAssert.assertThat("root element should be 8", minHeap.delete(), Matchers.equalTo(  8));

        MatcherAssert.assertThat("root element should be 9", minHeap.rootNode(), Matchers.equalTo(9));
        MatcherAssert.assertThat("root element should be 9", minHeap.delete(), Matchers.equalTo(9));

        MatcherAssert.assertThat("root element should be 10", minHeap.rootNode(), Matchers.equalTo(10));
        MatcherAssert.assertThat("root element should be 10", minHeap.delete(), Matchers.equalTo(10));
        assertThrows(NoSuchElementException.class, minHeap::lastNode);
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
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(9);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(4);
        MatcherAssert.assertThat( MinHeap.getParentNode(1), Matchers.equalTo(0));
        MatcherAssert.assertThat( MinHeap.getParentNode(2), Matchers.equalTo(0));
        MatcherAssert.assertThat( MinHeap.getParentNode(3), Matchers.equalTo(1));
        MatcherAssert.assertThat( MinHeap.getParentNode(4), Matchers.equalTo(1));
        MatcherAssert.assertThat( MinHeap.getParentNode(5), Matchers.equalTo(2));
        MatcherAssert.assertThat( MinHeap.getParentNode(6), Matchers.equalTo(2));
        MatcherAssert.assertThat( MinHeap.getParentNode(7), Matchers.equalTo(3));
        MatcherAssert.assertThat( MinHeap.getParentNode(8), Matchers.equalTo(3));
        MatcherAssert.assertThat( MinHeap.getParentNode(11), Matchers.equalTo(5));
        MatcherAssert.assertThat( MinHeap.getParentNode(14), Matchers.equalTo(6));
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
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(9);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(4);
        MatcherAssert.assertThat( MinHeap.getLeftChildNode(0), Matchers.equalTo(1));
        MatcherAssert.assertThat( MinHeap.getRightChildNode(0), Matchers.equalTo(2));
        MatcherAssert.assertThat( MinHeap.getLeftChildNode(1), Matchers.equalTo(3));
        MatcherAssert.assertThat( MinHeap.getRightChildNode(1), Matchers.equalTo(4));
        MatcherAssert.assertThat( MinHeap.getLeftChildNode(2), Matchers.equalTo(5));
        MatcherAssert.assertThat( MinHeap.getRightChildNode(2), Matchers.equalTo(6));
        MatcherAssert.assertThat( MinHeap.getLeftChildNode(3), Matchers.equalTo(7));
        MatcherAssert.assertThat( MinHeap.getRightChildNode(3), Matchers.equalTo(8));
        MatcherAssert.assertThat( MinHeap.getLeftChildNode(4), Matchers.equalTo(9));
        MatcherAssert.assertThat( MinHeap.getRightChildNode(4), Matchers.equalTo(10));
        MatcherAssert.assertThat( MinHeap.getLeftChildNode(5), Matchers.equalTo(11));
        MatcherAssert.assertThat( MinHeap.getRightChildNode(5), Matchers.equalTo(12));
        MatcherAssert.assertThat( MinHeap.getLeftChildNode(6), Matchers.equalTo(13));
        MatcherAssert.assertThat( MinHeap.getRightChildNode(6), Matchers.equalTo(14));
    }


}