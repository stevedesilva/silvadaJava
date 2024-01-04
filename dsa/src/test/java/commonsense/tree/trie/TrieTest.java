package commonsense.tree.trie;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(IllegalArgumentException.class, () -> t.autoComplete("wors"));
    }

    @Test
    public void shouldAutoCompletePrefixEmpty() {
        Trie t = new Trie();
        final List<String> words = List.of("word", "worker", "starter", "cube", "candle", "cat", "canter");
        words.forEach(t::insert);
        // assert exception thrown when word is not found
        assertThrows(IllegalArgumentException.class, () -> t.autoComplete(""));
    }

    @Test
    public void shouldAutoCorrectWordNotFound() {
        Trie t = new Trie();
        final List<String> words = List.of("word", "worker", "starter", "cube", "candle", "cat", "canter");
        words.forEach(t::insert);
        final String result = t.autoCorrect("wors");
        MatcherAssert.assertThat(result, Matchers.equalTo("word"));
    }
    @Test
    public void shouldAutoCorrectWordNotFound2() {
        Trie t = new Trie();
        final List<String> words = List.of("word", "worker", "starter", "cube", "candle", "cat", "canter");
        words.forEach(t::insert);
        final String result = t.autoCorrect("cae");
        MatcherAssert.assertThat(result, Matchers.equalTo("cat"));
    }

    @Test
    public void shouldAutoCorrectWordFound() {
        Trie t = new Trie();
        final List<String> words = List.of("word", "worker", "starter", "cube", "candle", "cat", "canter");
        words.forEach(t::insert);
        MatcherAssert.assertThat(t.autoCorrect("word"), Matchers.equalTo("word"));
        MatcherAssert.assertThat(t.autoCorrect("cube"), Matchers.equalTo("cube"));
    }

    @Test
    public void shouldThrowExceptionWhenAutoCorrectWordEmpty() {
        Trie t = new Trie();
        final List<String> words = List.of("word", "worker", "starter", "cube", "candle", "cat", "canter");
        words.forEach(t::insert);
        assertThrows(IllegalArgumentException.class, () -> t.autoCorrect(""));
    }

    @Test
    public void shouldThrowExceptionWhenAutoCorrectWordNull() {
        Trie t = new Trie();
        final List<String> words = List.of("word", "worker", "starter", "cube", "candle", "cat", "canter");
        words.forEach(t::insert);
        assertThrows(IllegalArgumentException.class, () -> t.autoCorrect(null));
    }

    @Test
    public void shouldThrowExceptionWhenAutoCorrectWordWithPrefixIsNotFound() {
        Trie t = new Trie();
        final List<String> words = List.of("word", "worker", "starter", "cube", "candle", "cat", "canter");
        words.forEach(t::insert);
        assertThrows(IllegalArgumentException.class, () -> t.autoCorrect("ant"));
    }


    @Test
    public void shouldThrowExceptionWhenPrintKeysIsEmpty() {
        Trie t = new Trie();
        assertThrows(IllegalArgumentException.class, t::printAllKeys);
    }

    @Test
    public void shouldPrintKeysIsTrie() {
        Trie t = new Trie();
        final List<String> words = List.of("word", "worker");
        words.forEach(t::insert);
        final List<Character> results = t.printAllKeys();
        MatcherAssert.assertThat(results, Matchers.containsInAnyOrder(List.of('w','o','r','d','*','k','e','r','*').toArray()));
    }

}