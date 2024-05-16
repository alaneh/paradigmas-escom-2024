import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class LecturaNumeros extends BufferedReader {

    // Constructor que prepara la lectura por medio del teclado
    public LecturaNumeros() {
        super(new InputStreamReader(System.in));
    }

    // Constructor que toma un Reader como parámetro
    public LecturaNumeros(Reader r) {
        super(r);
    }

    // Método para leer un int de la entrada estándar
    public int readInt() throws IOException {
        return Integer.parseInt(this.readLine());
    }

    // Método para leer un int con un mensaje
    public int readInt(String mensaje) throws IOException {
        System.out.print(mensaje);
        return Integer.parseInt(this.readLine());
    }

    // Método para leer un Integer de la entrada estándar
    public Integer readInteger() throws IOException {
        return Integer.valueOf(this.readLine());
    }

    // Método para leer un double de la entrada estándar
    public double readDouble() throws IOException {
        return Double.parseDouble(this.readLine());
    }

    // Método para leer un double con un mensaje
    public double readDouble(String mensaje) throws IOException {
        System.out.print(mensaje);
        return Double.parseDouble(this.readLine());
    }
}

