// ler a idade e imprimir se o cidad�o pode votar

#include <iostream>

using namespace std;

int main() {

  int idade;
 
  cout << "Introduza a idade: ";
  cin >> idade;


  if (idade >= 18) {
    cout << "O cidad�o pode votar.";
  } else {
    cout << "O cidad�o n�o pode votar.";
  }
}
