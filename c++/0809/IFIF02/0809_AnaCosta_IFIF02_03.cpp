// ler dois n�meros e realizar opera��o do menu

#include <iomanip>
#include <iostream>

using namespace std;

int main() {

  // introduzir n�meros
  int opcao;
  float n1, n2;

  cout << "Introduza o primeiro n�mero: ";
  cin >> n1;

  cout << "Introduza o segundo n�mero: ";
  cin >> n2;

  // menu
  cout << "\nEscolha a opera��o que pretende:";
  cout << "\n[1] Soma";
  cout << "\n[2] Subtra��o";
  cout << "\n[3] Divis�o";
  cout << "\n[4] Multiplica��o\n";
  cout << "\nOpera��o escolhida: ";
  cin >> opcao;

  float r;

  // opera��es
  if (opcao == 1) {
    r = n1 + n2;
    cout << "\nSOMA: " << n1 << " + " << n2 << " = " << fixed << setprecision(2)
         << r;
  } else if (opcao == 2) {
    r = n1 - n2;
    cout << "\nSUBTRA��O: " << n1 << " - " << n2 << " = " << fixed
         << setprecision(2) << r;
  } else if (opcao == 3) {
    r = n1 / n2;
    cout << "\nDIVIS�O: " << n1 << " / " << n2 << " = " << fixed
         << setprecision(2) << r;
  } else if (opcao == 4) {
    r = n1 * n2;
    cout << "\nMULTIPLICA��O: " << n1 << " * " << n2 << " = " << fixed
         << setprecision(2) << r;

    // repetir menu
  } else {
    do {
      cout << "\n OPERA��O INV�LIDA!";
      cout << "\nEscolha a opera��o que pretende:";
      cout << "\n[1] Soma";
      cout << "\n[2] Subtra��o";
      cout << "\n[3] Divis�o";
      cout << "\n[4] Multiplica��o\n";
      cout << "\nOpera��o escolhida: ";
      cin >> opcao;
      if (opcao == 1) {
        r = n1 + n2;
        cout << "\nSOMA: " << n1 << " + " << n2 << " = " << fixed
             << setprecision(2) << r;
      } else if (opcao == 2) {
        r = n1 - n2;
        cout << "\nSUBTRA��O: " << n1 << " - " << n2 << " = " << fixed
             << setprecision(2) << r;
      } else if (opcao == 3) {
        r = n1 / n2;
        cout << "\nDIVIS�O: " << n1 << " / " << n2 << " = " << fixed
             << setprecision(2) << r;
      } else {
        r = n1 * n2;
        cout << "\nMULTIPLICA��O: " << n1 << " * " << n2 << " = " << fixed
             << setprecision(2) << r;
      }
    } while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4);
  }
}