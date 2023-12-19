package commonsense.tree.trie;

import java.util.*;
import java.util.stream.Collectors;

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
        String wordToFind = "";
        Node current = root;
        for (Character prefixChar : prefix.toCharArray()) {
            final HashMap<Character, Node> children = current.getChildren();
            if (children.containsKey(prefixChar)) {
                wordToFind += prefixChar;
                current = children.get(prefixChar);
            } else {

                printAll(current, wordToFind, words);
                if (words.isEmpty()) {
                    throw new IllegalArgumentException();
                } else {
                    return words.get(0);
                }
            }
        }
        return wordToFind;

    }

    public String autoCorrectAlt(String prefix) throws IllegalArgumentException {
        if (prefix == null || prefix.length() < 1) {
            throw new IllegalArgumentException();
        }
        final ArrayList<Character> word = new ArrayList<>();
        final boolean found = autoCompletePrefix(root, prefix, word);
        if (word.size() < 1) {
            throw new IllegalArgumentException("no word found");
        } else {
            final String foundWordPrefix = word.stream().map(String::valueOf).collect(Collectors.joining());
            if (found) {
                return foundWordPrefix;
            } else {
                // get
                final List<String> words = autoComplete(foundWordPrefix);
                if (words == null || word.size() < 1) {
                    return foundWordPrefix;
                } else {
                    return words.get(0);
                }
            }
        }
    }

    private boolean autoCompletePrefix(Node node, String prefix, ArrayList<Character> word) {

        for (Character prefixChar : prefix.toCharArray()) {
            final HashMap<Character, Node> children = node.getChildren();
            if (children.containsKey(prefixChar)) {
                final Node childNode = children.get(prefixChar);
                word.add(prefixChar);
                final String updatePrefix = prefix.substring(1);
                autoCompletePrefix(childNode, updatePrefix, word);
            } else {
                return false;
            }
        }
        return true;
    }



    public List<Character> printAllKeys() throws IllegalArgumentException {
        if (root.getChildren().size() < 1) {
            throw new IllegalArgumentException("minimum input required");
        }
        List<Character> keys = new ArrayList<>();
        printAllKeys(root,keys);
        return keys;
    }

    private void printAllKeys(Node root, List<Character> keys) {
        final HashMap<Character, Node> children = root.getChildren();
        for (Character key : children.keySet()) {
            keys.add(key);
            if (key.equals('*')) {
                return;
            } else {
                final Node node = children.get(key);
                printAllKeys(node,keys);
            }
        }
    }
}

