// ler a idade e imprimir se o cidadÆo pode votar

#include <iostream>

using namespace std;

int main() {

  int idade;
 
  cout << "Introduza a idade: ";
  cin >> idade;


  if (idade >= 18) {
    cout << "O cidadÆo pode votar.";
  } else {
    cout << "O cidadÆo nÆo pode votar.";
  }
}
