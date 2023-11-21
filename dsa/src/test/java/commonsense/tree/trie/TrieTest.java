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

        var firstChar = t.getRoot().getChildren().get('t');
        MatcherAssert.assertThat(firstChar, Matchers.equalTo('t'));
        var secondChar = firstChar.getChildren().get('e');
        MatcherAssert.assertThat(secondChar, Matchers.equalTo('t'));
        var thirdChar = secondChar.getChildren().get('s');
        MatcherAssert.assertThat(thirdChar, Matchers.equalTo('t'));
        var forthChar = thirdChar.getChildren().get('t');
        MatcherAssert.assertThat(forthChar, Matchers.equalTo('t'));
        var fifthChar = forthChar.getChildren().get('*');
        MatcherAssert.assertThat(fifthChar, Matchers.equalTo('t'));

    }

    @Test
    void search() {
    }

    @Test
    void printAll() {
    }
}