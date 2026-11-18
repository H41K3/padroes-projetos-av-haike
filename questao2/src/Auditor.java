import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditor implements Observador {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    @Override
    public void atualizar(Lote lote, Lance lance) {
        registros.add(lance.getDataHora().format(FORMATO) + " | " + lote.getNome() + " | "
                + lance.getAutor().getNome() + " | " + Moeda.formatar(lance.getValor()));
    }

    public void imprimirRegistros() {
        System.out.println("Registro do auditor:");
        for (String registro : registros) {
            System.out.println("  " + registro);
        }
    }
}
