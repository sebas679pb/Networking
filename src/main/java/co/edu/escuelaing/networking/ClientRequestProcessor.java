package co.edu.escuelaing.networking;

import java.io.*;
import java.net.*;
import java.net.UnknownHostException;

public class ClientRequestProcessor implements Runnable {

    int port;

    public ClientRequestProcessor(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        Socket socket = socketLinked();
        PrintWriter out = null;
        try {
            out = new PrintWriter(socket.getOutputStream());

        } catch (Exception e) {
            System.out.println(socket);
        }
        out.close();
    }

    private Socket socketLinked() {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", port);
        } catch (UnknownHostException e) {
            System.err.println("Host no identificado");
            System.exit(1);
        } catch (IOException e) {
            return socketLinked();
        }
        return socket;
    }
    
}
