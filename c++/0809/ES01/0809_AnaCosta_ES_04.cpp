// n£meros pares, soma & m‚dia
#include <iostream>

using namespace std;

int main() {

  int q, i;

  int n[20];

  // quantos n£meros a inserir
  cout << "Quantos n£meros vai querer inserir? ";
  cin >> q;

  // contador
  float soma = 0;
  float media = 0;

  for (int i = 1; i <= q; i++) {
    cout << "Introduza o " << i << "§ n£mero: ";
    cin >> n[i];
    soma = soma + n[i];
  }

  media = (float)(soma / q);

  // resultados
  cout << "NéMEROS PARES: ";
  for (i = 1; i < 2 * q; i++) {
    if (n[i] % 2 == 0)
      cout << n[i] << " ";
  }
  cout << " \n";
  cout << "SOMA: " << soma;

  cout << " \n";
  cout << "MDIA: " << media;
}