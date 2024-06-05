import matplotlib.pyplot as plt
import numpy as np
import math
from abc import ABC, abstractmethod

class Figure(ABC):
    @abstractmethod
    def getColor(self):
        pass

    @abstractmethod
    def perimetro(self):
        pass

    @abstractmethod
    def area(self):
        pass

    @abstractmethod
    def draw(self, ax):
        pass

class Triangle(Figure):
    def __init__(self, color, a, b, c):
        self.color = color
        self.a = a
        self.b = b
        self.c = c

    def getColor(self):
        return self.color

    def perimetro(self):
        return self.a + self.b + self.c

    def area(self):
        s = self.perimetro() / 2
        return math.sqrt(s * (s - self.a) * (s - self.b) * (s - self.c))

    def draw(self, ax):
        x = [0, self.a, self.b, 0]
        y = [0, 0, self.c, 0]
        ax.fill(x, y, facecolor=self.color, edgecolor='black')
        ax.plot(x, y, color="black")

class Circle(Figure):
    def __init__(self, color, radius):
        self.color = color
        self.radius = radius

    def getColor(self):
        return self.color

    def perimetro(self):
        return 2 * math.pi * self.radius

    def area(self):
        return math.pi * self.radius**2

    def draw(self, ax):
        circle = plt.Circle((0, 0), self.radius, facecolor=self.color, edgecolor='black')
        ax.add_patch(circle)

class Rectangle(Figure):
    def __init__(self, color, width, height):
        self.color = color
        self.width = width
        self.height = height

    def getColor(self):
        return self.color

    def perimetro(self):
        return 2 * (self.width + self.height)

    def area(self):
        return self.width * self.height

    def draw(self, ax):
        rect = plt.Rectangle((0, 0), self.width, self.height, facecolor=self.color, edgecolor='black')
        ax.add_patch(rect)

class Hexagon(Figure):
    def __init__(self, color, side):
        self.color = color
        self.side = side

    def getColor(self):
        return self.color

    def perimetro(self):
        return 6 * self.side

    def area(self):
        return (3 * math.sqrt(3) * self.side**2) / 2

    def draw(self, ax):
        angle = np.linspace(0, 2 * np.pi, 7)
        x = self.side * np.cos(angle)
        y = self.side * np.sin(angle)
        ax.fill(x, y, facecolor=self.color, edgecolor='black')
        ax.plot(x, y, color="black")

# Demonstración de polimorfismo
figures = [
    Triangle("red", 3, 4, 5),
    Circle("blue", 10),
    Rectangle("green", 4, 7),
    Hexagon("yellow", 6)
]

fig, axs = plt.subplots(2, 2, figsize=(10, 10))
axs = axs.flatten()

for ax, figure in zip(axs, figures):
    ax.set_aspect('equal')
    figure.draw(ax)
    ax.set_title(f"Color: {figure.getColor()}\nPerimeter: {figure.perimetro():.2f}, Area: {figure.area():.2f}")

plt.tight_layout()
plt.show()
