import javax.swing.*;

public class Main {

    private static dadosConta conta = null;

    public static void main(String[] args) {

        while (true) {
            String[] operacoes;
            if (conta == null) {
                operacoes = new String[]{"Login", "Sair"};
            } else {
                operacoes = new String[]{"Depósito", "Levantamento", "Consulta", "Sair"};
            }

            /* perguntar ao utilizador qual a operação desejada */
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Por favor, seleccione a operação desejada:",
                    "Bem-vindo",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    operacoes,
                    operacoes[0]
            );

            /* menu */
            if (conta == null) {
                switch (escolha) {
                    case 0: // login
                        Login();
                        break;
                    case 1: // sair
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, "Operação inválida.");
                        break;
                }
            } else {
                switch (escolha) {
                    case 0: // depósito
                        Deposito();
                        break;
                    case 1: // levantamento
                        Levantamento();
                        break;
                    case 2: // consulta
                        Consulta();
                        break;
                    case 3: // sair
                        System.exit(0);
                    default: // erro
                        JOptionPane.showMessageDialog(null, "Operação inválida.");
                        break;
                }
            }
        }
    }

    /* login */
    public static void Login() {
        String numero = JOptionPane.showInputDialog("Insira o número da conta:");
        String nome = JOptionPane.showInputDialog("Insira o seu nome:");
        String saldoInput = JOptionPane.showInputDialog("Insira o seu saldo inicial:");

        double saldo = Double.parseDouble(saldoInput);

        conta = new dadosConta(numero, nome, saldo);

        JOptionPane.showMessageDialog(
                null,
                "Login bem sucedido!\n" +
                        "Número da conta: " + conta.pedirNumero() + "\n" +
                        "Nome: " + conta.pedirNome() + "\n" +
                        "Saldo inicial: " + conta.pedirSaldo(),
                "Informações da Conta",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /* depósito */
    public static void Deposito() {
        String depositoInput = JOptionPane.showInputDialog("Insira o valor que pretende depositar:");
        double deposito = Double.parseDouble(depositoInput);

        conta.definirSaldo(conta.pedirSaldo() + deposito);

        JOptionPane.showMessageDialog(
                null,
                "Depósito realizado com sucesso!\n" +
                        "Novo saldo: " + conta.pedirSaldo(),
                "Depósito",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /* levantamento */
    public static void Levantamento() {
        String levantamentoInput = JOptionPane.showInputDialog("Insira o valor que pretende levantar:");
        double levantamento = Double.parseDouble(levantamentoInput);

        if (levantamento <= conta.pedirSaldo()) {
            conta.definirSaldo(conta.pedirSaldo() - levantamento);
            JOptionPane.showMessageDialog(
                    null,
                    "Levantamento realizado com sucesso!\n" +
                            "Novo saldo: " + conta.pedirSaldo(),
                    "Levantamento",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Saldo insuficiente para realizar o levantamento.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    /* consulta */
    public static void Consulta() {
        JOptionPane.showMessageDialog(
                null,
                "Informações da Conta:\n" +
                        "Número da conta: " + conta.pedirNumero() + "\n" +
                        "Nome: " + conta.pedirNome() + "\n" +
                        "Saldo atual: " + conta.pedirSaldo(),
                "Consulta",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}