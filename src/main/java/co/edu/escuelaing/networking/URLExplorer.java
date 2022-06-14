package co.edu.escuelaing.networking;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLExplorer {
    
    //3.1. Leyendo los valores de un objeto URL
    public static void main(String... args) {
        try{
            URL myURL = new URL("https://ldbn.escuelaing.edu.co:80/index.html#publications");
            System.out.println("Protocol: " + myURL.getProtocol());
            System.out.println("Host: " + myURL.getHost());
            System.out.println("Port: " + myURL.getPort());
            System.out.println("Path: " + myURL.getPath());
            System.out.println("Ref: " + myURL.getRef());
            System.out.println("Authority: " + myURL.getAuthority());
            System.out.println("File: " + myURL.getFile());
            System.out.println("Query: " + myURL.getQuery());
        }catch(MalformedURLException e){
            Logger.getLogger(URLExplorer.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
