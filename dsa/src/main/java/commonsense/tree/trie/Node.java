package commonsense.tree.trie;

import jdk.jshell.spi.ExecutionControl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

public class Node {
    private HashMap<Character,Node> children;

    public Node() {
        this.children = new HashMap<>();
    }

    public Node(HashMap<Character, Node> children) {
        this.children = children;
    }


}
