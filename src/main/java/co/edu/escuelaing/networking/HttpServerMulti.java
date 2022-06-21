package co.edu.escuelaing.networking;

import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = serverSocketInit();
        boolean running = true;
        while (running) {
            Socket clientSocket = clientSocketInit(serverSocket);
            RequestProcessor processor = new RequestProcessor(clientSocket);
            threadPool.execute(processor);
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

    public static String getPath(BufferedReader in) throws IOException {
        String inputLine, path = null;
        boolean firstLine = true;
        while ((inputLine = in.readLine()) != null) {
            if (firstLine) {
                path = inputLine.split(" ")[1];
                path = path.replace("/", "");
                System.out.println(path);
                firstLine = false;
            }
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
        return path;
    }

    public static void serverAnswer(String path, Socket clientSocket) throws IOException {
        PrintStream out = new PrintStream(new BufferedOutputStream(clientSocket.getOutputStream()));
        byte[] fileData = new byte[2000];
        int len;
        String filePath = "resources\\" + path;
        System.out.println(filePath);
        try {
            String type = null;
            if (path.equals("")) {
                filePath = "resources\\index.html";
                path = "index.html";
            }

            if (path.endsWith(".html")) {
                type = "text/html";
            } else if (path.endsWith(".jpg") || path.endsWith(".jpeg")) {
                type = "image/jpeg";
            } else if (path.endsWith(".js")) {
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
    }

    private int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt((System.getenv("PORT")));
        }
        return 35000;
    }
    
}
