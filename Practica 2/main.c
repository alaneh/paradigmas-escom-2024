#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int generate_list_random(int n, int *lista) {
    srand(time(NULL));

    for (int i = 0; i < n; i++) {
        lista[i] = rand() % 200 - 100;
    }
    return 0;
}

int minv2(int *lista, int n) {
    int mini = lista[0];
    for (int i = 1; i < n; i++) {
        if (lista[i] < mini) {
            mini = lista[i];
        }
    }
    return mini;
}

int maxv2(int *lista, int n) {
    int maxi = lista[0];
    for (int i = 1; i < n; i++) {
        if (lista[i] > maxi) {
            maxi = lista[i];
        }
    }
    return maxi;
}

void sumar_listas(int *lista1, int *lista2, int n, int *suma_listas) {
    for (int i = 0; i < n; i++) {
        suma_listas[i] = lista1[i] + lista2[i];
    }
}

int main() {
    const int n = 10; 
    int lista1[n], lista2[n], suma_listas[n];
    generate_list_random(n, lista1);

    // Generar lista2 con números aleatorios diferentes a lista1
    srand(time(NULL)); 
    generate_list_random(n, lista2);
    for (int i = 0; i < n; i++) {
        while (lista2[i] == lista1[i]) {
            lista2[i] = rand() % 200 - 100;
        }
    }
printf("Lista 1: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", lista1[i]);
    }
    printf("\n");
    printf("Lista 2: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", lista2[i]);
    }
    printf("\n");

    printf("\nEl mínimo de lista 1 es %d\n", minv2(lista1, n));
    printf("El máximo de lista 1 es %d\n\n", maxv2(lista1, n));
    printf("El mínimo de lista 2 es %d\n", minv2(lista2, n));
    printf("El máximo de lista 2 es %d\n", maxv2(lista2, n));

    clock_t start_time = clock(); // Calcular el tiempo
    sumar_listas(lista1, lista2, n, suma_listas);
    clock_t end_time = clock();
    double execution_time = (double)(end_time - start_time) / CLOCKS_PER_SEC;

    printf("\nListas sumadas: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", suma_listas[i]);
    }
    printf("\n");

    // Suma total de las listas
    int suma_total = 0;
    for (int i = 0; i < n; i++) {
        suma_total += suma_listas[i];
    }
    printf("Listas sumadas (total): %d\n", suma_total);
    printf("\nTiempo de ejecución: %f seconds\n", execution_time);
return 0;
}