package section20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NodeTest {

    @Test
    public void TestNewNode() {
        Node<String> node = new Node<>("Test 1");
        Node<String> node2 = new Node<>("Test 2", node);

        Assertions.assertEquals("Test 1",node.data);
        Assertions.assertEquals("Test 2",node2.data);
        Assertions.assertEquals("Test 1",node2.next.data);


    }

}