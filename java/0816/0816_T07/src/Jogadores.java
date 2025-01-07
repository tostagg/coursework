/* classe jogadores */

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class Jogadores extends DadosFPF {

    /* array para armazenar dados dos jogadores */
    private static final ArrayList<Jogadores> listaJogadores = new ArrayList<>();

    /* formatação dos valores */
    private static final DecimalFormat EU = new DecimalFormat("#,##0.00'€'",
            new DecimalFormatSymbols() {{
                setDecimalSeparator(',');
                setGroupingSeparator('.');
            }});
    private static final DecimalFormat ME = new DecimalFormat("0.00'm'");
    private static final DecimalFormat KG = new DecimalFormat("0.00'kg'");

    /* variáveis */
    private static final String[] posicaoJogador = {"Guarda-redes", "Defesa", "Médio", "Avançado"};
    private String posicao, nacionalidade, clube;
    private float altura, peso;
    private double salario;
    private int jogos, jogosVencidos;
    private boolean incluirDireitos;

    /* construtor */
    public Jogadores(String nome, String area, String contacto, String nif, String posicao, String nacionalidade,
                     String clube, float altura, float peso, double salario, int jogos, int jogosVencidos) {
        super(nome, area, contacto, nif);
        this.posicao = posicao;
        this.nacionalidade = nacionalidade;
        this.clube = clube;
        this.altura = altura;
        this.peso = peso;
        this.salario = salario;
        this.jogos = jogos;
        this.jogosVencidos = jogosVencidos;
        this.incluirDireitos = true;
    }

    /* setters + getters */
    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setIncluirDireitos(boolean incluirDireitos) {
        this.incluirDireitos = incluirDireitos;
    }

    public double getPremio(int jogosVencidos) {
        return jogosVencidos * 650;
    } // prémio de 650 euros por cada jogo ganho

    public double getImagem() {
        return incluirDireitos ? salario * 0.115 : 0;
    } // direitos de imagem - 11,5% do valor do salário base

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getJogosVencidos() {
        return jogosVencidos;
    }

    public void setJogosVencidos(int jogosVencidos) {
        this.jogosVencidos = jogosVencidos;
    }

    /* adicionar jogador */
    public static void adicionarJogador() {
        // introduzir dados gerais
        String nome = JOptionPane.showInputDialog(null, "Introduza o nome:",
                "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE);
        if (nome == null) return;

        String area = (String) JOptionPane.showInputDialog(null, "Selecione a área geográfica:",
                "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE,
                null, DadosFPF.areaGeo, DadosFPF.areaGeo[0]);
        if (area == null) return;

        String contacto;
        do {
            contacto = JOptionPane.showInputDialog(null, "Introduza o contacto telefónico:",
                    "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE);
            if (contacto == null) return;
            if (DadosFPF.validarContacto(contacto)) {
                break;
            }
            if (!DadosFPF.validarContacto(contacto)) {
                JOptionPane.showMessageDialog(null, "Contacto inválido.\nVerifique os dados introduzidos.",
                        "FPF | Registar jogador", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);

        String nif;
        do {
            nif = JOptionPane.showInputDialog(null, "Introduza o NIF:",
                    "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE);
            if (nif == null) return;
            if (GestaoNIF.validarNIF(nif)) {
                break;
            }
            JOptionPane.showMessageDialog(null, "NIF inválido.\nVerifique os dados introduzidos.",
                    "FPF | Registar jogador", JOptionPane.ERROR_MESSAGE);
        } while (true);

        if (!GestaoNIF.nifUnico(nif)) { // verificar se NIF já está registado no sistema
            JOptionPane.showMessageDialog(null, "NIF já registado no sistema.\nVerifique os dados introduzidos.",
                    "FPF | Registar jogador", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String posicao = (String) JOptionPane.showInputDialog(null, "Seleccione a posição do jogador em campo:",
                "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE,
                null, posicaoJogador, posicaoJogador[0]);
        if (posicao == null) return;

        String nacionalidade = JOptionPane.showInputDialog(null, "Introduza o país de origem:",
                "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE);
        if (nacionalidade == null) return;

        String clube = JOptionPane.showInputDialog(null, "Introduza o clube:",
                "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE);
        if (clube == null) return;

        float altura;
        while (true) {
            try {
                String alturaJogador = JOptionPane.showInputDialog(null, "Introduza a altura do jogador (cm):",
                        "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE);
                if (alturaJogador == null) return;
                altura = Float.parseFloat(alturaJogador) / 100;
                if (altura <= 0) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Altura inválida.\nVerifique os dados introduzidos.",
                        "FPF | Registar jogador", JOptionPane.ERROR_MESSAGE);
            }
        }

        float peso;
        while (true) {
            try {
                String pesoJogador = JOptionPane.showInputDialog(null, "Introduza o peso do jogador (kg):",
                        "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE);
                if (pesoJogador == null) return;
                peso = Float.parseFloat(pesoJogador);
                if (peso <= 0) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Peso inválido.\nVerifique os dados introduzidos.",
                        "FPF | Registar jogador", JOptionPane.ERROR_MESSAGE);
            }
        }

        double salario;
        while (true) {
            try {
                String salarioBase = JOptionPane.showInputDialog(null, "Introduza o salário base (€):",
                        "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE);
                if (salarioBase == null) return;
                salario = Double.parseDouble(salarioBase);
                if (salario < 0) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Salário inválido.\nVerifique os dados introduzidos.",
                        "FPF | Registar jogador", JOptionPane.ERROR_MESSAGE);
            }
        }

        int jogos;
        while (true) {
            try {
                String jogosD = JOptionPane.showInputDialog(null, "Introduza o número de jogos disputados:",
                        "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE);
                if (jogosD == null) return;
                jogos = Integer.parseInt(jogosD);
                if (jogos < 0) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Número de jogos inválido.\nVerifique os dados introduzidos.",
                        "FPF | Registar jogador", JOptionPane.ERROR_MESSAGE);
            }
        }

        int jogosVencidos;
        while (true) {
            try {
                String jogosV = JOptionPane.showInputDialog(null, "Introduza o número de jogos vencidos:",
                        "FPF | Registar jogador", JOptionPane.QUESTION_MESSAGE);
                if (jogosV == null) return;
                jogosVencidos = Integer.parseInt(jogosV);
                if (jogosVencidos < 0 || jogosVencidos > jogos) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Número de jogos inválido.\nVerifique os dados introduzidos.",
                        "FPF | Registar jogador", JOptionPane.ERROR_MESSAGE);
            }
        }

        Jogadores novoJogador = new Jogadores(nome, area, contacto, nif, posicao, nacionalidade, clube, altura, peso, salario, jogos, jogosVencidos);
        listaJogadores.add(novoJogador); // criar nova instância de jogador
        GestaoNIF.adicionarNIF(nif); // adicionar NIF ao set partilhado
        JOptionPane.showMessageDialog(null, "Registo de jogador efetuado com sucesso.",
                "FPF | Registar jogador", JOptionPane.INFORMATION_MESSAGE);
    }

    /* encontrar jogador pelo NIF */
    public static Jogadores encontrarNIF(String nif) {
        for (Jogadores jogador : listaJogadores) {
            if (jogador.getNif().equals(nif)) {
                return jogador;
            }
        }
        return null;
    }

    /* remover jogador */
    public static void removerJogador() {
        if (listaJogadores.isEmpty()) { // verificar se existe alguma entrada no array
            JOptionPane.showMessageDialog(null, "Não existem jogadores registados no sistema.",
                    "FPF | Remover jogador", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String nif = JOptionPane.showInputDialog(null, "Introduza o NIF do jogador a remover:",
                    "FPF | Remover jogador", JOptionPane.QUESTION_MESSAGE);

            if (!GestaoNIF.validarNIF(nif)) {
                JOptionPane.showMessageDialog(null, "NIF inválido. Por favor, introduza um NIF válido.",
                        "FPF | Remover jogador", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Jogadores apagarJogador = encontrarNIF(nif);

            if (apagarJogador != null) {
                listaJogadores.remove(apagarJogador);
                GestaoNIF.removerNIF(nif);
                JOptionPane.showMessageDialog(null, "Jogador removido com sucesso.",
                        "FPF | Remover jogador", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Jogador não encontrado.",
                        "FPF | Remover jogador", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("""
                        %s | Posição: %s | Nacionalidade: %s | Clube: %s | Altura: %s | Peso: %s
                        Salário base: %s | Jogos disputados: %s | Jogos vencidos: %s | Prémios: %s | Direitos de imagem: %s | Salário total: %s""",
                super.toString(), posicao, nacionalidade, clube, ME.format(altura), KG.format(peso),
                EU.format(salario), jogos, jogosVencidos, EU.format(getPremio(jogosVencidos)), EU.format(getImagem()), EU.format(calcularSalario()));
    }

    /* listar jogadores registados no sistema */
    public static void listarJogadores() {
        if (listaJogadores.isEmpty()) { // verificar se existe alguma entrada no array
            JOptionPane.showMessageDialog(null, "Não existem jogadores registados no sistema.",
                    "FPF | Listar jogadores", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder listagemJogadores = new StringBuilder("Jogadores resgistados\n\n");
            for (Jogadores jogador : listaJogadores) {
                listagemJogadores.append(jogador.toString()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, listagemJogadores.toString(),
                    "FPF | Listar jogadores", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /* calcular salário final */
    public double calcularSalario() {
        return getSalario() + getImagem() + getPremio(getJogosVencidos());
    }

    /* calcular salários totais do plantel */
    public static void calcularSalarios() {
        if (listaJogadores.isEmpty()) { // verificar se existe alguma entrada no array
            JOptionPane.showMessageDialog(null, "Não existem jogadores registados no sistema.",
                    "FPF | Calcular salários", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder salarioInfo = new StringBuilder("Salários finais\n\n");
            for (Jogadores jogador : listaJogadores) {
                double salarioTotal = jogador.calcularSalario();
                salarioInfo.append(jogador.getNome())
                        .append("\nSalário Base: ")
                        .append(EU.format(jogador.getSalario()))
                        .append(" | Jogos vencidos: ")
                        .append(jogador.getJogosVencidos())
                        .append(" | Prémios: ")
                        .append(EU.format(jogador.getPremio(jogador.getJogosVencidos())))
                        .append(" | Direitos de imagem: ")
                        .append(EU.format(jogador.getImagem()))
                        .append(" | Salário total: ")
                        .append(EU.format(salarioTotal))
                        .append("\n\n");
            }
            JOptionPane.showMessageDialog(null, salarioInfo.toString(),
                    "FPF | Calcular salários", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /* limpar valores */
    public static void limparValores() {
        if (listaJogadores.isEmpty()) { // verificar se existe alguma entrada no array
            JOptionPane.showMessageDialog(null, "Não existem jogadores registados no sistema.",
                    "FPF | Limpar valores", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Jogadores jogador : listaJogadores) {
                jogador.setIncluirDireitos(false);
            }
            JOptionPane.showMessageDialog(null, "Os direitos de imagem foram apagados para todos os jogadores.",
                    "FPF | Limpar valores", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}