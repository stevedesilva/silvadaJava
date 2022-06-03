package socket.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import socket.client.GreetClient;

import java.io.IOException;

class EchoMultiServerTest {
    @Test
    public void serverShouldHandleMultipleClientConnections() throws IOException {
        GreetClient greetClient1 = new GreetClient();
        greetClient1.startConnection("127.0.0.1",5555);
        Assertions.assertEquals("hello server", greetClient1.sendMessage("hello server"));
        Assertions.assertEquals("hello server 1", greetClient1.sendMessage("hello server 1"));
        Assertions.assertEquals("hello server 2", greetClient1.sendMessage("hello server 2"));
        Assertions.assertEquals("good bye", greetClient1.sendMessage("Done"));

        greetClient1 = new GreetClient();
        greetClient1.startConnection("127.0.0.1",5555);
        Assertions.assertEquals("hello server", greetClient1.sendMessage("hello server"));
        Assertions.assertEquals("hello server 1", greetClient1.sendMessage("hello server 1"));
        Assertions.assertEquals("hello server 2", greetClient1.sendMessage("hello server 2"));
        Assertions.assertEquals("good bye", greetClient1.sendMessage("Done"));
        greetClient1 = new GreetClient();
        greetClient1.startConnection("127.0.0.1",5555);
        Assertions.assertEquals("hello server", greetClient1.sendMessage("hello server"));
        Assertions.assertEquals("hello server 1", greetClient1.sendMessage("hello server 1"));
        Assertions.assertEquals("hello server 2", greetClient1.sendMessage("hello server 2"));
        Assertions.assertEquals("good bye", greetClient1.sendMessage("Done"));
        greetClient1 = new GreetClient();
        greetClient1.startConnection("127.0.0.1",5555);
        Assertions.assertEquals("hello server", greetClient1.sendMessage("hello server"));
        Assertions.assertEquals("hello server 1", greetClient1.sendMessage("hello server 1"));
        Assertions.assertEquals("hello server 2", greetClient1.sendMessage("hello server 2"));
        Assertions.assertEquals("good bye", greetClient1.sendMessage("Done"));
    }
}