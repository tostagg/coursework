/* classe-mãe */

public class DadosFPF {

    /* variáveis */
    protected String nome, area, contacto, nif;
    public static final String[] areaGeo = {"Norte", "Centro", "Oeste e Vale do Tejo", "Grande Lisboa", "Península de Setúbal", "Alentejo", "Algarve", "Açores", "Madeira"};

    /* construtor */
    public DadosFPF(String nome, String area, String contacto, String nif) {
        this.nome = nome;
        this.area = area;
        this.contacto = contacto;
        this.nif = nif;
    }

    /* setters + getters */
    public String getNome() {return this.nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getArea() {return this.area;}
    public void setArea(String area) {this.area = area;}

    public String getContacto() {return this.contacto;}
    public void setContacto(String contacto) {this.contacto = contacto;}

    public void setNif(String nif) {this.nif = nif;}
    public String getNif() {return this.nif;}

    /* imprimir resultados */
    @Override
    public String toString() {
        return String.format("%s\nÁrea de residência: %s | Contacto: %s | NIF: %s", nome, area, contacto, nif);
    }

    /* validar contacto introduzido (9 digitos, começando por 9 e 2) */
    public static boolean validarContacto(String contacto) {
        if (contacto == null || contacto.length() != 9) {
            return false;
        }
        try {
            int contactoNum = Integer.parseInt(contacto);
            return (contactoNum >= 200000000 && contactoNum <= 299999999) ||
                    (contactoNum >= 900000000 && contactoNum <= 999999999);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}