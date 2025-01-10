// ler dois n£meros e imprimir o maior

#include <iostream>

using namespace std;

int main() {

  int n1, n2;

  // introduzir n£meros
  cout << "Introduza o primeiro n£mero: ";
  cin >> n1;

  cout << "Introduza o segundo n£mero: ";
  cin >> n2;

  // maior e menor
  if (n1 > n2) {
    cout << "O n£mero " << n1 << " ‚ o maior dos dois n£meros.";
  } else {
    cout << "O n£mero " << n2 << " ‚ o maior dos dois n£meros.";
  }
}
