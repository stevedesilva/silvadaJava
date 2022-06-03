package socket.client;

import java.io.*;
import java.net.Socket;

public class GreetClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        System.out.println("client start connection...");
        clientSocket = new Socket(ip,port);
        out = new PrintWriter(clientSocket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("client start connection end");
    }

    public void stopConnection() throws IOException {
        System.out.println("client stopConnection...");
        in.close();
        out.close();
        clientSocket.close();
        System.out.println("client stopConnection end");
    }

    public String sendMessage(String message) throws IOException {
        System.out.println("client sendMessage: " + message);
        out.println(message);
        String resp = in.readLine();
        return resp;
    }
//    public static void main(String[] args) throws IOException {
//        GreetClient server = new GreetClient();
//        server.startConnection("127.0.0.1",9999);
//        System.out.println("main sendMessage..");
//
//        String res = server.sendMessage("hello server");
//        System.out.println(res);
//
//        res = server.sendMessage("hello server");
//        System.out.println(res);
//    }
}
