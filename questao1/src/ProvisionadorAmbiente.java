import java.util.ArrayList;
import java.util.List;

public class ProvisionadorAmbiente {
    private static final int HORAS_NO_MES = 730;

    private final FabricaRecursos fabrica;

    public ProvisionadorAmbiente(FabricaRecursos fabrica) {
        this.fabrica = fabrica;
    }

    public Ambiente provisionar(SolicitacaoAmbiente pedido) {
        Configuracao config = Configuracao.getInstancia();
        double custo = estimarCusto(pedido);

        if (custo > config.getOrcamentoMaximo()) {
            String motivo = "custo estimado de " + Moeda.formatar(custo)
                    + " acima do orcamento de " + Moeda.formatar(config.getOrcamentoMaximo());
            Auditoria.getInstancia().registrar(pedido.getNome(), fabrica.getProvedor(), "RECUSADO - " + motivo);
            System.out.println("Ambiente " + pedido.getNome() + " recusado: " + motivo);
            return null;
        }

        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < pedido.getQuantidadeMaquinas(); i++) {
            maquinas.add(fabrica.criarMaquina());
        }
        Armazenamento armazenamento = fabrica.criarArmazenamento(pedido.getGb());
        FilaMensagens fila = fabrica.criarFila();

        Ambiente ambiente = new Ambiente(pedido.getNome(), fabrica.getProvedor(), config.getRegiaoPadrao(),
                maquinas, armazenamento, fila, custo);
        ambiente.imprimirResumo();
        Auditoria.getInstancia().registrar(pedido.getNome(), fabrica.getProvedor(), "ACEITO");
        return ambiente;
    }

    private double estimarCusto(SolicitacaoAmbiente pedido) {
        double maquinas = pedido.getQuantidadeMaquinas() * fabrica.getCustoHoraMaquina() * HORAS_NO_MES;
        double armazenamento = pedido.getGb() * fabrica.getCustoGb();
        return maquinas + armazenamento + fabrica.getCustoFila();
    }
}
