import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Auditoria {
    private static final Auditoria INSTANCIA = new Auditoria();

    private final List<RegistroAuditoria> registros = new ArrayList<>();

    private Auditoria() {
    }

    public static Auditoria getInstancia() {
        return INSTANCIA;
    }

    // synchronized pra duas threads nao mexerem na lista ao mesmo tempo
    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        registros.add(new RegistroAuditoria(LocalDateTime.now(), ambiente, provedor, resultado));
    }

    public synchronized void imprimirHistorico() {
        System.out.println("Historico de provisionamentos:");
        for (RegistroAuditoria registro : registros) {
            System.out.println("  " + registro);
        }
    }
}
