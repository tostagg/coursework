// ler uma nota e determinar se aluno est  aprovado ou reprovado (m¡nima 10)

#include <iostream>

using namespace std;

int main() {

  int nota;

  cout << "Insira a nota do aluno: ";
  cin >> nota;

  if (nota >= 10 && nota <= 20 ) {
    cout << "O aluno foi aprovado.";
  } else if (nota < 10){
    cout << "O aluno foi reprovado.";
  }
  else {
    cout << "Nota inv lida!";
  }
}