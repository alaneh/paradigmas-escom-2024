#include <bits/stdc++.h>
using namespace std;

int minv2(vector<int>& lista);
vector<int> generate_list_random(int n);

int main() {
    int n;
    cout<<"Introduzca la cantidad deseada\n";
    cin >> n;
    vector<int> lista = generate_list_random(n);
    for(int i = 0; i < n; i++) {
        cout << lista[i] << " ";
    }
    cout << '\n';
    int minimo = minv2(lista);
    cout << "El minimo de la lista es: " << minimo << endl;
    return 0;
}

int minv2(vector<int>& lista) {
    int mini = lista[0];
    for (size_t i = 1; i < lista.size(); i++) {
        if (lista[i] < mini) {
            mini = lista[i];
        }
    }
    return mini;
}

vector<int> generate_list_random(int n) {
    vector<int> lista;
    srand(time(0)); 
    for(int i = 0; i < n; i++) {
        lista.push_back(rand() % 201 - 100);
    }
    return lista;
}