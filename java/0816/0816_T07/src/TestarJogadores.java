import javax.swing.JOptionPane;

public class TestarJogadores {
    public static void gerirJogadores() {
        String escolha;
        String[] opcoes = {"Registar jogador", "Remover jogador", "Listar jogadores", "Calcular salários", "Limpar valores", "Voltar"};

        do {
            escolha = (String) JOptionPane.showInputDialog(null, "Escolha a operação desejada:", "FPF | Gestão de jogadores",
                    JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == null) return;

            switch (escolha) {
                case "Registar jogador":
                    Jogadores.adicionarJogador();
                    break;
                case "Remover jogador":
                    Jogadores.removerJogador();
                    break;
                case "Listar jogadores":
                    Jogadores.listarJogadores();
                    break;
                case "Calcular salários":
                    Jogadores.calcularSalarios();
                    break;
                case "Limpar valores":
                    Jogadores.limparValores();
                    break;
                case "Voltar":
                    return;
            }
        } while (true);
    }
}