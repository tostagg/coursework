// calculadora com menu
#include <iostream>

using namespace std;

int main() {

  int n1, n2, opcao, sum, sub, div, multi, max, min, d1, d2;

  // introduzir n£meros
  cout << "Introduza o primeiro n£mero: ";
  cin >> n1;

  cout << "Introduza o segundo n£mero: ";
  cin >> n2;

  // menu
  cout << "Escolha a opera‡Æo que deseja executar: \n";
  cout << "[1] Soma \n";
  cout << "[2] Subtra‡Æo \n";
  cout << "[3] DivisÆo \n";
  cout << "[4] Multiplica‡Æo \n";
  cout << "[5] Maior valor \n";
  cout << "[6] Menor valor \n";
  cout << "[7] Dobro \n";
  cin >> opcao;
  cout << "Op‡Æo escolhida: " << opcao << "\n";

  // opera‡äes
  sum = n1 + n2;
  sub = n1 - n2;
  div = n1 / n2;
  multi = n1 * n2;

  // maior
  if (n1 > n2) {
    max = n1;
  } else {
    if (n2 < n1) {
      max = n2;
    }
  }

  // menor
  if (n1 < n2) {
    min = n1;
  } else {
    if (n2 > n1) {
      max = n2;
    }
  }

  // dobro
  d1 = n1 * 2;
  d2 = n2 * 2;

  // resultados
  switch (opcao) {
  case 1:
    cout << "SOMA: " << n1 << "+" << n2 << "=" << sum;
    break;
  case 2:
    cout << "SUBTRA€ÇO: " << n1 << "-" << n2 << "=" << sub;
    break;
  case 3:
    cout << "DIVISÇO: " << n1 << "/" << n2 << "=" << div;
    break;
  case 4:
    cout << "MULTIPLICA€ÇO: " << n1 << "*" << n2 << "=" << multi;
    break;
  case 5:
    cout << "MAIOR: " << max;
    break;
  case 6:
    cout << "MENOR: " << min;
    break;
  case 7:
    cout << "DOBRO: " << n1 << "*" << "2 = " << d1 << "\n";
    cout << "DOBRO: " << n2 << "*" << "2 = " << d2;
    break;
  }
}
