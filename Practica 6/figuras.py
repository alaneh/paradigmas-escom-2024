import math

class Hexagono:
    def _init_(self):
        self.__lado = float(input("Ingresa la longitud del lado del hexagono : "))
        self.__color = input("Ingresa el color del hexagono : ")
    
    def area(self):
        return (3 * math.sqrt(3) * self.__lado ** 2) / 2
    
    def perimetro(self):
        return 6 * self.__lado
    
    def getColor(self):
        return self.__color
    
    def getArea(self):
        return self.area()
    
    def getPerimetro(self):
        return self.perimetro()


class Rombo:
    def _init_(self):
        self.__diagonal_M = float(input("Ingresa la longitud de la diagonal mayor del rombo: "))
        self.__diagonal_m = float(input("Ingresa la longitud de la diagonal menor del rombo: "))
        self.__color = input("Ingresa el color del rombo: ")
    
    def area(self):
        return (self._diagonal_M * self._diagonal_m) / 2
    
    def perimetro(self):
        return 4 * math.sqrt(((self._diagonal_mayor / 2) ** 2) + ((self._diagonal_menor / 2) ** 2))
    
    def getColor(self):
        return self.__color
    
    def getArea(self):
        return self.area()
    
    def getPerimetro(self):
        return self.perimetro()

class Trapecio:
    def _init_(self):
        self.__base_M = float(input("Ingresa la longitud de la base mayor del trapecio: "))
        self.__base_m = float(input("Ingresa la longitud de la base menor del trapecio: "))
        self.__altura = float(input("Ingresa la altura del trapecio: "))
        self.__ladoA = float(input("Ingresa la longitud de un lado del trapecio: "))
        self.__ladoB = float(input("Ingresa la longitud del otro lado del trapecio: "))
        self.__color = input("Ingresa el color del trapecio: ")
    
    def area(self):
        return ((self._base_M + self.base_m) * self._altura) / 2
    
    def perimetro(self):
        return self._base_M + self.base_m + self.ladoA + self._ladoB
    
    def getColor(self):
        return self.__color
    
    def getArea(self):
        return self.area()
    
    def getPerimetro(self):
        return self.perimetro()

print("Creando un trapecio:\n")
trapecio = Trapecio()
print("Area del trapecio:", trapecio.getArea())
print("Perimetro del trapecio:", trapecio.getPerimetro())
print("Color del trapecio:", trapecio.getColor())

print("Creando un hexagono:\n")
hexagono = Hexagono()
print("Area del hexagono:", hexagono.getArea())
print("Perímetro del hexagono:", hexagono.getPerimetro())
print("Color del hexagono :\n", hexagono.getColor())

print("Creando un rombo:\n")
rombo = Rombo()
print("Area del rombo:", rombo.getArea())
print("Perímetro del rombo:", rombo.getPerimetro())
print("Color del rombo:\n", rombo.getColor())