import math

# Definir las funciones para las operaciones aritméticas
def suma(a, b):
    return a + b
def resta(a, b):
    return a - b
def multiplicacion(a, b):
    return a * b
def division(a, b):
    if b == 0:
        return "Error: No se puede dividir por cero."
    else:
        return a / b
        
# Funciones para otras operaciones
def raiz_cuadrada(a):
    if a < 0:
        return "Error: No se puede calcular la raíz cuadrada de un número negativo."
    else:
        return math.sqrt(a)
def raiz_n(a, n):
    if a < 0 and n % 2 == 0:
        return "Error: No se puede calcular la raíz par de un número negativo."
    else:
        return a ** (1/n)
def exponencial(a, b):
    return a ** b
def seno(a):
    return math.sin(a)
def coseno(a):
    return math.cos(a)
def tangente(a):
    return math.tan(a)
def arcoseno(a):
    return math.asin(a)
def arcocoseno(a):
    return math.acos(a)
def arcotangente(a):
    return math.atan(a)

# Función principal
def calculadora():
    operaciones = {
        "suma": suma,
        "resta": resta,
        "multiplicacion": multiplicacion,
        "division": division,
        "raiz_cuadrada": raiz_cuadrada,
        "raiz_n": raiz_n,
        "exponencial": exponencial,
        "seno": seno,
        "coseno": coseno,
        "tangente": tangente,
        "arcseno": arcoseno,
        "arccoseno": arcocoseno,
        "arctangente": arcotangente
    }
    while True:
        try:
            operacion = input("\nIngrese la operación (suma, resta, multiplicacion, division, raiz_cuadrada, raiz_n, exponencial, seno, coseno, tangente, arcseno, arccoseno, arctangente): ")
            if operacion in operaciones:
                if operacion == "raiz_cuadrada":
                    num = float(input("Ingrese el número para calcular la raíz cuadrada: "))
                    resultado = operaciones[operacion](num)
                elif operacion == "raiz_n":
                    num = float(input("Ingrese el número: "))
                    n = int(input("Ingrese el índice de la raíz: "))
                    resultado = operaciones[operacion](num, n)
                elif operacion in ["seno", "coseno", "tangente", "arcseno", "arccoseno", "arctangente"]:
                    num = float(input("Ingrese el ángulo en radianes: "))
                    resultado = operaciones[operacion](num)
                else:
                    num1 = float(input("\nIngrese el primer número: "))
                    num2 = float(input("Ingrese el segundo número: "))
                    resultado = operaciones[operacion](num1, num2)
                print("El resultado es:", resultado)
            else:
                print("Operación no válida. Intente nuevamente.")
        except ValueError:
            print("Entrada inválida. Intente nuevamente.")
        continuar = input("\n¿Desea realizar otra operacion? (s/n): ")
        if continuar.lower() != "s":
            break
# Llamar a la función principal
calculadora()