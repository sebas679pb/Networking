package co.edu.escuelaing.networking;

import java.io.*;
import java.net.*;

public class MathServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        int op = 2;
        while ((inputLine = in.readLine()) != null) {
            Double result = (double) 0;
            if(inputLine.equals("fun:sin")){
                op = 1;
                outputLine = "Operacion modificada a seno.";
                out.println(outputLine);
            }else if(inputLine.equals("fun:cos")){
                op = 2;
                outputLine = "Operacion modificada a coseno.";
                out.println(outputLine);
            }else if(inputLine.equals("fun:tan")){
                op = 3;
                outputLine = "Operacion modificada a tangente.";
                out.println(outputLine);
            }else{
                if(op == 1){
                    result = Math.sin(Double.parseDouble(inputLine));
                }else if(op == 2){
                    result = Math.cos(Double.parseDouble(inputLine));
                }else{
                    result = Math.tan(Double.parseDouble(inputLine));
                }
                outputLine = "El resultado de la operacion es:" + String.valueOf(result);
                out.println(outputLine);
            }
            System.out.println("Mensaje:" + inputLine);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

}
