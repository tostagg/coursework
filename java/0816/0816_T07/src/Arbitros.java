/* classe árbitros */

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class Arbitros extends DadosFPF {

    /* array para armazenar dados dos árbitros */
    protected static final ArrayList<Arbitros> listaArbitros = new ArrayList<>();

    /* formatação dos valores */
    private static final DecimalFormat EU = new DecimalFormat("#,##0.00'€'",
            new DecimalFormatSymbols() {{
                setDecimalSeparator(',');
                setGroupingSeparator('.');
            }});

    /* variáveis */
    private int jogos;
    private String residencia, profissao, classificacao;
    private double salario;
    private static final String[] classificacaoArbitro = {"Nacional", "Internacional"};

    /* construtor */
    public Arbitros(String nome, String area, String contacto, String nif, String residencia, String profissao, String classificacao, int jogos, double salario) {
        super(nome, area, contacto, nif);
        this.residencia = residencia;
        this.profissao = profissao;
        this.classificacao = classificacao;
        this.jogos = jogos;
        this.salario = salario;
    }

    /* setters + getters */
    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public static double getAjudaBase() {
        return 240.57;
    }

    /* adicionar árbitro */
    public static void adicionarArbitro() {
        // introduzir dados gerais
        String nome = JOptionPane.showInputDialog(null, "Introduza o nome:",
                "FPF | Registar árbitro", JOptionPane.QUESTION_MESSAGE);
        if (nome == null) return; // voltar ao menu anterior caso o utilizador cancele

        String area = (String) JOptionPane.showInputDialog(null, "Selecione a área geográfica:",
                "FPF | Registar árbitro", JOptionPane.QUESTION_MESSAGE, null, DadosFPF.areaGeo, DadosFPF.areaGeo[0]);
        if (area == null) return; // voltar ao menu anterior caso o utilizador cancele

        String contacto;
        do {
            contacto = JOptionPane.showInputDialog(null, "Introduza o contacto telefónico:",
                    "FPF | Registar árbitro", JOptionPane.QUESTION_MESSAGE);
            if (contacto == null) return;
            if (DadosFPF.validarContacto(contacto)) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Contacto inválido.\nVerifique os dados introduzidos.",
                    "FPF | Registar árbitro", JOptionPane.ERROR_MESSAGE);
        } while (true);

        String nif;
        do {
            nif = JOptionPane.showInputDialog(null, "Introduza o NIF:",
                    "FPF | Registar árbitro", JOptionPane.QUESTION_MESSAGE);
            if (nif == null) return;
            if (GestaoNIF.validarNIF(nif)) {
                break;
            }
            JOptionPane.showMessageDialog(null, "NIF inválido.\nVerifique os dados introduzidos.",
                    "FPF | Registar árbitro", JOptionPane.ERROR_MESSAGE);
        } while (true);

        // verificar se o NIF já foi registado na base de dados
        if (!GestaoNIF.nifUnico(nif)) {
            JOptionPane.showMessageDialog(null, "NIF já registado no sistema.\nVerifique os dados introduzidos.",
                    "FPF | Registar árbitro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // introduzir dados exclusivos aos clubes
        String residencia = JOptionPane.showInputDialog(null, "Introduza o local de residência:",
                "FPF | Registar árbitro", JOptionPane.QUESTION_MESSAGE);
        if (residencia == null) return;

        String profissao = JOptionPane.showInputDialog(null, "Introduza a profissão:",
                "FPF | Registar árbitro", JOptionPane.QUESTION_MESSAGE);
        if (profissao == null) return;

        String classificacao = (String) JOptionPane.showInputDialog(null, "Classificação:",
                "FPF | Registar árbitro", JOptionPane.QUESTION_MESSAGE, null, classificacaoArbitro, classificacaoArbitro[0]);
        if (classificacao == null) return;

        int jogos;
        while (true) {
            String jogosArbitrados = JOptionPane.showInputDialog(null, "Introduza o total de jogos arbitrados:",
                    "FPF | Registar árbitro", JOptionPane.QUESTION_MESSAGE);
            if (jogosArbitrados == null) return;
            try {
                jogos = Integer.parseInt(jogosArbitrados);
                if (jogos < 0) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Número de jogos inválido.\nVerifique os dados introduzidos.",
                        "FPF | Registar árbitro", JOptionPane.ERROR_MESSAGE);
            }
        }

        double salario;
        while (true) {
            String salarioBase = JOptionPane.showInputDialog(null, "Introduza o salário base (€):",
                    "FPF | Registar árbitro", JOptionPane.QUESTION_MESSAGE);
            if (salarioBase == null) return;
            try {
                salario = Double.parseDouble(salarioBase);
                if (salario < 0) throw new IllegalArgumentException();
                break;

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "O salário não pode ser inferior a zero.\nVerifique os dados introduzidos.",
                        "FPF | Registar árbitro", JOptionPane.ERROR_MESSAGE);
            }
        }

        Arbitros novoArbitro = new Arbitros(nome, area, contacto, nif, residencia, profissao, classificacao, jogos, salario);
        listaArbitros.add(novoArbitro); // criar nova instância de árbitro
        GestaoNIF.adicionarNIF(nif);  // adicionar NIF ao set partilhado
        {
            JOptionPane.showMessageDialog(null, "Árbitro registado com sucesso.",
                    "FPF | Registar árbitro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /* encontrar árbitro por NIF */
    public static Arbitros encontrarNIF(String nif) {
        if (nif == null || nif.isEmpty()) {
            return null;
        }
        for (Arbitros arbitro : listaArbitros) {
            if (arbitro.getNif().equals(nif.trim())) {
                return arbitro;
            }
        }
        return null;
    }

    /* remover árbitro */
    public static void removerArbitro() {
        if (listaArbitros.isEmpty()) { // verificar se existe alguma entrada no array
            JOptionPane.showMessageDialog(null, "Não existem árbitros registados no sistema.",
                    "FPF | Remover árbitro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String nif = JOptionPane.showInputDialog(null, "Introduza o NIF do árbitro a remover:",
                    "FPF | Remover árbitro", JOptionPane.QUESTION_MESSAGE);

            if (nif == null) {
                return;
            }

            if (!GestaoNIF.validarNIF(nif)) {
                JOptionPane.showMessageDialog(null, "NIF inválido. Por favor, introduza um NIF válido.",
                        "FPF | Remover árbitro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Arbitros apagarArbitro = encontrarNIF(nif);

            if (apagarArbitro == null) {
                JOptionPane.showMessageDialog(null, "Árbitro não encontrado.",
                        "FPF | Remover árbitro", JOptionPane.ERROR_MESSAGE);
            } else {
                listaArbitros.remove(apagarArbitro);
                GestaoNIF.removerNIF(apagarArbitro.getNif());
                JOptionPane.showMessageDialog(null, "Árbitro removido com sucesso.",
                        "FPF | Remover árbitro", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s | Residência: %s | Profissão: %s | Jogos apitados: %d | Salário base: %s | Ajudas de custo: %s | Salário total: %s",
                super.toString(), residencia, profissao, jogos, EU.format(salario), EU.format(calcularAjudas()), EU.format(calcularSalario()));
    }

    /* listar todos os árbitros registados no sistema */
    public static void listarArbitros() {
        if (listaArbitros.isEmpty()) { // verificar se existe alguma entrada no array
            JOptionPane.showMessageDialog(null, "Não existem árbitros registados no sistema.",
                    "FPF | Listar árbitros", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder listagemArbitros = new StringBuilder("Árbitros registados\n\n");
            for (Arbitros arbitro : listaArbitros) {
                listagemArbitros.append(arbitro.toString()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, listagemArbitros.toString(),
                    "FPF | Listar árbitros", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /* calcular ajudas de custo */
    public double calcularAjudas() {
        return getJogos() * getAjudaBase();
    }

    /* calcular salário total */
    public double calcularSalario() {
        return getSalario() + calcularAjudas();
    }

    /* limpar ajudas de custo acumuladas */
    public static void limparAjuda() {
        if (listaArbitros.isEmpty()) { // verificar se existe alguma entrada no array
            JOptionPane.showMessageDialog(null, "Não existem árbitros registados no sistema.",
                    "FPF | Limpar valores", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Arbitros arbitro : listaArbitros) {
                arbitro.setJogos(0);
            }
            JOptionPane.showMessageDialog(null, "Ajudas de custo acumuladas foram limpas para todos os árbitros.",
                    "FPF | Limpar valores", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void listarSalarios() {
        if (listaArbitros.isEmpty()) { // verificar se existe alguma entrada no array
            JOptionPane.showMessageDialog(null, "Não existem árbitros registados no sistema.",
                    "FPF | Calcular salários", JOptionPane.INFORMATION_MESSAGE);
        } else {

            StringBuilder infoSalarios = new StringBuilder("Salários finais\n\n");
            for (Arbitros a : Arbitros.listaArbitros) {
                infoSalarios.append(a.getNome())
                        .append("\nSalário base: ")
                        .append(EU.format(a.getSalario()))
                        .append(" | Jogos apitados: ")
                        .append(a.getJogos())
                        .append(" | Ajudas de custo: ")
                        .append(EU.format(a.calcularAjudas()))
                        .append(" | Salário final: ")
                        .append(EU.format(a.calcularSalario()))
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, infoSalarios.toString(),
                    "FPF | Calcular salários", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}