# Chat_Application
This is a simple Java-based client application for real-time chat communication over a network. It connects to a server using a specified IP address and port, allowing users to send and receive messages. The application reads user input from the console and displays messages received from the server.

#Features
->Connects to a chat server using an IP address and port.
->Reads user input from the console and sends it to the server.
->Listens for messages from the server and displays them in the console.
->Cleanly handles closing of resources on exit.

#How It Works
Connecting to the Server: The client establishes a connection to the server using a socket.
Input and Output Streams: Initializes input and output streams for communication.
Listening for Messages: Continuously reads and displays messages from the server.
Sending Messages: Continuously reads user input from the console and sends it to the server.
Closing the Connection: Gracefully closes all resources when the client stops.
