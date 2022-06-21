package co.edu.escuelaing.networking;

import java.net.*;
import java.io.*;

public class HttpServerMulti {

    private static HttpServerMulti _instance = new HttpServerMulti();

    public static HttpServerMulti getInstance() {
        return _instance;
    }

    /**
     * Ejercicio 4.5.1
     * Servidor web que soporta multiples solicitudes seguidas (no concurrentes).
     * @param args
     * @throws IOException
     */
    public void main() throws IOException {
        ServerSocket serverSocket = serverSocketInit();
        boolean running = true;
        while (running) {
            Socket clientSocket = clientSocketInit(serverSocket);

            PrintStream out = new PrintStream(new BufferedOutputStream(clientSocket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            String filePath = null;
            String path = null;
            boolean firstLine = true;
            while ((inputLine = in.readLine()) != null) {
                if (firstLine) {
                    path = inputLine.split(" ")[1];
                    path = path.replace("/", "");
                    filePath = "resources\\" + path;
                    System.out.println(path);
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
                    filePath = "resources\\index.html";
                    path = "index.html";
                }

                if (filePath.endsWith(".html")) {
                    type = "text/html";
                } else if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
                    type = "image/jpeg";
                } else if(filePath.endsWith(".js")){
                    type = "application/json; charset=utf-8";
                }
                InputStream inStream = new FileInputStream(path);
                out.print("HTTP/1.1 200 OK\r\n" +
                        "Content-type: " + type + "\r\n\r\n");
                while ((len = inStream.read(fileData)) > 0) {
                    out.write(fileData, 0, len);
                }
            } catch (Exception e) {
                out.println("HTTP/1.1 404 Not Found\r\n" +
                        "Content-type: text/html\r\n\r\n");
                filePath = "resources\\notFound.html";
                path = "notFound.html";
                InputStream inStream = new FileInputStream(path);
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

    private ServerSocket serverSocketInit() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + getPort());
            System.exit(1);
        }
        return serverSocket;
    }

    private Socket clientSocketInit(ServerSocket serverSocket) {
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        return clientSocket;
    }

    private int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt((System.getenv("PORT")));
        }
        return 35000;
    }
    
}
