import random
import time

def generar():
    with open("numeros.txt", "w") as archivo:
        for i in range(1, 1001):
            archivo.write(str(i) + "\n")

def leer(filename):
    numeros = []
    with open(filename, "r") as archivo:
        for linea in archivo:
            numeros.append(int(linea.strip()))
    return numeros

def escribir(numeros, filename):
    with open(filename, "w") as archivo:
        for num in numeros:
            archivo.write(str(num) + "\n")
    print(f"Se escribió en el archivo '{filename}'")

# Función para búsqueda secuencial
def busqueda_secuencial(numeros, dato):
    for i, num in enumerate(numeros):
        if num == dato:
            return True, i
    return False, -1


def main():
    inicio = time.time()
    
    generar()
    numeros = leer("numeros.txt")
    random.shuffle(numeros)
    escribir(numeros, "numeros_aleatorios.txt")
    print("Archivo de texto de números aleatorios generado")

    dato = int(input("Ingrese el número a buscar: "))
    encontrado, posicion = busqueda_secuencial(numeros, dato)
    if encontrado:
        print(f"El número {dato} fue encontrado en la posición {posicion}")
    else:
        print(f"El número {dato} no fue encontrado en el archivo")

    numeros.sort()
    escribir(numeros, "numeros_ordenados.txt")
    
    fin = time.time()
    tiempo_ejecucion = fin - inicio
    print(f"Tiempo de ejecución: {tiempo_ejecucion:.6f} segundos")
    

if __name__ == "__main__":
    main()
