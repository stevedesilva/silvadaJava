package commonsense.tree.trie;

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
    void search() {
    }

    @Test
    void printAll() {
    }
}