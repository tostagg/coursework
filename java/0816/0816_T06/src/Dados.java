import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Dados {

    /* array para armazenar dados das viaturas */
    ArrayList<Viaturas> listaViaturas = new ArrayList<>();

    /* formatação dos valores para decimal */
    DecimalFormat Ft = new DecimalFormat("0.00");

    /* adicionar nova viatura ao inventário */
    public void adicionarViatura(Viaturas novaViatura) {
        // verificar se a matrícula já está registada no sistema
        for (Viaturas v : listaViaturas) {
            if (v.getMatricula().equals(novaViatura.getMatricula())) {
                JOptionPane.showMessageDialog(
                        null,
                        "Matrícula já está registada no sistema.",
                        "Adicionar viatura",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        // caso a matrícula não esteja registada, adicionar viatura ao inventário
        listaViaturas.add(novaViatura);
        JOptionPane.showMessageDialog(
                null,
                "Registo efetuado com sucesso!",
                "Adicionar viatura",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /* remover viatura do inventário */
    public void removerViatura(String matricula) {

        // caso a matrícula esteja no sistema, remover a mesma
        for (Viaturas v : listaViaturas) {
            if (v.getMatricula().equals(matricula)) {
                listaViaturas.remove(v);
                JOptionPane.showMessageDialog(
                        null,
                        "Registo eliminado.",
                        "Remover viatura",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        // caso a matrícula ainda não esteja registada, apresentar mensagem de erro
        JOptionPane.showMessageDialog(
                null,
                "Não existem viaturas registadas!",
                "Remover viatura",
                JOptionPane.ERROR_MESSAGE);
    }

    /* mostrar todas as viaturas no inventário */
    public void mostrarTodasViaturas() {
        if (listaViaturas.isEmpty()) {
            // caso o inventário esteja vazio
            JOptionPane.showMessageDialog(
                    null,
                    "Não existem viaturas registadas!",
                    "Inventário geral",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            // inicializar a string para a listagem
            StringBuilder lista = new StringBuilder("Lista de viaturas\n");

            // caso exista pelo menos uma matrícula registada
            for (Viaturas v : listaViaturas) {
                lista.append(v.detalhesViaturas()).append("\n");
            }

            // mostrar resultados
            JOptionPane.showMessageDialog(
                    null,
                    lista,
                    "Inventário geral",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /* mostrar viaturas por marca */
    public void mostrarViaturasMarca(String marca) {

        if (listaViaturas.isEmpty()) {
            // caso o inventário esteja vazio
            JOptionPane.showMessageDialog(
                    null,
                    "Não existem viaturas registadas!",
                    "Inventário por marca",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            // inicializar a string para a listagem
            StringBuilder lista = new StringBuilder("Inventário da marca "+marca+":\n");

            // variável para verificar se existe alguma viatura da marca registada no inventário
            boolean encontrou = false;

            // verificar se existem viaturas da marca escolhida
            for (Viaturas v : listaViaturas) {
                if (v.getMarca().equalsIgnoreCase(marca)) {
                    lista.append(v.detalhesViaturas()).append("\n");
                    encontrou = true;
                }
            }

            if (encontrou) {
                // mostrar resultados
                JOptionPane.showMessageDialog(
                        null,
                        lista,
                        "Inventário por marca",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // caso não existam viaturas da marca, apresentar mensagem de erro
                JOptionPane.showMessageDialog(
                        null,
                        "Não existem viaturas registadas da marca "+marca+"!",
                        "Inventário por marca",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /* mostrar todas as viaturas no inventário + preço final */
    public void mostrarViaturasPrecoTotal() {

        if (listaViaturas.isEmpty()) {
            // caso o inventário esteja vazio
            JOptionPane.showMessageDialog(
                    null,
                    "Não existem viaturas registadas!",
                    "Inventário com preço total",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            // inicializar a string para a listagem
            StringBuilder lista = new StringBuilder("Lista de viaturas\n");
            float precoTotal = 0;


            // adicionar os valores das viatursa presentes no inventário
            for (Viaturas v : listaViaturas) {
                lista.append(v.detalhesViaturas()).append("\n");
                precoTotal += v.getPreco();
            }

            // formatar valor total para Euros
            lista.append("\nPreço Total: ").append(Ft.format(precoTotal)).append("€");

            // mostrar resultados
            JOptionPane.showMessageDialog(
                    null,
                    lista,
                    "Inventário com preço total",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
