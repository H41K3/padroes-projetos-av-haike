import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAzure implements FabricaRecursos {
    private final AtomicInteger seqMaquina = new AtomicInteger();
    private final AtomicInteger seqArmazenamento = new AtomicInteger();
    private final AtomicInteger seqFila = new AtomicInteger();

    @Override
    public String getProvedor() {
        return "Azure";
    }

    @Override
    public MaquinaVirtual criarMaquina() {
        return new MaquinaVirtualAzure(seqMaquina.incrementAndGet());
    }

    @Override
    public Armazenamento criarArmazenamento(int gb) {
        return new ArmazenamentoAzure(seqArmazenamento.incrementAndGet(), gb);
    }

    @Override
    public FilaMensagens criarFila() {
        return new FilaAzure(seqFila.incrementAndGet());
    }

    @Override
    public double getCustoHoraMaquina() {
        return 0.12;
    }

    @Override
    public double getCustoGb() {
        return 0.02;
    }

    @Override
    public double getCustoFila() {
        return 0.50;
    }
}
