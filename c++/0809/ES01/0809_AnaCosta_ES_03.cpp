// inserir trˆs n£meros e determinar o maior e menor

#include <iostream>

using namespace std;

int main() {

  int n1, n2, n3, max, min;

  // introduzir n£meros
  cout << "Introduza o primeiro n£mero: ";
  cin >> n1;

  cout << "Introduza o segundo n£mero: ";
  cin >> n2;

  cout << "Introduza o terceiro n£mero: ";
  cin >> n3;

  // determinar maior
  if (n1 > n2 && n1 > n3) {
    max = n1;
  } else {
    if (n2 > n1 && n2 > n3) {
      max = n2;
    } else {
      max = n3;
    }
  }

  // determinar menor
  if (n1 < n2 && n1 < n3) {
    min = n1;
  } else {
    if (n2 < n1 && n2 < n3) {
      min = n2;
    } else {
      min = n3;
    }
  }

  // apresentar resultados
  cout << "O n£mero maior ‚: " << max << "\n";
  cout << "O n£mero menor ‚: " << min << "\n";
}