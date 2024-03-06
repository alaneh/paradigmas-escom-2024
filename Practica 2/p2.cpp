#include <bits/stdc++.h>
using namespace std;

vector<int> generate_list_random(int n);

int main() {
    srand(time(0)); // Inicializar la semilla de generación de números aleatorios

    vector<int> lista1 = generate_list_random(10);
    vector<int> lista2 = generate_list_random(10);

    cout << "Lista 1: ";
    for(int i = 0; i < lista1.size(); i++) {
        cout << lista1[i] << " ";
    }
    cout << endl;

    cout << "Lista 2: ";
    for(int i = 0; i < lista2.size(); i++) {
        cout << lista2[i] << " ";
    }
    cout << endl;

    return 0;
}

vector<int> generate_list_random(int n) {
    vector<int> lista;
    for(int i = 0; i < n; i++) {
        lista.push_back(rand() % 201 - 100); // Números aleatorios en el rango [-100, 100]
    }
    return lista;
}
