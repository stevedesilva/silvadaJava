package socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoMultiServer {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while(true) {
            System.out.println("Server waiting for connection ...");
            new EchoClientHandler(serverSocket.accept()).start();
        }
    }

    public static class EchoClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                System.out.println("Server accept client connection: " + Thread.currentThread().getName());
                out = new PrintWriter(clientSocket.getOutputStream(),true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null){
                    if ("Done".equals(inputLine)) {
                        out.println("good bye");
                        break;
                    }
                    out.println(inputLine);
                }
                in.close();
                out.close();
                clientSocket.close();
                System.out.println("Server closing client connection: " + Thread.currentThread().getName());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            EchoMultiServer echoMultiServer = new EchoMultiServer();
            echoMultiServer.start(5555);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
