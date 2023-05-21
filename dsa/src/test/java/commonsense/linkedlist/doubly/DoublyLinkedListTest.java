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
        MatcherAssert.assertThat(2, Matchers.equalTo(list.tail().data));
        MatcherAssert.assertThat(2, Matchers.equalTo(list.head().next.data));
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
        MatcherAssert.assertThat("b", Matchers.equalTo(list.head().next.next.data));
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
        MatcherAssert.assertThat(list.head().next.data, Matchers.equalTo("c"));
    }

    @Test
    void DeleteEndByIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        list.deleteByIndex(2);
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(2));
        MatcherAssert.assertThat(list.readFromFront(), Matchers.equalTo("a"));
        MatcherAssert.assertThat(list.readFromEnd(), Matchers.equalTo("b"));

        list.deleteByIndex(1);
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(1));
        MatcherAssert.assertThat(list.readFromFront(), Matchers.equalTo("a"));
        MatcherAssert.assertThat(list.readFromEnd(), Matchers.equalTo("a"));
    }

    @Test
    void deleteErrorWhenIndexNotFound() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            list.deleteByIndex(2);
        });
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(2));

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
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(3));
        MatcherAssert.assertThat(list.readFromFront(), Matchers.equalTo("6 a"));
        MatcherAssert.assertThat(list.readFromEnd(), Matchers.equalTo("9 c"));
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
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(2));
        MatcherAssert.assertThat(list.readFromFront(), Matchers.equalTo("2 a"));
        MatcherAssert.assertThat(list.readFromEnd(), Matchers.equalTo("3 b"));
        MatcherAssert.assertThat(list.removeByIndex(1), Matchers.equalTo("3 b"));
        MatcherAssert.assertThat(list.removeByIndex(0), Matchers.equalTo("2 a"));
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
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(2));
        MatcherAssert.assertThat(list.readFromFront(), Matchers.equalTo("1 a"));
        MatcherAssert.assertThat(list.readFromEnd(), Matchers.equalTo("4 b"));
        MatcherAssert.assertThat(list.removeByIndex(0), Matchers.equalTo("1 a"));
        MatcherAssert.assertThat(list.removeByIndex(1), Matchers.equalTo("4 b"));
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
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(2));
        MatcherAssert.assertThat(list.readFromFront(), Matchers.equalTo("1 a"));
        MatcherAssert.assertThat(list.readFromEnd(), Matchers.equalTo("2 b"));
        MatcherAssert.assertThat(list.removeByIndex(0), Matchers.equalTo("1 a"));
        MatcherAssert.assertThat(list.removeByIndex(1), Matchers.equalTo("2 b"));
    }


    @Test
    void RemoveFromFrontByIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        MatcherAssert.assertThat(list.removeByIndex(0), Matchers.equalTo("a"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(2));

        MatcherAssert.assertThat(list.removeByIndex(0), Matchers.equalTo("b"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(1));

        MatcherAssert.assertThat(list.removeByIndex(0), Matchers.equalTo("c"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(0));
    }

    @Test
    void RemoveFromMiddleByIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");
        list.addAtEnd("d");

        MatcherAssert.assertThat(list.removeByIndex(2), Matchers.equalTo("c"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(3));

        MatcherAssert.assertThat(list.removeByIndex(1), Matchers.equalTo("b"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(2));

        MatcherAssert.assertThat(list.removeByIndex(1), Matchers.equalTo("d"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(1));

        MatcherAssert.assertThat(list.removeByIndex(0), Matchers.equalTo("a"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(0));
    }

    @Test
    void RemoveFromEndByIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        MatcherAssert.assertThat(list.removeByIndex(2), Matchers.equalTo("c"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(2));

        MatcherAssert.assertThat(list.removeByIndex(1), Matchers.equalTo("b"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(1));

        MatcherAssert.assertThat(list.removeByIndex(0), Matchers.equalTo("a"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(0));
    }

    @Test
    void RemoveFromFrontSingle() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");

        MatcherAssert.assertThat(list.removeFromFront(), Matchers.equalTo("a"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(0));
    }

    @Test
    void RemoveFromFront() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        MatcherAssert.assertThat(list.removeFromFront(), Matchers.equalTo("a"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(2));

        MatcherAssert.assertThat(list.removeFromFront(), Matchers.equalTo("b"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(1));

        MatcherAssert.assertThat(list.removeFromFront(), Matchers.equalTo("c"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(0));
    }

    @Test
    void RemoveFromEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        MatcherAssert.assertThat(list.removeFromEnd(), Matchers.equalTo("c"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(2));

        MatcherAssert.assertThat(list.removeFromEnd(), Matchers.equalTo("b"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(1));

        MatcherAssert.assertThat(list.removeFromEnd(), Matchers.equalTo("a"));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(0));
    }

    @Test
    void search() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAtEnd("a");
        list.addAtEnd("b");
        list.addAtEnd("c");

        MatcherAssert.assertThat(list.search("a"), Matchers.equalTo(0));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(3));
        MatcherAssert.assertThat(list.search("b"), Matchers.equalTo(1));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(3));
        MatcherAssert.assertThat(list.search("c"), Matchers.equalTo(2));
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(3));
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
        MatcherAssert.assertThat(list.printItems(), Matchers.equalTo("a,b,c"));
    }

}