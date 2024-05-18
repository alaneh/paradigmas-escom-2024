import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;

public class LecturaNumeros extends BufferedReader {

    // Constructor que prepara la lectura por medio del teclado
    public LecturaNumeros() {
        super(new InputStreamReader(System.in));
    }

    // Constructor que recibe un objeto Reader
    public LecturaNumeros(Reader r) {
        super(r);
    }

    // Método que lee un int de la entrada estándar
    public int readInt() throws IOException {
        return Integer.parseInt(readLine());
    }

    // Método que lee un int de la entrada estándar con un mensaje
    public int readInt(String mensaje) throws IOException {
        System.out.print(mensaje);
        return readInt();
    }

    // Método que lee un Integer de la entrada estándar
    public Integer readInteger() throws IOException {
        return Integer.valueOf(readLine());
    }

    // Método que lee un double de la entrada estándar
    public double readDouble() throws IOException {
        return Double.parseDouble(readLine());
    }

    // Método que lee un double de la entrada estándar con un mensaje
    public double readDouble(String mensaje) throws IOException {
        System.out.print(mensaje);
        return readDouble();
    }

    public static void main(String[] args) {
        try {
            LecturaNumeros ln = new LecturaNumeros();

            try {
                int num1 = ln.readInt("Introduce el primer número entero: ");
                int num2 = ln.readInt("Introduce el segundo número entero: ");
                Integer num3 = ln.readInt("Introduce el tercer número entero (como Integer): ");
                double num4 = ln.readDouble("Introduce el primer número decimal: ");
                double num5 = ln.readDouble("Introduce el segundo número decimal: ");
                
                System.out.println("Números ingresados:");
                System.out.println("Entero 1: " + num1);
                System.out.println("Entero 2: " + num2);
                System.out.println("Entero (Integer): " + num3);
                System.out.println("Decimal 1: " + num4);
                System.out.println("Decimal 2: " + num5);
            } finally {
                ln.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
