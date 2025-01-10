//ler a velocidade de dois pilotos e imprimir o vencedor

#include <iostream>

using namespace std;

int main() {

  float vel[2];

  cout << "Insira a velocidade do primeiro piloto (km/h): ";
  cin >> vel[0];

  cout << "Insira a velocidade do segundo piloto (km/h): ";
  cin >> vel[1];

  if (vel[0] > vel[1]) {
    cout << "\nO primeiro piloto ‚ o vencedor.";
  } else {
    cout << "\nO segundo piloto ‚ o vencedor.";
  }
}
