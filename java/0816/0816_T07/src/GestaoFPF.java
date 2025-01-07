/* menu principal */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class GestaoFPF {
    public static void main(String[] args) {

        /* variáveis */
        String[] opcoesMenu = {"Gestão de Árbitros", "Gestão de Clubes", "Gestão de Jogadores", "Sair"};
        String escolha;

        /* menu inicial */
        while (true) {
            escolha = (String) JOptionPane.showInputDialog(null, "Escolha a opção desejada:", "FPF | Sistema de Gestão",
                    JOptionPane.PLAIN_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

            if (escolha == null) {
                continue;
            }
            switch (escolha) {
                case "Gestão de Árbitros": // menu árbitros
                    TestarArbitros.gerirArbitros();
                    break;
                case "Gestão de Clubes": // menu clubes
                    TestarClubes.gerirClubes();
                    break;
                case "Gestão de Jogadores": // menu jogadores
                    TestarJogadores.gerirJogadores();
                    break;
                case "Sair": // sair do programa
                    JOptionPane.showMessageDialog(null, "Até à próxima!", "FPF | Sistema de Gestão", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
            }
        }
    }
}
