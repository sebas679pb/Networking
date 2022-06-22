package co.edu.escuelaing.networking;

import java.net.*;
import java.io.*;

public class RequestProcessor implements Runnable {

    private Socket clientSocket;

    public RequestProcessor(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String path = HttpServerMulti.getPath(in);
            HttpServerMulti.serverAnswer(path, clientSocket);
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    
}
