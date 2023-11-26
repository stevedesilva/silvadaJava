package commonsense.tree.trie;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void insertEmptyWordThrowError() {
       assertThrows(IllegalArgumentException.class, () -> {
           Trie t = new Trie();
           t.insert("");
       });
    }

    @Test
    void insertSingleWord() {
        Trie t = new Trie();
        t.insert("test");
        MatcherAssert.assertThat(t.getRoot().getChildren().containsKey('t'),  Matchers.equalTo(true));
        MatcherAssert.assertThat(t.getRoot().getChildren().get('t').getChildren().containsKey('e'),  Matchers.equalTo(true));
        MatcherAssert.assertThat(t.getRoot().getChildren().get('t').getChildren().get('e').getChildren().containsKey('s'),  Matchers.equalTo(true));
        MatcherAssert.assertThat(t.getRoot().getChildren().get('t').getChildren().get('e').getChildren().get('s').getChildren().containsKey('t'),  Matchers.equalTo(true));
        MatcherAssert.assertThat(t.getRoot().getChildren().get('t').getChildren().get('e').getChildren().get('s').getChildren().get('t').getChildren().containsKey('*'),  Matchers.equalTo(true));
    }

    @Test
    void searchEmptyWordThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Trie t = new Trie();
            t.search("");
        });
    }

    @Test
    void search() {
        Trie t = new Trie();
        t.insert("test");
        final Node test = t.search("test");
        MatcherAssert.assertThat(test,Matchers.notNullValue());
    }

    @Test
    void printAll() {
    }
}