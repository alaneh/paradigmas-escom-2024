#include <stdio.h>
#include <stdlib.h>
#include <stdlib.h>
#include <time.h>

int *leer_numeros(const char *nombre_archivo, int *tamanio) {
    FILE *archivo;
    int *numeros;
    int numero;
    int contador = 0;

    archivo = fopen(nombre_archivo, "r");
    if (archivo == NULL) {
        printf("No se pudo abrir el archivo '%s'\n", nombre_archivo);
        return NULL;
    }

    // Contar la cantidad de números en el archivo
    while (fscanf(archivo, "%d", &numero) != EOF) {
        contador++;
    }
    rewind(archivo);

    // Asignar memoria para almacenar los números
    numeros = (int *)malloc(contador * sizeof(int));
    if (numeros == NULL) {
        printf("Error de memoria\n");
        fclose(archivo);
        return NULL;
    }

    for (int i = 0; i < contador; i++) {
        fscanf(archivo, "%d", &numeros[i]);
    }

    *tamanio = contador;
    fclose(archivo);
    return numeros;
}

int busqueda_secuencial(int *numeros, int tamanio, int dato, int *posicion) {
    for (int i = 0; i < tamanio; i++) {
        if (numeros[i] == dato) {
            *posicion = i;
            return 1; // Se encontró el dato
        }
    }
    return 0; // No se encontró el dato
}

void ordenar_numeros(int *numeros, int tamanio) {
    for (int i = 0; i < tamanio - 1; i++) {
        for (int j = 0; j < tamanio - i - 1; j++) {
            if (numeros[j] > numeros[j + 1]) {
                int temp = numeros[j];
                numeros[j] = numeros[j + 1];
                numeros[j + 1] = temp;
            }
        }
    }
}

void escribir_numeros_ordenados(const char *nombre_archivo, int *numeros, int tamanio) {
    FILE *archivo;
    archivo = fopen(nombre_archivo, "w");
    if (archivo == NULL) {
        printf("No se pudo abrir el archivo '%s'\n", nombre_archivo);
        return;
    }

    for (int i = 0; i < tamanio; i++) {
        fprintf(archivo, "%d\n", numeros[i]);
    }

    fclose(archivo);
    printf("Numeros ordenados escritos en '%s'\n", nombre_archivo);
}

int main() {
    int *numeros;
    int tamanio;
    int dato;
    int posicion;


    clock_t inicio, fin;
    double tiempo;
    inicio = clock();

    numeros = leer_numeros("numeros_aleatorios.txt", &tamanio);
    if (numeros == NULL) {
        return 1;
    }

    printf("Ingrese el numero a buscar: ");
    scanf("%d", &dato);

    if (busqueda_secuencial(numeros, tamanio, dato, &posicion)) {
        printf("El numero %d fue encontrado en la posicion %d\n", dato, posicion);
    } else {
        printf("El numero %d no fue encontrado en el archivo\n", dato);
    }

    ordenar_numeros(numeros, tamanio);

    escribir_numeros_ordenados("numeros_aleatorios.txt", numeros, tamanio);

    // Liberar la memoria asignada
    free(numeros);

    fin = clock();

    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
    printf("Tiempo de ejecucion: %.6f segundos\n", tiempo);


    return 0;
}
