from abc import ABC, abstractmethod
import math

class Figure(ABC):
    def __init__(self, color):
        self.color = color

    def getColor(self):
        return self.color

    @abstractmethod
    def perimetro(self):
        pass

    @abstractmethod
    def area(self):
        pass

class Triangle(Figure):
    def __init__(self, color, a, b, c):
        super().__init__(color)
        self.a = a
        self.b = b
        self.c = c

    def perimetro(self):
        return self.a + self.b + self.c

    def area(self):
        s = self.perimetro() / 2
        return math.sqrt(s * (s - self.a) * (s - self.b) * (s - self.c))

class Circle(Figure):
    def __init__(self, color, radius):
        super().__init__(color)
        self.radius = radius

    def perimetro(self):
        return 2 * math.pi * self.radius

    def area(self):
        return math.pi * self.radius**2

class Rectangle(Figure):
    def __init__(self, color, width, height):
        super().__init__(color)
        self.width = width
        self.height = height

    def perimetro(self):
        return 2 * (self.width + self.height)

    def area(self):
        return self.width * self.height

class Hexagon(Figure):
    def __init__(self, color, side):
        super().__init__(color)
        self.side = side

    def perimetro(self):
        return 6 * self.side

    def area(self):
        return (3 * math.sqrt(3) * self.side**2) / 2

# Demonstración de polimorfismo
figures = [
    Triangle("Red", 3, 4, 5),
    Circle("Blue", 10),
    Rectangle("Green", 4, 7),
    Hexagon("Yellow", 6)
]

for figure in figures:
    print(f"Color: {figure.getColor()}, Perimeter: {figure.perimetro()}, Area: {figure.area()}")