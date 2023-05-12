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
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");

        list.addToFront("y");

        MatcherAssert.assertThat(3, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("y", Matchers.equalTo(list.head().data));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.head().next.data));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.head().next.next.data));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.tail().data));

        list.addToFront("z");
        MatcherAssert.assertThat(4, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("z", Matchers.equalTo(list.head().data));
        MatcherAssert.assertThat("y", Matchers.equalTo(list.head().next.data));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.head().next.next.data));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.head().next.next.next.data));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.tail().data));
    }


    @Test
    void readByIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");
        MatcherAssert.assertThat(3, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.readByIndex(0)));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.readByIndex(1)));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.readByIndex(2)));
    }
    @Test
    void readByIndexShouldErrorWhenEmptyList() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            list.readByIndex(0);
        });
    }
    @Test
    void readByIndexShouldErrorWhenIndexNotFound() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            list.addAtEnd("a");
            list.addAtEnd("b");
            list.addAtEnd("c");
            list.readByIndex(3);
        });
    }
    @Test
    void readFromFront() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");
        MatcherAssert.assertThat(3, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.readFromFront()));
    }
    @Test
    void readFromFrontShouldErrorEmptyList() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            list.readFromFront();
        });
    }
    @Test
    void readFromEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");
        MatcherAssert.assertThat(3, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.readFromEnd()));
    }
    @Test
    void readFromEndShouldErrorEmptyList() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            list.readFromEnd();
        });
    }

    @Test
    void deleteTail() {

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");
        list.deleteFromEnd();
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.readFromEnd()));
        list.deleteFromEnd();
        MatcherAssert.assertThat(1, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.readFromEnd()));
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