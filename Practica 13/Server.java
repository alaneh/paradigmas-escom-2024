
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 5000; // Puerto en el que el servidor escuchará
        int numcliente = 0;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor iniciado, escuchando en el puerto: " + port);

            // El servidor necesita correr indefinidamente
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept(); // Aceptar una conexión de un cliente
                    System.out.println("Cliente conectado");

                    // Abrir un stream para leer lo que el cliente está enviando
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String inputLine = in.readLine(); // Leer los datos enviados por el cliente
                    System.out.println("Mensaje del Cliente: " + inputLine);
                    // Envia un mensaje al cliente indicandole que numero de cliente es
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    numcliente ++;
                    out.println("Hola Cliente, te conectaste con exito al servidor, eres el cliente numero " + numcliente);
                    // Cerrar la conexión con el cliente después de recibir el mensaje
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Exception caught when trying to listen on port " + port + " or listening for a connection");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + port);
            System.out.println(e.getMessage());
        }
    }
}
