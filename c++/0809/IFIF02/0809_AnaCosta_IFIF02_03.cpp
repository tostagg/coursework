// ler dois n£meros e realizar opera‡Æo do menu

#include <iomanip>
#include <iostream>

using namespace std;

int main() {

  // introduzir n£meros
  int opcao;
  float n1, n2;

  cout << "Introduza o primeiro n£mero: ";
  cin >> n1;

  cout << "Introduza o segundo n£mero: ";
  cin >> n2;

  // menu
  cout << "\nEscolha a opera‡Æo que pretende:";
  cout << "\n[1] Soma";
  cout << "\n[2] Subtra‡Æo";
  cout << "\n[3] DivisÆo";
  cout << "\n[4] Multiplica‡Æo\n";
  cout << "\nOpera‡Æo escolhida: ";
  cin >> opcao;

  float r;

  // opera‡äes
  if (opcao == 1) {
    r = n1 + n2;
    cout << "\nSOMA: " << n1 << " + " << n2 << " = " << fixed << setprecision(2)
         << r;
  } else if (opcao == 2) {
    r = n1 - n2;
    cout << "\nSUBTRA€ÇO: " << n1 << " - " << n2 << " = " << fixed
         << setprecision(2) << r;
  } else if (opcao == 3) {
    r = n1 / n2;
    cout << "\nDIVISÇO: " << n1 << " / " << n2 << " = " << fixed
         << setprecision(2) << r;
  } else if (opcao == 4) {
    r = n1 * n2;
    cout << "\nMULTIPLICA€ÇO: " << n1 << " * " << n2 << " = " << fixed
         << setprecision(2) << r;

    // repetir menu
  } else {
    do {
      cout << "\n OPERA€ÇO INVµLIDA!";
      cout << "\nEscolha a opera‡Æo que pretende:";
      cout << "\n[1] Soma";
      cout << "\n[2] Subtra‡Æo";
      cout << "\n[3] DivisÆo";
      cout << "\n[4] Multiplica‡Æo\n";
      cout << "\nOpera‡Æo escolhida: ";
      cin >> opcao;
      if (opcao == 1) {
        r = n1 + n2;
        cout << "\nSOMA: " << n1 << " + " << n2 << " = " << fixed
             << setprecision(2) << r;
      } else if (opcao == 2) {
        r = n1 - n2;
        cout << "\nSUBTRA€ÇO: " << n1 << " - " << n2 << " = " << fixed
             << setprecision(2) << r;
      } else if (opcao == 3) {
        r = n1 / n2;
        cout << "\nDIVISÇO: " << n1 << " / " << n2 << " = " << fixed
             << setprecision(2) << r;
      } else {
        r = n1 * n2;
        cout << "\nMULTIPLICA€ÇO: " << n1 << " * " << n2 << " = " << fixed
             << setprecision(2) << r;
      }
    } while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4);
  }
}