// ler um valor e determinar se est  dentro do intervalo de 1 a 9

#include <iostream>

using namespace std;

int main() {

  int c[] = {1, 2, 3, 4, 5, 6, 7, 8, 9}, n;

  // introduzir n£mero
  cout << "Introduza um n£mero: ";
  cin >> n;

  if (n >= c[0] && n <= c[8]) {
    cout << "O n£mero " << n << " est  dentro do intervalo.";
  } else {
    cout << "O n£mero " << n << " nÆo est  dentro do intervalo.";
  }
}
