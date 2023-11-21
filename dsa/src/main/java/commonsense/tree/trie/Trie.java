package commonsense.tree.trie;

import java.util.List;

public class Trie {
    private Node root;

    public Trie() {
        this.root = new Node();
    }
    public Trie(Node root) {
        this.root = root;
    }

    public void insert(String word) throws IllegalArgumentException {
        if (word == null || word.length() < 1) {
            throw new IllegalArgumentException();
        }
        throw new UnsupportedOperationException();
    }

    public Node search(String word) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public List<String> printAll() throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

}

