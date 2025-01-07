import javax.swing.*;

public class TestarClubes {

    public static void gerirClubes() {

        /* variáveis */
        String escolha;
        String[] opcoes = {"Registar clube", "Remover clube", "Listar clubes", "Calcular receitas", "Limpar valores", "Voltar"};

        /* sub-menu clubes */
        do {
            escolha = (String) JOptionPane.showInputDialog(null, "Escolha a operação desejada:", "FPF | Gestão de clubes",
                    JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case "Registar clube":
                    Clubes.adicionarClube();
                    break;
                case "Remover clube":
                    Clubes.removerClube();
                    break;
                case "Listar clubes":
                    Clubes.listarClubes();
                    break;
                case "Calcular receitas":
                    Clubes.calcularReceitaJogos();
                    break;
                case "Limpar valores":
                    Clubes.limparValores();
                    break;
                case "Voltar":
                    return;
            }
        } while (true);
    }
}
