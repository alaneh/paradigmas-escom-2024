public class Rectangulo {
    private String color;
    private double base;
    private double altura;

    public Rectangulo(String color, double base, double altura) {
        this.color = color;
        this.base = base;
        this.altura = altura;
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
        return base * altura;
    }

    private double perimetro() {
        return 2 * (base + altura);
    }
}