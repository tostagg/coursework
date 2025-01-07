/* classe clubes */

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class Clubes extends DadosFPF {

    /* array para armazenar dados dos clubes */
    static final ArrayList<Clubes> listaClubes = new ArrayList<>();

    /* formatação dos valores */
    private static final DecimalFormat EU = new DecimalFormat("#,##0.00'€'",
            new DecimalFormatSymbols() {{
                setDecimalSeparator(',');
                setGroupingSeparator('.');
            }});

    /* variáveis */
    private String sede, presidente, vocacao;
    private int jogos;
    private int assistencia;
    private float receitaBilhetes, receitaPublicidade;
    private static final String[] vocacaoClube = {"Generalista", "Focada"};

    /* construtor */
    public Clubes(String nome, String area, String contacto, String nif, String sede, String presidente,
                  String vocacao, int jogos, int assistencia) {
        super(nome, area, contacto, nif);
        this.sede = sede;
        this.presidente = presidente;
        this.vocacao = vocacao;
        this.jogos = jogos;
        this.assistencia = assistencia;
        calcularReceitas();
    }

    /* setters + getters */
    public String getVocacao() {
        return vocacao;
    }

    public void setVocacao(String vocacao) {
        this.vocacao = vocacao;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
        calcularReceitas();
    }

    public int getAssistencia() {
        return assistencia;
    }

    public void setAssistencia(int assistencia) {
        this.assistencia = assistencia;
        calcularReceitas();
    }

    public static double getPublicidadeBase() {
        return 120000.00;
    }

    public static double getPrecoBilhete() {
        return 12.50;
    }

    /* adicionar clube */
    public static void adicionarClube() {
        // introduzir dados gerais
        String nome = JOptionPane.showInputDialog(null, "Introduza o nome:",
                "FPF | Registar clube", JOptionPane.QUESTION_MESSAGE);
        if (nome == null) return;

        String area = (String) JOptionPane.showInputDialog(null, "Selecione a área geográfica:",
                "FPF | Registar clube", JOptionPane.QUESTION_MESSAGE,
                null, DadosFPF.areaGeo, DadosFPF.areaGeo[0]);
        if (area == null) return;

        String contacto;
        do {
            contacto = JOptionPane.showInputDialog(null, "Introduza o contacto telefónico:",
                    "FPF | Registar clube", JOptionPane.QUESTION_MESSAGE);
            if (contacto == null) return;
            if (DadosFPF.validarContacto(contacto)) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Contacto inválido.\nVerifique os dados introduzidos.",
                    "FPF | Registar clube", JOptionPane.ERROR_MESSAGE);

        } while (true);

        String nif;
        do {
            nif = JOptionPane.showInputDialog(null, "Introduza o NIF:",
                    "FPF | Registar clube", JOptionPane.QUESTION_MESSAGE);
            if (nif == null) return;
            if (GestaoNIF.validarNIF(nif)) {
                break;
            }
            JOptionPane.showMessageDialog(null, "NIF inválido.\nVerifique os dados introduzidos.",
                    "FPF | Registar clube", JOptionPane.ERROR_MESSAGE);
        } while (true);

        // verificar se o NIF já foi registado na base de dados
        if (!GestaoNIF.nifUnico(nif)) { // verificar se NIF já está registado no sistema
            JOptionPane.showMessageDialog(null, "NIF já registado no sistema.\nVerifique os dados introduzidos.",
                    "FPF | Registar clube", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // introduzir dados exclusivos aos clubes
        String vocacao = (String) JOptionPane.showInputDialog(null, "Selecione a vocação:",
                "FPF | Registar clube", JOptionPane.QUESTION_MESSAGE,
                null, vocacaoClube, vocacaoClube[0]);
        if (vocacao == null) return;


        String sede = JOptionPane.showInputDialog(null, "Introduza a localização da sede:",
                "FPF | Registar clube", JOptionPane.QUESTION_MESSAGE);
        if (sede == null) return; // voltar ao menu anterior caso o utilizador cancele

        String presidente = JOptionPane.showInputDialog(null, "Introduza o nome do presidente:",
                "FPF | Registar clube", JOptionPane.QUESTION_MESSAGE);
        if (presidente == null) return; // voltar ao menu anterior caso o utilizador cancele

        int jogos;
        while (true) {
            String jogosDisputados = JOptionPane.showInputDialog(null, "Introduza o total de jogos:",
                    "FPF | Registar clube", JOptionPane.QUESTION_MESSAGE);
            if (jogosDisputados == null) return;  // voltar ao menu anterior caso o utilizador cancele
            try {
                jogos = Integer.parseInt(jogosDisputados);
                if (jogos < 0) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Número de jogos inválido.\nVerifique os dados introduzidos.",
                        "FPF | Registar clube", JOptionPane.ERROR_MESSAGE);
            }
        }

        int assistencia;
        while (true) {
            String mediaAssistencia = JOptionPane.showInputDialog(null, "Introduza o número médio de espetadores por jogo:",
                    "FPF | Registar clube", JOptionPane.QUESTION_MESSAGE);
            if (mediaAssistencia == null) return; // voltar ao menu anterior caso o utilizador cancele
            try {
                assistencia = Integer.parseInt(mediaAssistencia);
                if (assistencia < 0) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Número médio de espetadores inválido.\nVerifique os dados introduzidos.",
                        "FPF | Registar clube", JOptionPane.ERROR_MESSAGE);
            }
        }

        Clubes novoClube = new Clubes(nome, area, contacto, nif, sede, presidente, vocacao, jogos, assistencia);
        listaClubes.add(novoClube); // criar nova instância de clube
        GestaoNIF.adicionarNIF(nif);  // adicionar NIF ao set partilhado
        JOptionPane.showMessageDialog(null, "Registo de clube efetuado com sucesso.", "FPF | Registar clube", JOptionPane.INFORMATION_MESSAGE);

    }

    /* remover clube */
    public static void removerClube() {
        if (listaClubes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem clubes registados no sistema.",
                    "FPF | Remover clube", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String nif = JOptionPane.showInputDialog(null, "Introduza o NIF do clube a remover:",
                    "FPF | Remover clube", JOptionPane.QUESTION_MESSAGE);
            Clubes apagarClube = encontrarNIF(nif);
            if (apagarClube != null) {
                listaClubes.remove(apagarClube);
                GestaoNIF.removerNIF(nif);
                JOptionPane.showMessageDialog(null, "Clube removido com sucesso.",
                        "FPF | Remover clube", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Clube não encontrado.",
                        "FPF | Remover clube", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /* encontrar clube pelo NIF */
    public static Clubes encontrarNIF(String nif) {
        for (Clubes clube : listaClubes) {
            if (clube.getNif().equals(nif)) {
                return clube;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s | Sede: %s | Presidente: %s | Vocação: %s | Jogos realizados: %d | Média de espetadores por jogo: %d\n" +
                        "Receita de bilhetes: %s | Receita de publicidade e direitos de transmissão televisiva: %s | Receita total: %s",
                super.toString(), sede, presidente, vocacao, jogos, assistencia, EU.format(receitaBilhetes), EU.format(receitaPublicidade), EU.format(calcularReceitas()));
    }

    /* listar todos os clubes registados no sistema */
    public static void listarClubes() {
        if (listaClubes.isEmpty()) { // verificar se existe alguma entrada no array
            JOptionPane.showMessageDialog(null, "Não existem clubes registados no sistema.",
                    "FPF | Listar clubes", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder listagemClubes = new StringBuilder("Clubes registados\n\n");
            for (Clubes clube : listaClubes) {
                listagemClubes.append(clube.toString()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, listagemClubes.toString(),
                    "FPF | Listar clubes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /* calcular receitas totais */
    public double calcularReceitas() {
        this.receitaBilhetes = (float) (jogos * assistencia * getPrecoBilhete());
        this.receitaPublicidade = (float) (jogos * getPublicidadeBase());
        return receitaBilhetes + receitaPublicidade;
    }

    /* calcular receita por número de jogos */
    public static void calcularReceitaJogos() {
        int numJogos;
        while (true) {
            String totalJogos = JOptionPane.showInputDialog(null, "Introduza o número de jogos para calcular a receita:",
                    "FPF | Calcular receita", JOptionPane.QUESTION_MESSAGE);
            if (totalJogos == null) return;
            try {
                numJogos = Integer.parseInt(totalJogos);
                if (numJogos < 0) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Número de jogos inválido.\nVerifique os dados introduzidos.",
                        "FPF | Calcular receita", JOptionPane.ERROR_MESSAGE);
            }
        }

        int assistencia;
        while (true) {
            String assistenciaJogo = JOptionPane.showInputDialog(null, "Introduza a média de espetadores por jogo:",
                    "FPF | Calcular receita", JOptionPane.QUESTION_MESSAGE);
            if (assistenciaJogo == null) return;
            try {
                assistencia = Integer.parseInt(assistenciaJogo);
                if (assistencia < 0) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Número médio de espetadores inválido.\nVerifique os dados introduzidos.",
                        "FPF | Calcular receita", JOptionPane.ERROR_MESSAGE);
            }
        }
        double receitaBilhetes = numJogos * assistencia * getPrecoBilhete();
        double receitaPublicidade = numJogos * getPublicidadeBase();
        double receitaTotal = receitaBilhetes + receitaPublicidade;

        String receita = String.format("Receita para %d jogos com assistência média de %d espetadores:\n" +
                        "Receita de bilhetes: %s | Receita de publicidade: %s | Receita total: %s",
                numJogos,
                assistencia,
                EU.format(receitaBilhetes),
                EU.format(receitaPublicidade),
                EU.format(receitaTotal));

        JOptionPane.showMessageDialog(null, receita,
                "FPF | Calcular receita", JOptionPane.INFORMATION_MESSAGE);
    }

    /* limpar as receitas associadas com os direitos de imagem e transmissão televisiva */
    public static void limparValores() {
        if (listaClubes.isEmpty()) { // verificar se existe alguma entrada no array
            JOptionPane.showMessageDialog(null, "Não existem clubes registados no sistema.",
                    "FPF | Limpar valores", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Clubes clube : listaClubes) {
                clube.receitaPublicidade = 0;
            }
            JOptionPane.showMessageDialog(null, "Valores de receita de publicidade foram limpos para todos os clubes.",
                    "FPF | Limpar valores", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}