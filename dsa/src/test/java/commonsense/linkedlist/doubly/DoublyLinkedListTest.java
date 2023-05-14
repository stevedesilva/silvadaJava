package commonsense.linkedlist.doubly;

import commonsense.linkedlist.classic.ClassicLinkedList;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        list.addByIndex(0, "z");

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

        list.addByIndex(1, "z");

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

        list.addByIndex(2, "z");

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

        list.addByIndex(3, "z");

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
    void deleteHead() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        list.deleteFromFront();
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.readFromFront()));

        list.deleteFromFront();
        MatcherAssert.assertThat(1, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.readFromEnd()));
    }

    @Test
    void DeleteAllListHead() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        list.deleteFromFront();
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.readFromFront()));

        list.deleteFromFront();
        MatcherAssert.assertThat(1, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.readFromEnd()));

        list.deleteFromFront();
        MatcherAssert.assertThat(0, Matchers.equalTo(list.size()));
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
    void deleteFrontByIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("b");
        list.addAtEnd("c");

        list.deleteByIndex(0);
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.readFromFront()));

        list.deleteByIndex(0);
        MatcherAssert.assertThat(1, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.readFromEnd()));
    }

    @Test
    void deleteMiddleByIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");
        list.deleteByIndex(1);
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.head().data));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.tail().data));
        MatcherAssert.assertThat("c", Matchers.equalTo(list.head().next.data));
    }

    @Test
    void DeleteEndByIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        list.deleteByIndex(2);
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.readFromFront()));
        MatcherAssert.assertThat("b", Matchers.equalTo(list.readFromEnd()));

        list.deleteByIndex(1);
        MatcherAssert.assertThat(1, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.readFromFront()));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.readFromEnd()));
    }

    @Test
    void deleteErrorWhenIndexNotFound() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            list.deleteByIndex(2);
        });
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));

    }

    @Test
    void deleteItems() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("1 this is a password:1 that needs obfuscating");
        list.addAtEnd("2 this is a password:12 that needs obfuscating");
        list.addAtEnd("3 this is a password:123 that needs obfuscating");
        list.addAtEnd("4 this is a password:12cae that needs obfuscating");
        list.addAtEnd("5 this is a password:some_password that needs obfuscating");
        list.addAtEnd("6 a");
        list.addAtEnd("7 b");
        list.addAtEnd("8 this is a password:12cae that needs obfuscating");
        list.addAtEnd("9 c");
        list.addAtEnd("10 this is a password:some_password that needs obfuscating");

        final Predicate<String> stringPredicate = (text) -> {
            final Pattern p = Pattern.compile("\\bpassword:(\\w)+\\b");
            return p.matcher(text).find();
        };
        list.deleteItems(stringPredicate);
        MatcherAssert.assertThat(3, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("6 a", Matchers.equalTo(list.readFromFront()));
        MatcherAssert.assertThat("9 c", Matchers.equalTo(list.readFromEnd()));
    }

    @Test
    void deleteItemsHead() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("1 this is a password:1 that needs obfuscating");
        list.addAtEnd("2 a");
        list.addAtEnd("3 b");

        final Predicate<String> stringPredicate = (text) -> {
            final Pattern p = Pattern.compile("\\bpassword:(\\w)+\\b");
            return p.matcher(text).find();
        };
        list.deleteItems(stringPredicate);
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("2 a", Matchers.equalTo(list.readFromFront()));
        MatcherAssert.assertThat("3 b", Matchers.equalTo(list.readFromEnd()));
        MatcherAssert.assertThat("2 a", Matchers.equalTo(list.removeByIndex(0)));
        MatcherAssert.assertThat("3 b", Matchers.equalTo(list.removeByIndex(1)));
    }

    @Test
    void deleteItemsMid() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("1 a");
        list.addAtEnd("2 this is a password:1 that needs obfuscating");
        list.addAtEnd("3 this is a password:1 that needs obfuscating");
        list.addAtEnd("4 b");

        final Predicate<String> stringPredicate = (text) -> {
            final Pattern p = Pattern.compile("\\bpassword:(\\w)+\\b");
            return p.matcher(text).find();
        };
        list.deleteItems(stringPredicate);
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("1 a", Matchers.equalTo(list.readFromFront()));
        MatcherAssert.assertThat("4 b", Matchers.equalTo(list.readFromEnd()));
        MatcherAssert.assertThat("1 a", Matchers.equalTo(list.removeByIndex(0)));
        MatcherAssert.assertThat("4 b", Matchers.equalTo(list.removeByIndex(1)));
    }


    @Test
    void deleteItemsEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("1 a");
        list.addAtEnd("2 b");
        list.addAtEnd("3 this is a password:1 that needs obfuscating");

        final Predicate<String> stringPredicate = (text) -> {
            final Pattern p = Pattern.compile("\\bpassword:(\\w)+\\b");
            return p.matcher(text).find();
        };
        list.deleteItems(stringPredicate);
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("1 a", Matchers.equalTo(list.readFromFront()));
        MatcherAssert.assertThat("2 b", Matchers.equalTo(list.readFromEnd()));
        MatcherAssert.assertThat("1 a", Matchers.equalTo(list.removeByIndex(0)));
        MatcherAssert.assertThat("2 b", Matchers.equalTo(list.removeByIndex(1)));
    }


    @Test
    void RemoveFromFrontByIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        MatcherAssert.assertThat("a", Matchers.equalTo(list.removeByIndex(0)));
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));

        MatcherAssert.assertThat("b", Matchers.equalTo(list.removeByIndex(0)));
        MatcherAssert.assertThat(1, Matchers.equalTo(list.size()));

        MatcherAssert.assertThat("c", Matchers.equalTo(list.removeByIndex(0)));
        MatcherAssert.assertThat(0, Matchers.equalTo(list.size()));
    }

    @Test
    void RemoveFromMiddleByIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");
        list.addAtEnd("d");

        MatcherAssert.assertThat("c", Matchers.equalTo(list.removeByIndex(2)));
        MatcherAssert.assertThat(3, Matchers.equalTo(list.size()));

        MatcherAssert.assertThat("b", Matchers.equalTo(list.removeByIndex(1)));
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));

        MatcherAssert.assertThat("d", Matchers.equalTo(list.removeByIndex(1)));
        MatcherAssert.assertThat(1, Matchers.equalTo(list.size()));

        MatcherAssert.assertThat("a", Matchers.equalTo(list.removeByIndex(0)));
        MatcherAssert.assertThat(0, Matchers.equalTo(list.size()));
    }

    @Test
    void RemoveFromEndByIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        MatcherAssert.assertThat("c", Matchers.equalTo(list.removeByIndex(2)));
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));

        MatcherAssert.assertThat("b", Matchers.equalTo(list.removeByIndex(1)));
        MatcherAssert.assertThat(1, Matchers.equalTo(list.size()));

        MatcherAssert.assertThat("c", Matchers.equalTo(list.removeByIndex(0)));
        MatcherAssert.assertThat(0, Matchers.equalTo(list.size()));
    }

    @Test
    void RemoveFromFrontSingle() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");

        list.deleteFromFront();
        MatcherAssert.assertThat(0, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat("a", Matchers.equalTo(list.removeFromFront()));
    }

    @Test
    void RemoveFromFront() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        MatcherAssert.assertThat("a", Matchers.equalTo(list.removeFromFront()));
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));

        list.deleteFromFront();
        MatcherAssert.assertThat("b", Matchers.equalTo(list.removeFromFront()));
        MatcherAssert.assertThat(1, Matchers.equalTo(list.size()));

        list.deleteFromFront();
        MatcherAssert.assertThat("c", Matchers.equalTo(list.removeFromFront()));
        MatcherAssert.assertThat(0, Matchers.equalTo(list.size()));
    }

    @Test
    void RemoveFromEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        MatcherAssert.assertThat("c", Matchers.equalTo(list.removeFromEnd()));
        MatcherAssert.assertThat(2, Matchers.equalTo(list.size()));

        list.deleteFromFront();
        MatcherAssert.assertThat("b", Matchers.equalTo(list.removeFromEnd()));
        MatcherAssert.assertThat(1, Matchers.equalTo(list.size()));

        list.deleteFromFront();
        MatcherAssert.assertThat("a", Matchers.equalTo(list.removeFromEnd()));
        MatcherAssert.assertThat(0, Matchers.equalTo(list.size()));
    }

    @Test
    void search() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        MatcherAssert.assertThat(0, Matchers.equalTo(list.search("a")));
        MatcherAssert.assertThat(3, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat(1, Matchers.equalTo(list.search("b")));
        MatcherAssert.assertThat(3, Matchers.equalTo(list.size()));
        MatcherAssert.assertThat(2, Matchers.equalTo(list.search("c")));
        MatcherAssert.assertThat(3, Matchers.equalTo(list.size()));
    }

    @Test
    void searchErrorWhenIndexNotFound() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            list.search( "d");
        });
    }

    @Test
    void printItems() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");
        MatcherAssert.assertThat("[a b c]", Matchers.equalTo(list.printItems()));
    }

}