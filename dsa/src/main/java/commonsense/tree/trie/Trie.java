package commonsense.tree.trie;

import java.util.*;

public class Trie {
    private final Node root;

    public Node getRoot() {
        return root;
    }

    public Trie() {
        this.root = new Node();
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
        if (root == null || root.getChildren().size() < 1) {
            throw new IllegalArgumentException();
        }
        final ArrayList<String> words = new ArrayList<>();
        printAll(root,"", words);
        return words;
    }

    private void printAll(Node node, String word, ArrayList<String> words) {
        final HashMap<Character, Node> children = node.getChildren();
        for (Character c : children.keySet()) {
            if (c.equals('*')) {
                words.add(word);
                return;
            } else {
                printAll(children.get(c),word + c, words);
            }
        }
    }

    public List<String> autoComplete(String word) throws IllegalArgumentException {
        if (word == null || word.length() < 1) {
            throw new IllegalArgumentException();
        }
        // if search throws exception, then word not found
        final Node searchRoot = search(word);
        final ArrayList<String> words = new ArrayList<>();
        printAll(searchRoot,word, words);
        return words;
    }


    public String autoCorrect(String prefix) throws IllegalArgumentException {
        if (prefix == null || prefix.length() < 1) {
            throw new IllegalArgumentException();
        }
        final ArrayList<String> words = new ArrayList<>();
        autoCompletePrefix(root,prefix, words);
        if (words.size() < 1) {
            throw new IllegalArgumentException("no word found");
        } else {
            return words.get(0);
        }
    }

    private void autoCompletePrefix(Node node, String prefix, ArrayList<String> words) {
        words.add(prefix);

//        final HashMap<Character, Node> children = node.getChildren();
//        for (Character c : children.keySet()) {
//            if (c.equals('*')) {
//                words.add(word);
//                return;
//            } else {
//                printAll(children.get(c),word + c, words);
//            }
//        }
    }
}

