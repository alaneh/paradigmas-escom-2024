# PARTE I
import math
import random

class Punto3D:
    def __init__(self, x=0, y=0, z=0):
        self.__x = x
        self.__y = y
        self.__z = z

    # Métodos set
    def set_x(self, x):
        self.__x = x

    def set_y(self, y):
        self.__y = y

    def set_z(self, z):
        self.__z = z

    # Métodos get
    def get_x(self):
        return self.__x

    def get_y(self):
        return self.__y

    def get_z(self):
        return self.__z

    # Distancia euclidiana entre dos puntos
    def distancia(self, otro_punto):
        dx = self.__x - otro_punto.get_x()
        dy = self.__y - otro_punto.get_y()
        dz = self.__z - otro_punto.get_z()
        return math.sqrt(dx**2 + dy**2 + dz**2)

# Crear los 10 objetos de tipo Punto3D con valores aleatorios
puntos = []
for _ in range(10):
    x = random.uniform(0, 100)
    y = random.uniform(0, 100)
    z = random.uniform(0, 100)
    puntos.append(Punto3D(x, y, z))
#######################################################################################
# PARTE II
# Imprimir los puntos
print("Los 10 puntos son:")
for i, punto in enumerate(puntos, 1):
    print(f"Punto {i}: ({punto.get_x():.2f}, {punto.get_y():.2f}, {punto.get_z():.2f})")

# Calcular todas las distancias y encontrar la menor
menor_distancia = float('inf')  # Inicializar con un valor infinito
punto1 = None
punto2 = None

for i in range(len(puntos)):
    for j in range(i + 1, len(puntos)):
        distancia_actual = puntos[i].distancia(puntos[j])
        if distancia_actual < menor_distancia:
            menor_distancia = distancia_actual
            punto1 = puntos[i]
            punto2 = puntos[j]

print("La menor distancia es:", menor_distancia)
print("Entre los puntos:", f"({punto1.get_x():.2f}, {punto1.get_y():.2f}, {punto1.get_z():.2f})", "y", f"({punto2.get_x():.2f}, {punto2.get_y():.2f}, {punto2.get_z():.2f})")