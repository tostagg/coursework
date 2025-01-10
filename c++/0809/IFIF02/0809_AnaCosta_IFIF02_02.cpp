// determinar se n£mero ‚ divis¡vel por 2 e 5
#include <iostream>

using namespace std;

int main() {

  int n;

  cout << "Introduza um n£mero: ";
  cin >> n;

  // divis¡vel por 2 e 5
  if (n % 2 == 0 && n % 5 == 0) {
    int r1, r2;

    r1 = n / 2;
    r2 = n / 5;

    cout << "O n£mero " << n << " ‚ divis¡vel por 2 e por 5.\n";
    cout << n << " / 2 = " << r1 << "\n";
    cout << n << " / 5 = " << r2 << "\n";

    // divis¡vel apenas por 2
  } else if (n % 2 == 0) {
    int r1;

    r1 = n / 2;

    cout << "O n£mero " << n << " ‚ divis¡vel por 2.\n";
    cout << n << " / 2 = " << r1 << "\n";

    // divis¡vel apenas por 5
  } else if (n % 5 == 0) {
    int r1;

    r1 = n / 5;

    cout << "O n£mero " << n << " ‚ divis¡vel por 5.\n";
    cout << n << " / 5 = " << r1 << "\n";
  }
  // nÆo ‚ divis¡vel por 2 ou 5
  else {
    cout << "O n£mero " << n << " nÆo ‚ divis¡vel por 2 ou por 5.\n";
  }
}