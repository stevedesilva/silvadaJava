package commonsense.tree.trie;

import java.util.List;

public class Trie {
    private Node root;

    public Node getRoot() {
        return root;
    }

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
        Node currentNode = root;
        for (Character c: word.toCharArray()) {
            if(currentNode.getChildren().containsKey(c)) {
                currentNode = currentNode.getChildren().get(c);
            } else {
                final Node newNode = new Node();
                currentNode.getChildren().put(c, newNode);
                currentNode = newNode;
            }
        }
        currentNode.getChildren().put('*', null);
    }

    public Node search(String word) throws IllegalArgumentException {
        if (word == null || word.length() < 1) {
            throw new IllegalArgumentException();
        }
        Node current = root;
        for(Character character :  word.toCharArray()) {
            if(current.getChildren().containsKey(character)) {
                current= current.getChildren().get(character);
            } else {
                throw new  IllegalArgumentException("not found");
            }

        }
        return current;
    }

    public List<String> printAll() throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

}

