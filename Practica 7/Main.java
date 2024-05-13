import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Punto3D {
    private double x;
    private double y;
    private double z;

    public punto3D() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
    public Punto3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Métodos set
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    // Métodos get
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    // Distancia euclidiana entre dos puntos
    public double distancia(Punto3D otroPunto) {
        double dx = this.x - otroPunto.getX();
        double dy = this.y - otroPunto.getY();
        double dz = this.z - otroPunto.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Punto3D> puntos = new ArrayList<>();
        Random random = new Random();

        // Crear los 10 objetos de tipo Punto3D con valores aleatorios
        for (int i = 0; i < 10; i++) {
            double x = random.nextDouble() * 100;
            double y = random.nextDouble() * 100;
            double z = random.nextDouble() * 100;
            puntos.add(new Punto3D(x, y, z));
        }

        // Imprimir los puntos
        System.out.println("Los 10 puntos son:");
        for (int i = 0; i < puntos.size(); i++) {
            Punto3D punto = puntos.get(i);
            System.out.printf("Punto %d: (%.2f, %.2f, %.2f)%n", i + 1, punto.getX(), punto.getY(), punto.getZ());
        }

        // Calcular todas las distancias y encontrar la menor
        double menorDistancia = Double.POSITIVE_INFINITY;
        Punto3D punto1 = null;
        Punto3D punto2 = null;

        for (int i = 0; i < puntos.size(); i++) {
            for (int j = i + 1; j < puntos.size(); j++) {
                double distanciaActual = puntos.get(i).distancia(puntos.get(j));
                if (distanciaActual < menorDistancia) {
                    menorDistancia = distanciaActual;
                    punto1 = puntos.get(i);
                    punto2 = puntos.get(j);
                }
            }
        }

        System.out.println("La menor distancia es: " + menorDistancia);
        System.out.println("Entre los puntos: (" + punto1.getX() + ", " + punto1.getY() + ", " + punto1.getZ() + ") y (" +
                punto2.getX() + ", " + punto2.getY() + ", " + punto2.getZ() + ")");
    }
}