import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class TestarArbitros {

    public static void gerirArbitros() {

        /* variáveis */
        String escolha;
        String[] opcoes = {"Registar árbitro", "Remover árbitro", "Listar árbitros", "Calcular salários", "Limpar valores", "Voltar"};

        /* sub-menu árbitros */
        do {
            escolha = (String) JOptionPane.showInputDialog(null, "Escolha a operação desejada:", "FPF | Gestão de árbitros",
                    JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case "Registar árbitro":
                    Arbitros.adicionarArbitro();
                    break;
                case "Remover árbitro":
                    Arbitros.removerArbitro();
                    break;
                case "Listar árbitros":
                    Arbitros.listarArbitros();
                    break;
                case "Calcular salários":
                    Arbitros.listarSalarios();
                    break;
                case "Limpar valores":
                    Arbitros.limparAjuda();
                    break;
                case "Voltar":
                    return;
            }
        } while (true);
    }
}