import math

class HexagonoRegular:
    def __init__(self, lado, color):
        self.__lado = lado
        self.__color = color
    
    def __area(self):
        return (3 * math.sqrt(3) * self.__lado ** 2) / 2
    
    def __perimetro(self):
        return 6 * self.__lado
    
    def getArea(self):
        return self.__area()
    
    def getPerimetro(self):
        return self.__perimetro()
    
    def getColor(self):
        return self.__color

class Rombo:
    def __init__(self, diagonal_mayor, diagonal_menor, color):
        self.__diagonal_mayor = diagonal_mayor
        self.__diagonal_menor = diagonal_menor
        self.__color = color
    
    def __area(self):
        return (self.__diagonal_mayor * self.__diagonal_menor) / 2
    
    def __perimetro(self):
        return 4 * math.sqrt((self.__diagonal_mayor / 2) ** 2 + (self.__diagonal_menor / 2) ** 2)
    
    def getArea(self):
        return self.__area()
    
    def getPerimetro(self):
        return self.__perimetro()
    
    def getColor(self):
        return self.__color

class Trapecio:
    def __init__(self, base_mayor, base_menor, altura, color):
        self.__base_mayor = base_mayor
        self.__base_menor = base_menor
        self.__altura = altura
        self.__color = color
    
    def __area(self):
        return ((self.__base_mayor + self.__base_menor) * self.__altura) / 2
    
    def __perimetro(self):
        lado_oblicuo = math.sqrt(((self.__base_mayor - self.__base_menor) / 2) ** 2 + self.__altura ** 2)
        return self.__base_mayor + self.__base_menor + 2 * lado_oblicuo
    
    def getArea(self):
        return self.__area()
    
    def getPerimetro(self):
        return self.__perimetro()
    
    def getColor(self):
        return self.__color

if __name__ == '__main__':

    print(f'''      
          Resultados de las figuras geométricas como objetos
          
          ''')
    hexagono = HexagonoRegular(5, 'azul')
    print("Área del hexágono:", hexagono.getArea())
    print("Perímetro del hexágono:", hexagono.getPerimetro()) 
    print("Color del hexágono:", hexagono.getColor())

    rombo = Rombo(6, 4, 'verde')
    print("\nÁrea del rombo:", rombo.getArea())
    print("Perímetro del rombo:", rombo.getPerimetro())
    print("Color del rombo:", rombo.getColor())

    trapecio = Trapecio(8, 5, 4, 'rojo')
    print("\nÁrea del trapecio:", trapecio.getArea())
    print("Perímetro del trapecio:", trapecio.getPerimetro())
    print("Color del trapecio:", trapecio.getColor())

hexagono = HexagonoRegular(5, 'azul')
print("Área del hexágono:", hexagono.getArea())
print("Perímetro del hexágono:", hexagono.getPerimetro())
print("Color del hexágono:", hexagono.getColor())

rombo = Rombo(6, 4, 'verde')
print("\nÁrea del rombo:", rombo.getArea())
print("Perímetro del rombo:", rombo.getPerimetro())
print("Color del rombo:", rombo.getColor())

trapecio = Trapecio(8, 5, 4, 'rojo')
print("\nÁrea del trapecio:", trapecio.getArea())
print("Perímetro del trapecio:", trapecio.getPerimetro())
print("Color del trapecio:", trapecio.getColor())

