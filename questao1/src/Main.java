import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<SolicitacaoAmbiente> pedidos = new ArrayList<>();
        pedidos.add(new SolicitacaoAmbiente("api-pagamentos", "Aws", 2, 200));
        pedidos.add(new SolicitacaoAmbiente("portal-web", "Aws", 4, 300));
        pedidos.add(new SolicitacaoAmbiente("erp-financeiro", "Azure", 3, 500));
        pedidos.add(new SolicitacaoAmbiente("cluster-bigdata", "Azure", 10, 5000));

        List<Thread> threads = new ArrayList<>();
        for (SolicitacaoAmbiente pedido : pedidos) {
            FabricaRecursos fabrica = SeletorProvedor.escolher(pedido.getProvedor());
            ProvisionadorAmbiente provisionador = new ProvisionadorAmbiente(fabrica);
            Thread thread = new Thread(() -> provisionador.provisionar(pedido));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        Auditoria.getInstancia().imprimirHistorico();
    }
}
