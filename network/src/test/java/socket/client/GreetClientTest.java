package socket.client;

import org.junit.jupiter.api.*;
import java.io.IOException;

class GreetClientTest {
    private GreetClient greetClient;

    @BeforeEach
    public  void setUp() {
        greetClient = new GreetClient();
        try {
            greetClient.startConnection("127.0.0.1",9999);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @AfterEach
    public void tearDown() {
        try {
            greetClient.stopConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws IOException {
        final String hello_server = greetClient.sendMessage("hello server");
        Assertions.assertEquals("hello server", hello_server);
//        Assertions.assertEquals("hello server 1", greetClient.sendMessage("hello server 1"));
//        Assertions.assertEquals("hello server 2", greetClient.sendMessage("hello server 2"));
//        Assertions.assertEquals("good bye", greetClient.sendMessage("Done"));
    }

}