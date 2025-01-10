//introduzir dois n£meros e dividir (inserir 0 d  mensagem de erro)

#include <iomanip>
#include <iostream>

using namespace std;

int main() {

  //int n1, n2;

  float n1, n2, div;

  cout << "Introduza o primeiro n£mero: ";
  cin >> n1;

  cout << "Introduza o segundo n£mero: ";
  cin >> n2;

  div = n1 / n2;

  if (n2 == 0) {
    cout << "NÆo ‚ poss¡vel divir por zero! \n";

  } else {
    cout << n1 << " / " << n2 << " = " << fixed << setprecision(2) << div;
  }
}