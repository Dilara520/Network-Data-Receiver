# Network-Data-Receiver
Network Data Receiver is a Java server-side networking utility that serves as a UDP / TCP server capable of handling incoming data sent periodically. It is designed to assist with various network-related coding projects where you need to receive and measure data arrival times in milliseconds.

## Features

- **Network Data Reception**: Network Data Receiver is a TCP server that listens for incoming data sent over a network connection.

- **Real-time Time Measurement**: It measures the time it takes to receive data in milliseconds, providing real-time feedback on data arrival performance.

- **Batch Data Processing**: Designed to work with periodic data sending, it allows you to receive data in batches, making it suitable for use cases like optimized network coding projects.

- **Data Preview**: You can view the received data, enabling you to inspect and process the data as needed for your project.

## Prerequisites

- Java (JDK 8 or higher)

## Getting Started

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/dilara520/network-data-receiver.git
   
2. Compile the server:

   ```bash
   javac Main.java
   
3. Run the server:

   ```bash
   java Main

4. The server will start listening on the default port (12345) and address (localhost). You can configure the port and address settings in the Main.java file according to your specific requirements.

## Configuration

You can configure the following settings in the Main.java file:

- **int port**: Set the port on which the server listens for incoming data.
- **String address**: Set the address (hostname or IP address) to specify where the server should listen for incoming data.

## Usage

1. Ensure that you have a client that sends data to the server on the configured port and address at regular intervals.
2. The server will measure and print the time it takes to receive data, providing insights into network performance.
3. You can also preview and process the received data according to your project's requirements.
