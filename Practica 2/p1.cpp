#include <bits/stdc++.h>
using namespace std;

vector<int> generate_list_random(int n);

int main() {
    int n;
    cout<<"Introduzca la cantidad deseada\n";
    cin >> n;
    vector<int> lista = generate_list_random(n);
    for(int i = 0; i < n; i++) {
        cout << lista[i] << " ";
    }
    return 0;
}

vector<int> generate_list_random(int n) {
    vector<int> lista;
    srand(time(0)); 
    for(int i = 0; i < n; i++) {
        lista.push_back(rand() % 201 - 100);
    }
    return lista;
}
