// ler um n£mero e determinar se ‚ positivo, negativo ou nulo

#include <iostream>

using namespace std;

int main() {

  int n;

  cout << "Introduza um n£mero: ";
  cin >> n;

  if (n > 0) {
    cout << "O n£mero " << n << " ‚ positivo.\n";
  } else if (n == 0) {
    cout << "O n£mero " << n << " ‚ nulo.\n";
  } else {
    cout << "O n£mero " << n << " ‚ negativo.\n";
  }
}