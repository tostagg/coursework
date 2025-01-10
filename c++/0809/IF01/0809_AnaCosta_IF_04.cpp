// programa para ler dois artigos e quantidade, imprimir total e imposto de iva,
// imprime o mais caro
#include <iomanip>
#include <iostream>

using namespace std;

int main() {

  float compras[2][2];

  cout << "\n[INSIRA OS ARTIGOS E A QUANTIDADE DESEJADA]\n";

  // pre‡os e quantidades
  for (int i = 0; i < 1; ++i) {
    cout << "\n[PRIMEIRO ARTIGO]\n";
    cout << "PRE€O: ";
    cin >> compras[0][0];
    cout << "QUANTIDADE: ";
    cin >> compras[0][1];

    for (int j = 0; j < 1; ++j) {
      cout << "\n[SEGUNDO ARTIGO]\n";
      cout << "PRE€O: ";
      cin >> compras[1][0];
      cout << "QUANTIDADE: ";
      cin >> compras[1][1];
    }
  }

  cout << "\n[TOTAIS]\n";

  // maior e menor
  if (compras[0][0] > compras[1][0]) {
    cout << "O primeiro artigo ‚ o mais caro. (" << compras[0][0] << fixed
         << setprecision(2) << " euros/unidade)";
  } else {
    cout << "O segundo artigo ‚ o mais caro. (" << compras[1][0] << fixed
         << setprecision(2) << " euros/unidade)";
    ;
  }

  // c lculo do iva
  cout << "\n";

  float iva = 0.23;
  float total, totaliva;

  total = (compras[0][0] * compras[0][1]) + (compras[1][0] * compras[1][1]);
  totaliva = total + (total * iva);

  // resultados
  cout << "O total das suas compras ‚: " << total << fixed << setprecision(2)
       << " euros. \n";
  cout << "Com a taxa de IVA aplicada a 23% ‚: " << totaliva << fixed
       << setprecision(2) << " euros. \n";
}
