package commonsense.linkedlist.doubly;

import commonsense.linkedlist.classic.ClassicLinkedList;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class DoublyLinkedListTest {

    @Test
    void addAtEnd() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addAtEnd(1);
        MatcherAssert.assertThat(1, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat(1, Matchers.equalTo(list.head().data));
        MatcherAssert.assertThat(1, Matchers.equalTo(list.tail().data));

        list.addAtEnd(2);
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat(1, Matchers.equalTo(list.head().data));
        MatcherAssert.assertThat(1, Matchers.equalTo(list.head().next.data));
        MatcherAssert.assertThat(2, Matchers.equalTo(list.tail().data));
    }

    @Test
    void addByIndexFront() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        list.addByIndex(0,"z");

        MatcherAssert.assertThat(4, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("z", Matchers.equalTo(list.head().data));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.tail().data));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.head().next.data));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.head().next.next.data));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.head().next.next.next.data));
    }

    @Test
    void addByIndexMid() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        list.addByIndex(1,"z");

        MatcherAssert.assertThat(4, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.head().data));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.tail().data));
        MatcherAssert.assertThat("z", Matchers.equalTo(list.head().next.data));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.head().next.next.data));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.head().next.next.next.data));
    }

    @Test
    void addByIndexMidEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        list.addByIndex(2,"z");

        MatcherAssert.assertThat(4, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.head().data));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.tail().data));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.head().next.data));
        MatcherAssert.assertThat("z", Matchers.equalTo(list.head().next.next.data));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.head().next.next.next.data));
    }

    /*
    func TestDoublyLinkedList_AddByIndexEnd(t *testing.T) {
	list := NewDoublyLinkedList[string]()
	list.AddAtEnd("a")
	list.AddAtEnd("b")
	list.AddAtEnd("c")

	list.AddByIndex(3, "z")
	assert.Equal(t, 4, list.Size())
	assert.Equal(t, "a", list.Head().data)
	assert.Equal(t, "z", list.Tail().data)
	assert.Equal(t, "b", list.Head().next.data)
	assert.Equal(t, "c", list.Head().next.next.data)
	assert.Equal(t, "z", list.Head().next.next.next.data)
}
     */
    @Test
    void addByIndexEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        list.addByIndex(3,"z");

        MatcherAssert.assertThat(4, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.head().data));
        MatcherAssert.assertThat("z", Matchers.equalTo(list.tail().data));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.head().next.data));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.head().next.next.data));
        MatcherAssert.assertThat("z", Matchers.equalTo(list.head().next.next.next.data));
    }

    @Test
    void addByIndexReturnErrorWhenIndexOutOfBounds() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            list.addAtEnd("a");
            list.addAtEnd("b");
            list.addAtEnd("c");
            list.addByIndex(12, "d");
        });
    }

    @Test
    void addToFront() {
    }

    @Test
    void readByIndex() {
    }
    @Test
    void readByIndexShouldErrorWhenEmptyList() {
    }
    @Test
    void readByIndexShouldErrorWhenIndexNotFound() {
    }
    @Test
    void readFromFront() {
    }
    @Test
    void readFromFrontShouldErrorEmptyList() {
    }
    @Test
    void readFromEnd() {
    }
    @Test
    void readFromEndShouldErrorEmptyList() {
    }
    //

    @Test
    void deleteTail() {
    }

    @Test
    void deleteMiddleByIndex() {
    }

    @Test
    void deleteItemsMid() {
    }

    @Test
    void deleteItemsHead() {

    }
    @Test
    void deleteItemsEnd() {

    }

    @Test
    void deleteItems() {

    }

    @Test
    void deleteHead() {

    }

    @Test
    void deleteFrontByIndex() {

    }
    @Test
    void deleteErrorWhenIndexNotFound() {

    }
    @Test
    void DeleteEndByIndex() {

    }
    @Test
    void DeleteAllListHead() {

    }


    @Test
    void printItems() {
    }

    @Test
    void RemoveFromMiddleByIndex() {
    }

    @Test
    void RemoveFromFrontSingle() {
    }

    @Test
    void RemoveFromFrontByIndex() {
    }

    @Test
    void RemoveFromFront() {
    }
    @Test
    void RemoveFromEndByIndex() {
    }

    @Test
    void RemoveFromEnd() {
    }

    @Test
    void search() {
    }

    @Test
    void searchErrorWhenIndexNotFound() {
    }

}