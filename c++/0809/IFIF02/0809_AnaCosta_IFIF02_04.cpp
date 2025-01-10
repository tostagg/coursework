// ler um n£mero entre 1 e 12 e imprimir mˆs correspondente
#include <iostream>

using namespace std;

int main() {

  int ano;

  cout << "Insira um n£mero entre 1 e 12: ";
  cin >> ano;

  if (ano == 1) {
    cout << "Janeiro";
  }

  else if (ano == 2) {
    cout << "Fevereiro";
  }

  else if (ano == 3) {
    cout << "Mar‡o";
  }

  else if (ano == 4) {
    cout << "Abril";
  }

  else if (ano == 5) {
    cout << "Maio";
  }

  else if (ano == 6) {
    cout << "Junho";
  }

  else if (ano == 7) {
    cout << "Julho";
  }

  else if (ano == 8) {
    cout << "Agosto";
  }

  else if (ano == 9) {
    cout << "Setembro";
  }

  else if (ano == 10) {
    cout << "Outubro";
  }

  else if (ano == 11) {
    cout << "Novembro";
  }

  else if (ano == 12) {
    cout << "Dezembro";
  }

  else {
    cout << "Escolha inv lida!";
  }
}