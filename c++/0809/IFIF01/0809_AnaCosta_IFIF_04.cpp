// ler dois n£meros inteiros (a, b) e mostrar qual o maior ou se s∆o iguais

#include <iostream>

using namespace std;

int main() {

  int n1, n2;

  cout << "Introduza o primeiro n£mero: ";
  cin >> n1;

  cout << "Introduza o segundo n£mero: ";
  cin >> n2;

  if (n1 > n2) {
    cout << n1 << " > " << n2;
  } else if (n2 > n1) {
    cout << n2 << " > " << n1;
  } else {
    cout << n1 << " = " << n2;
  }
}