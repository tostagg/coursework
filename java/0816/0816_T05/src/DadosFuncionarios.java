import javax.swing.*;

public class DadosFuncionarios {

    /* variáveis */
    private String nome, contacto, email;
    private float vencimento;
    private float salarioFinal;

    /* construtor */
    public DadosFuncionarios() { }

    /* setters + getters */
    public void setNome(String nome) { this.nome = nome; }

    public void setContacto(String contacto) { this.contacto = contacto; }

    public void setEmail(String email) { this.email = email; }

    public void setVencimento(float vencimento) { this.vencimento = vencimento; }

    //////

    public String getNome() { return nome; }

    public String getContacto() { return contacto; }

    public String getEmail() { return email; }

    public float getVencimento() { return vencimento; }

    public float getSalarioFinal() { return salarioFinal; }

    /* calcular salário final */
    public void calcularSalarioFinal(String departamento) {
        switch (departamento) {
            case "Vendas":
                float totalVendas = Float.parseFloat(JOptionPane.showInputDialog(
                        null,
                        "Introduza o valor total das vendas:",
                        "Empresa Alfa | Vendas",
                        JOptionPane.QUESTION_MESSAGE));
                float comissao = 0.05f * totalVendas; // 5% de comissão sobre o valor total de vendas
                salarioFinal = vencimento + comissao;
                break;
            case "Administração":
                int horasExtra = Integer.parseInt(JOptionPane.showInputDialog(
                        null,
                        "Introduza o número de horas extra:",
                        "Empresa Alfa | Administração",
                        JOptionPane.QUESTION_MESSAGE));
                float pagamentoExtra = horasExtra * 3; // horas extra pagas a 3 euros à hora
                salarioFinal = vencimento + pagamentoExtra;
                break;
            case "Financeiro":
                float premioProdutividade = Float.parseFloat(JOptionPane.showInputDialog(
                        null,
                        "Introduza o valor do prémio de produtividade mensal:",
                        "Empresa Alfa | Financeiro",
                        JOptionPane.QUESTION_MESSAGE));
                salarioFinal = vencimento + premioProdutividade; // prémio de produtividade é variável
                break;
        }
    }
}


