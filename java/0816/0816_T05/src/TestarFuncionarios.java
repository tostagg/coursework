import javax.swing.*;
import java.text.DecimalFormat;

public class TestarFuncionarios {

    public static void main(String[] args) {

        String[] departamentos = {"Vendas", "Administração", "Financeiro"};

        /* escolha do departamento */
        String selDepartamento = (String) JOptionPane.showInputDialog(
                null,
                "Bem-vindo!\nSeleccione o seu departamento:",
                "Empresa Alfa | Registo de funcionário",
                JOptionPane.QUESTION_MESSAGE,
                null,
                departamentos,
                departamentos[0]
        );

        /* criar nova instância para armazenar os dados do utilizador */
        DadosFuncionarios funcionario = new DadosFuncionarios();

        /* atribuir dados ao objeto dadosFuncionario */
        funcionario.setNome(JOptionPane.showInputDialog(null,
                "Introduza o seu nome:",
                "Empresa Alfa | Registo de funcionário",
                JOptionPane.QUESTION_MESSAGE));

        funcionario.setContacto(JOptionPane.showInputDialog(null,
                "Introduza o seu contacto telefónico:",
                "Empresa Alfa | Registo de funcionário",
                JOptionPane.QUESTION_MESSAGE));

        funcionario.setEmail(JOptionPane.showInputDialog(null,
                "Introduza o seu email:",
                "Empresa Alfa | Registo de funcionário",
                JOptionPane.QUESTION_MESSAGE));

        funcionario.setVencimento(Float.parseFloat(JOptionPane.showInputDialog(null,
                "Introduza o seu vencimento base:",
                "Empresa Alfa | Registo de funcionário",
                JOptionPane.QUESTION_MESSAGE)));

        /* calcular salário final conforme o departamento seleccionado */
        funcionario.calcularSalarioFinal(selDepartamento);
        DecimalFormat df = new DecimalFormat("€#,##0.00");

        /* imprimir as informações do funcionário, com os valores respeitos ao vecimento formatados */
        JOptionPane.showMessageDialog(null,
                "Informações do Funcionário:\n\n" +
                        "Nome: " + funcionario.getNome() + "\n" +
                        "Contacto: " + funcionario.getContacto() + "\n" +
                        "Email: " + funcionario.getEmail() + "\n" +
                        "Departamento: " + selDepartamento + "\n" +
                        "Salário Base: " + df.format(funcionario.getVencimento()) + "\n" +
                        "Salário Final: " + df.format(funcionario.getSalarioFinal()),
                "Empresa Alfa | Registo completo",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}