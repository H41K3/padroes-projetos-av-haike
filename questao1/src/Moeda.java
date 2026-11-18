import java.util.Locale;

public class Moeda {
    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    public static String formatar(double valor) {
        return String.format(PT_BR, "R$ %,.2f", valor);
    }
}
