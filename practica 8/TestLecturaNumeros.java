import java.io.IOException;


public class TestLecturaNumeros {
    public static void main(String[] args) {
        try (LecturaNumeros ln = new LecturaNumeros()) {
            // Leer 2 int
            int numero1 = ln.readInt("Ingresa el primer número entero: ");
            int numero2 = ln.readInt("Ingresa el segundo número entero: ");
            
            // Leer 1 Integer (aquí no se muestra un mensaje adicional)
            System.out.print("Ingresa un número entero (Integer): ");
            Integer numero3 = ln.readInteger();
            
            // Leer 1 double
            double numero4 = ln.readDouble("Ingresa un número de tipo double: ");
            
            // Leer 1 Double (aquí no se muestra un mensaje adicional)
            System.out.print("Ingresa un número de tipo Double: ");
            Double numero5 = ln.readDouble();
            
            // Desplegar los números leídos
            System.out.println("Número entero 1: " + numero1);
            System.out.println("Número entero 2: " + numero2);
            System.out.println("Número Integer: " + numero3);
            System.out.println("Número double: " + numero4);
            System.out.println("Número Double: " + numero5);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

