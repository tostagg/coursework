// ler uma nota e determinar se aluno est  aprovado ou reprovado (utilizador
// determina nota m¡nima)

#include <iostream>

using namespace std;

int main() {

  int nota, min;
  cout << "Qual ‚ a nota m¡nima? ";
  cin >> min;

  cout << "Insira a nota do aluno: ";
  cin >> nota;

  if (nota >= min && nota <= 20) {
    cout << "O aluno foi aprovado.";
  } else if (nota < min) {
    cout << "O aluno foi reprovado.";
  } else {
    cout << "Nota inv lida!";
  }
}