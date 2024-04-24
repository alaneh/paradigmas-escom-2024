public class main {
    public static void main(String[] args) {
        // Crear nuevas instancias de las figuras
        Circulo circulo = new Circulo("255, 255, 255", 15);
        Rectangulo rectangulo = new Rectangulo("Verde", 40, 90);
        Cuadrado cuadrado = new Cuadrado("Rojo", 37);
        Triangulo triangulo = new Triangulo("Azul", 3,4,5);
        //Circulo
        System.out.println("Area del circulo: " + circulo.getArea());
        System.out.println("Perimetro del circulo: " + circulo.getPerimetro());
        System.out.println("Color del circulo: " + circulo.getColor() + "\n");
        //Rectangulo
        System.out.println("Area del rectangulo: "+ rectangulo.getArea());
        System.out.println("Perimetro del rectangulo: "+ rectangulo.getPerimetro());
        System.out.println("Color del rectangulo: "+ rectangulo.getColor() + "\n");
        //Cuadrado
        System.out.println("Area del cuadrado: " + cuadrado.getArea());
        System.out.println("Perimetro del cuadrado: " + cuadrado.getPerimetro());
        System.out.println("Color del cuadrado: " + cuadrado.getColor() + "\n");
        //Triangulo
        System.out.println("Area del triangulo: " + triangulo.getArea());
        System.out.println("Perimetro del triangulo: " + triangulo.getPerimetro());
        System.out.println("Color del triangulo: " + triangulo.getColor());
    }
}