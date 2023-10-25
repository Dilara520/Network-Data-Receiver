import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        String IPAddress = "127.0.0.1"; // Choose an IPAddress for the Socket.IO server
        int port = 12345; // Choose a port for the Socket.IO server
        int expectedInfoCount = 20; // Define the expected number of data will be received 

        try (ServerSocket serverSocket = new ServerSocket(port, 0, InetAddress.getByName(IPAddress))) {
            System.out.println("Server is running and listening on " + IPAddress + ":" + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                byte[] buffer = new byte[1134];
                //int bytesRead;

                int receivedInfoCount = 0;
                long startTime = 0;
                boolean timerStarted = false;
                
                while ((in.read(buffer)) != -1) {

                    if (!timerStarted) {
                        startTime = System.currentTimeMillis();
                        timerStarted = true;
                    }
                    
                    //System.out.write(buffer, 0, bytesRead); //to console received data
                    receivedInfoCount++;
                    //System.out.println("\nRECEIVED INFO COUNT: " + receivedInfoCount);

                    // If all expected data have been received, calculate and print the time
                    if (receivedInfoCount == expectedInfoCount) {
                        long endTime = System.currentTimeMillis();
                        System.out.println("TIME TO RECEIVE ALL DATA (ms): " + (endTime - startTime));

                        // Reset counters and timers for the next interval
                        receivedInfoCount = 0;
                        startTime = 0;
                        timerStarted = false;
                    }
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
