// programa que permite a um professor introduzir o n£mero de alunos numa turma
// e, de seguida, preencher o nome, nota 1 e nota 2, obter as m‚dias individuais
// e a m‚dia da turma

#include <iostream>
#include <vector>

using namespace std;

struct aluno {
  string nome;
  float n1;
  float n2;
  float media;
};

int main() {

  int n = 0;
  cout << "Quantos alunos vai querer inserir? ";
  cin >> n;

  float mediaglobal;

  // introduzir alunos
  vector<aluno> alunos(n);
  for (int i = 0; i < n; ++i) {
    cout << "\nInsira o nome do aluno: ";
    cin >> alunos[i].nome;
    cout << "Insira a primeira nota: ";
    cin >> alunos[i].n1;
    cout << "Insira a segunda nota: ";
    cin >> alunos[i].n2;
    alunos[i].media = (alunos[i].n1 + alunos[i].n2) / 2;
    mediaglobal += alunos[i].media;
  }

  cout << "\n";

  // imprimir resultados
  for (int i = 0; i < n; ++i) {
    cout << "[" << i + 1 << "§ ALUNO] NOME: " << alunos[i].nome
         << " | NOTA 1: " << alunos[i].n1
         << " valores | NOTA 2: " << alunos[i].n1
         << " valores | MDIA: " << alunos[i].n1 << " valores\n";
  }

  cout << "\n";

  float mediaturma = mediaglobal / n;
  cout << "\n[MDIA DA TURMA] " << mediaturma << endl;

  return 0;
}
