package commonsense.tree.trie;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
        MatcherAssert.assertThat(t.getRoot().getChildren().containsKey('t'), Matchers.equalTo(true));
        MatcherAssert.assertThat(t.getRoot().getChildren().get('t').getChildren().containsKey('e'), Matchers.equalTo(true));
        MatcherAssert.assertThat(t.getRoot().getChildren().get('t').getChildren().get('e').getChildren().containsKey('s'), Matchers.equalTo(true));
        MatcherAssert.assertThat(t.getRoot().getChildren().get('t').getChildren().get('e').getChildren().get('s').getChildren().containsKey('t'), Matchers.equalTo(true));
        MatcherAssert.assertThat(t.getRoot().getChildren().get('t').getChildren().get('e').getChildren().get('s').getChildren().get('t').getChildren().containsKey('*'), Matchers.equalTo(true));
    }

    @Test
    void searchEmptyWordThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Trie t = new Trie();
            t.search("");
        });
    }

    @Test
    void searchWordFound() {
        Trie t = new Trie();
        final String word1 = "test";
        final String word2 = "board";
        final String word3 = "tea";
        t.insert(word1);
        t.insert(word2);
        t.insert(word3);

        MatcherAssert.assertThat(t.search(word1), Matchers.notNullValue());
        MatcherAssert.assertThat(t.search(word2), Matchers.notNullValue());
        MatcherAssert.assertThat(t.search(word3), Matchers.notNullValue());
    }

    @Test
    void searchWordNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            Trie t = new Trie();
            t.insert("word");
            t.search("cat");
        });
    }

    @Test
    void printAllWordNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            Trie t = new Trie();
            t.printAll();
        });
    }

    @Test
    void printAll() {
        Trie t = new Trie();
        final List<String> words = List.of("word","worker","starter","cube","candle","cat","canter");
        words.forEach(t::insert);

        final List<String> results = t.printAll();
        MatcherAssert.assertThat(results, Matchers.containsInAnyOrder(words.toArray()));
    }

    @Test
    public void shouldAutoCompletePrefix() {
        Trie t = new Trie();
        final List<String> words = List.of("word","worker","starter","cube","candle","cat","canter");
        words.forEach(t::insert);
        final List<String> results = t.autoComplete("wor");
        MatcherAssert.assertThat(results, Matchers.containsInAnyOrder( List.of("word","worker").toArray()));
    }

    @Test
    public void shouldAutoCompletePrefixNotFound() {
        Trie t = new Trie();
        final List<String> words = List.of("word", "worker", "starter", "cube", "candle", "cat", "canter");
        words.forEach(t::insert);
        // assert exception thrown when word is not found
        assertThrows(IllegalArgumentException.class, () -> {
            t.autoComplete("wors");
        });
    }

}