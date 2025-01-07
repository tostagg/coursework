public class dadosConta {
    /* variáveis */
    private String numero;
    private String nome;
    private double saldo;

    /* constructor */
    public dadosConta(String numero, String nome, double saldo) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
    }

    /* setters & getters */

    public void definirNumero(String numero) {
        this.numero = numero;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public void definirSaldo(double saldo) {
        this.saldo = saldo;
    }


    public String pedirNumero() {
        return numero;
    }

    public String pedirNome() {
        return nome;
    }

    public double pedirSaldo() {
        return saldo;
    }
}

