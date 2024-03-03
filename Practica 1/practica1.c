/*
Elabora un programa, en al menos dos lenguajes diferentes, que realicen lo siguiente:

1 Tenga una función que genere un arreglo de números enteros aleatorios.
2 El tamaño del arreglo será del al menos 1000 elementos.
3 Tenga una función para imprimir el contenido de los arreglos.
4 Proporciona al menos una función de búsqueda secuencial. Ejemplifica la búsqueda para el arreglo del paso 1.

5 Tenga una función que ordene el arreglo generado en el paso 1.  
Ejemplifica la búsqueda con el arreglo resultante del paso 4.

Calcula el tiempo de ejecución de elementos 1 a 5.
Entrega:
Entrega un reporte que describa el diseño y desarrollo de tu programa.
Código fuente y lo necesario para ejecutar este programa. 
En caso de que se trabaje en equipos, cada integrante entregará el código pero indicará a qué equipo pertenece.
Nota: proporcionar el enlace al repositorio de Github en donde cada alumno o equipo subirá sus códigos.

*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

/* Prototipos */
void generar();
void leer(int numeros[], const char* filename);
void shuffle(int array[], int n);
void escribir(int numeros[], const char* filename);
int busqueda_secuencial(int *numeros, int tamanio, int dato, int *posicion);
void ordenar_numeros(int *numeros, int tamanio);

int main() {
    int *numeros = (int *)malloc(1000 * sizeof(int));
    int tamanio = 1000;
    int dato;
    int posicion;

    clock_t inicio, fin;
    double tiempo;
    inicio = clock();
    generar();
    leer(numeros, "numeros.txt");
    shuffle(numeros, 1000);
    escribir(numeros, "numeros_aleatorios.txt");
    printf("%s\n", "Archivo de texto de numeros aleatorios generado");
    
    printf("Ingrese el numero a buscar: ");
    scanf("%d", &dato);

    if (busqueda_secuencial(numeros, tamanio, dato, &posicion)) {
        printf("El numero %d fue encontrado en la posicion %d\n", dato, posicion);
    } else {
        printf("El numero %d no fue encontrado en el archivo\n", dato);
    }

    ordenar_numeros(numeros, tamanio);

    escribir(numeros, "numeros_ordenados.txt");

    free(numeros); /* libera la memoria del arreglo */

    fin = clock();

    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
    printf("Tiempo de ejecucion: %.6f segundos\n", tiempo);

    return 0;
}

// Generador de 1000 numeros, se puede actualizar a n, pero de momento se quedará así
void generar() {
    FILE *archivo;
    archivo = fopen("numeros.txt", "w");
    if (archivo == NULL) {
        printf("Error al abrir el archivo.");
        return;
    }

    for (int i = 1; i <= 1000; i++) {
        fprintf(archivo, "%d\n", i);
    }

    fclose(archivo);
}

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void shuffle(int array[], int n) {
    srand(time(NULL)); 
    for (int i = n - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        swap(&array[i], &array[j]);
    }
}

void leer(int numeros[], const char* filename) {
    FILE *archivo;
    archivo = fopen(filename, "r");
    if (archivo == NULL) {
        printf("Error al abrir el archivo.");
        return;
    }

    int i = 0;
    while (fscanf(archivo, "%d", &numeros[i]) != EOF && i < 1000) {
        i++;
    }

    fclose(archivo);
}

void escribir(int numeros[], const char* filename) {
    FILE *archivo;
    archivo = fopen(filename, "w");
    if (archivo == NULL) {
        printf("Error al abrir el archivo.");
        return;
    }

    for (int i = 0; i < 1000; i++) {
        fprintf(archivo, "%d\n", numeros[i]);
    }
    
    fclose(archivo);
    printf("Se escribio en el archivo '%s'\n", filename);
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
