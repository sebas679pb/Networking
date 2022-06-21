package co.edu.escuelaing.networking;

public class HttpServerMain {

    public static void main(String[] args) {
        HttpServerMulti server = HttpServerMulti.getInstance();
        try {
            server.main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
