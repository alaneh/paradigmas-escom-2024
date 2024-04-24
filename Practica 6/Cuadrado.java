public class Cuadrado{
    private String color;
    private double lado;

    public Cuadrado(String color, double lado) {
        this.color = color;
        this.lado = lado;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return area();
    }

    public double getPerimetro() {
        return perimetro();
    }

    private double area() {
        return lado * lado;
    }

    private double perimetro() {
        return 4 * lado;
    }
}