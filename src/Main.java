import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        String IPAddress = "127.0.0.1"; // Choose an IPAddress for the Socket.IO server
        int port = 12345; // Choose a port for the Socket.IO server
        int expectedInfoCount = 100; // Define the expected number of data will be received 

        try (ServerSocket serverSocket = new ServerSocket(port, 0, InetAddress.getByName(IPAddress))) {
            System.out.println("Server is running and listening on " + IPAddress + ":" + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                byte[] buffer = new byte[1024];
                int bytesRead;

                int receivedInfoCount = 0;
                long startTime = System.currentTimeMillis();

                while ((bytesRead = in.read(buffer)) != -1) {
                    // System.out.write(buffer, 0, bytesRead);
                    receivedInfoCount++;

                    // If all expected track info items have been received, calculate and print the time
                    if (receivedInfoCount == expectedInfoCount) {
                        long elapsedTime = System.currentTimeMillis() - startTime;
                        System.out.println("Time to receive all data (ms): " + elapsedTime);

                        // Reset counters and timers for the next interval
                        receivedInfoCount = 0;
                        startTime = System.currentTimeMillis();
                    }
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
