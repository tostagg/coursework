import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class TestarViaturas {

    public static void main(String[] args) {
        Dados dados = new Dados();

        boolean continuar = true;

        while (continuar) {

            /* variáveis */
            String[] opcoes = {"Adicionar viatura", "Remover viatura", "Inventário geral", "Inventário por marca", "Inventário com preço total", "Sair"};
            String[] tipoCombustivel = {"Gasolina", "Gasóleo", "Gás", "Elétrico", "Hidrogénio", "Outros"};
            String escolha;

            do {

                /* menu */
                escolha = (String) JOptionPane.showInputDialog(
                        null,
                        "Escolha a opção desejada:",
                        "Bem-vindo",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);

                switch (escolha) {
                    case "Adicionar viatura":
                        // adicionar viatura ao inventário
                        String marca = JOptionPane.showInputDialog(null, "Introduza a marca:");
                        String modelo = JOptionPane.showInputDialog(null, "Introduza o modelo:");
                        String matricula = JOptionPane.showInputDialog(null, "Introduza a matrícula:");
                        String combustivel = (String) JOptionPane.showInputDialog(
                                null,
                                "Escolha o tipo de combustível:",
                                "Tipo de Combustível",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                tipoCombustivel,
                                tipoCombustivel[0]);
                        int kmsAtuais = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduza os kms atuais:"));
                        float preco = Float.parseFloat(JOptionPane.showInputDialog(null, "Introduza o preço (€):"));

                        Viaturas novaViatura = new Viaturas(marca, modelo, matricula, combustivel, kmsAtuais, preco);
                        dados.adicionarViatura(novaViatura);
                        break;

                    case "Remover viatura":
                        // remover viatura do inventário
                        String matriculaRemover = JOptionPane.showInputDialog(null, "Introduza a matrícula da viatura a remover:");
                        dados.removerViatura(matriculaRemover);
                        break;

                    case "Inventário geral":
                        // mostrar o inventário geral
                        dados.mostrarTodasViaturas();
                        break;

                    case "Inventário por marca":
                        // mostrar o inventário, filtrado por marca
                        String marcaProcurar = JOptionPane.showInputDialog(
                                null,
                                "Introduza a marca das viaturas a mostrar:");
                        dados.mostrarViaturasMarca(marcaProcurar);
                        break;

                    case "Inventário com preço total": // mostrar o inventário geral, bem como o preço total das viaturas
                        dados.mostrarViaturasPrecoTotal();
                        break;

                    case "Sair": // sair do programa
                        continuar = false;
                        break;
                }
            } while (!"Sair".equals(escolha)); /* repetir menu até utilizador escolher sair */
        }
    }
}