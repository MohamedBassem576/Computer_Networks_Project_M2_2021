package computer_network_M2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        String serverIP = "192.168.1.30"; // Replace with the server's IP address
        int serverPort = 5000; // Server port number

        try {
            // Connect to the server
            Socket socket = new Socket(serverIP, serverPort);
            System.out.println("Connected to the server.");

            // Create input and output streams for socket communication
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            // Send "CONNECT" command to the server
            output.println("CONNECT");

            // Read user input from the console and send it to the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while ((message = reader.readLine()) != null) {
                output.println(message);
            }

            // Close the socket and streams
            socket.close();
            input.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
