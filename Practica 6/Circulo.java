public class Circulo {
    private String color;
    private double radio;

    public Circulo(String color, double radio) {
        this.color = color;
        this.radio = radio;
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
        return Math.PI * radio * radio;
    }

    private double perimetro() {
        return 2 * Math.PI * radio;
    }
}
