// ler um ano e identificar se ‚ bissexto

#include <iostream>

using namespace std;

bool bissexto(int ano) {
  if (ano % 4 == 0) {
    if (ano % 100 == 0) {
      if (ano % 400 == 0) {
        return true;
      } else {
        return false;
      }
    } else {
      return true;
    }
  } else {
    return false;
  }
}

int main() {

  int ano;

  cout << "Introduza o ano: ";
  cin >> ano;

  if (bissexto(ano)) {
    cout << "O ano " << ano << " ‚ um ano bissexto.";
  } else {
    cout << "O ano " << ano << " nÆo ‚ um ano bissexto.";
  }
}
