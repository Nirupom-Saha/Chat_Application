package Project;

import java.io.*;
import java.net.*;

public class ChatClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader userInput;

    public void start(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            System.out.println("Connected to the server.");

            // Initialize input and output streams
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            userInput = new BufferedReader(new InputStreamReader(System.in));

            // Start reading messages from the server
            startListening();

            // Start sending messages to the server
            startTyping();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    private void startListening() throws IOException {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Server: " + inputLine);
        }
    }

    private void startTyping() throws IOException {
        String userInputLine;
        while ((userInputLine = userInput.readLine()) != null) {
            out.println(userInputLine);
        }
    }

    private void stop() {
        try {
            in.close();
            out.close();
            userInput.close();
            socket.close();
            System.out.println("Client closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Use the server's IP address or hostname
        int port = 12345; // Use the same port as the server
        ChatClient client = new ChatClient();
        client.start(serverAddress, port);
    }
}
