package co.edu.escuelaing.networking;

import java.net.*;
import java.io.*;

public class HttpServerMulti {

    /**
     * Servidor web que soporta multiples solicitudes seguidas (no concurrentes).
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintStream out = new PrintStream(new BufferedOutputStream(clientSocket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            String filePath = null;
            boolean firstLine = true;
            while ((inputLine = in.readLine()) != null) {
                if (firstLine) {
                    String path = inputLine.split(" ")[1];
                    filePath = "src\\main\\java\\co\\edu\\escuelaing\\networking\\webapp\\" + path.replace("/", "");
                    System.out.println(filePath);
                    firstLine = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }
            byte[] fileData = new byte[2000];
            int len;
            try {
                String type = null;
                if (filePath.endsWith("\\")) {
                    filePath = "src\\main\\java\\co\\edu\\escuelaing\\networking\\webapp\\index.html";
                }

                if (filePath.endsWith(".html")) {
                    type = "text/html";
                } else if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
                    type = "image/jpeg";
                } else if(filePath.endsWith(".js")){
                    type = "application/json; charset=utf-8";
                }
                InputStream inStream = new FileInputStream(filePath);
                out.print("HTTP/1.1 200 OK\r\n" +
                        "Content-type: " + type + "\r\n\r\n");
                while ((len = inStream.read(fileData)) > 0) {
                    out.write(fileData, 0, len);
                }
            } catch (Exception e) {
                out.println("HTTP/1.1 404 Not Found\r\n" +
                        "Content-type: text/html\r\n\r\n");
                filePath = "src\\main\\java\\co\\edu\\escuelaing\\networking\\webapp\\notFound.html";
                InputStream inStream = new FileInputStream(filePath);
                while ((len = inStream.read(fileData)) > 0) {
                    out.write(fileData, 0, len);
                }
            }
            out.close();

            in.close();

            clientSocket.close();
        }
        serverSocket.close();
    }
}
