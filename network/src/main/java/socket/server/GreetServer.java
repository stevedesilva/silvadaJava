package socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        System.out.println("Starting Server ...");
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("reading message ...");
        String inputLine, response;

        while ((inputLine = in.readLine()) != null){
            if ("Done".equals(inputLine)) {
                out.println("good bye");
                break;
            }
            out.println(inputLine);
        }

        System.out.println("End Server ...");
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        serverSocket.close();
        clientSocket.close();
    }

    public static void main(String[] args) {
        GreetServer greetServer = new GreetServer();
        try {
            greetServer.start(9999);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
