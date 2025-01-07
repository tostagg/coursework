import java.text.DecimalFormat;

public class Viaturas {

    /* formatação dos valores para decimal */
    DecimalFormat Ft = new DecimalFormat("0.00");

    /* viaturas */
    String marca, modelo, matricula, combustivel;
    int kmsAtuais;
    float preco;

    /* construtor */
    public Viaturas(String marca, String modelo, String matricula, String combustivel, int kmsAtuais, float preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.combustivel = combustivel;
        this.kmsAtuais = kmsAtuais;
        this.preco = preco;
    }

    /* detalhes das viaturas */
    public String detalhesViaturas() {
        return String.format("\nMarca: %s | Modelo: %s | Matrícula: %s | Combustível: %s | Kms: %d | Preço: %s€",
                marca, modelo, matricula, combustivel, kmsAtuais, Ft.format(preco));
    }

    /* setters + getters */
    public void setMarca(String marca) {this.marca = marca;}

    public void setModelo(String modelo) {this.modelo = modelo;}

    public void setMatricula(String matricula) {this.matricula = matricula;}

    public void setCombustivel(String combustivel) {this.combustivel = combustivel;}

    public void setKms(int kmsAtuais) {this.kmsAtuais = kmsAtuais;}

    public void setPreco(float preco) {this.preco = preco;}

    ///

    public String getMarca() {return marca;}

    public String getModelo() {return modelo;}

    public String getMatricula() {return matricula;}

    public String getCombustivel() {return combustivel;}

    public int getKms() {return kmsAtuais;}

    public float getPreco() {return preco;}

}
