#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#ifndef M_PI
#define M_PI 3.14159265358979323846
#endif

// Prototipos de funciones
double suma(double a, double b);
double resta(double a, double b);
double multiplicacion(double a, double b);
double division(double a, double b);
double potencia(double a, double b);
double raiz_cuadrada(double a);
double factorial(double a);
double grados_a_radianes(double grados);
double seno(double a);
double coseno(double a);
double tangente(double a);
int menu();

// Funciones de operaciones matemáticas
double suma(double a, double b) {
    return a + b;
}

double resta(double a, double b) {
    return a - b;
}

double multiplicacion(double a, double b) {
    return a * b;
}

double division(double a, double b) {
    if (b != 0) {
        return a / b;
    } else {
        printf("Error: No se puede dividir por cero.\n");
        exit(EXIT_FAILURE);
    }
}

double potencia(double a, double b) {
    return pow(a, b);
}

double raiz_cuadrada(double a) {
    if (a >= 0) {
        return sqrt(a);
    } else {
        printf("Error: No se puede calcular la raiz cuadrada de un numero negativo.\n");
        exit(EXIT_FAILURE);
    }
}

double factorial(double a) {
    if (a >= 0) {
        if (a == 0) {
            return 1;
        } else {
            return a * factorial(a - 1);
        }
    } else {
        printf("Error: No se puede calcular el factorial de un numero negativo.\n");
        exit(EXIT_FAILURE);
    }
}
double grados_a_radianes(double grados) {
    return grados * M_PI / 180.0;
}
double seno(double a) {
    return sin(a);
}

double coseno(double a) {
    return cos(a);
}

double tangente(double a) {
    return tan(a);
}

// Función para mostrar el menú y obtener la opción del usuario
int menu() {
    int opcion;
    printf("\nSeleccione una operacion:\n");
    printf("1. Suma\n");
    printf("2. Resta\n");
    printf("3. Multiplicacion\n");
    printf("4. Division\n");
    printf("5. Potencia\n");
    printf("6. Raiz cuadrada\n");
    printf("7. Factorial\n");
    printf("8. Seno\n");
    printf("9. Coseno\n");
    printf("10. Tangente\n");
    printf("11. Salir\n");
    printf("Ingrese el numero de la operacion que desea realizar: ");
    scanf("%d", &opcion);
    return opcion;
}

// Función principal
int main() {
    while (1) {
        int opcion = menu();

        if (opcion == 11) {
            printf("Hasta luego\n");
            break;
        }

        double a, b;
        printf("Ingrese el primer numero: ");
        scanf("%lf", &a);
        
        if (opcion != 6 && opcion != 7 && opcion != 8 && opcion != 9 && opcion != 10) {
            printf("Ingrese el segundo numero: ");
            scanf("%lf", &b);
        }

        switch(opcion) {
            case 1:
                printf("Resultado: %.2lf\n", suma(a, b));
                break;
            case 2:
                printf("Resultado: %.2lf\n", resta(a, b));
                break;
            case 3:
                printf("Resultado: %.2lf\n", multiplicacion(a, b));
                break;
            case 4:
                printf("Resultado: %.2lf\n", division(a, b));
                break;
            case 5:
                printf("Resultado: %.2lf\n", potencia(a, b));
                break;
            case 6:
                printf("Resultado: %.2lf\n", raiz_cuadrada(a));
                break;
            case 7:
                printf("Resultado: %.2lf\n", factorial(a));
                break;
            case 8:
                printf("Resultado: %.2lf\n", seno(grados_a_radianes(a)));
                break;
            case 9:
                printf("Resultado: %.2lf\n", coseno(grados_a_radianes(a)));
                break;
            case 10:
                printf("Resultado: %.2lf\n", tangente(grados_a_radianes(a)));
                break;
            default:
                printf("Opcion invalida. Intente nuevamente.\n");
        }
    }
    return 0;
}
