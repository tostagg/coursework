import java.util.HashSet;
import java.util.Set;

public class GestaoNIF {

    /* set para armazenar os NIFs introduzidos (em qualquer uma das classes) */
    private static final Set<String> nifsUsados = new HashSet<>();

    /* verificar se o nif é único ou repetido */
    public static boolean nifUnico(String nif) {
        return !nifsUsados.contains(nif);
    }

    /* adicionar NIF à base de dados */
    public static void adicionarNIF(String nif) {
        nifsUsados.add(nif);
    }

    /* remover NIF da base de dados */
    public static void removerNIF(String nif) {
        nifsUsados.remove(nif);
    }

    /* validar que o NIF introduzido é válido (9 dígitos) */
    public static boolean validarNIF(String nif) {
        if (nif == null || nif.length() != 9) {
            return false;
        }
        try {
            int n = Integer.parseInt(nif);
            return n > 0 && n <= 999999999;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}