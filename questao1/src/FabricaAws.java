import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAws implements FabricaRecursos {
    private final AtomicInteger seqMaquina = new AtomicInteger();
    private final AtomicInteger seqArmazenamento = new AtomicInteger();
    private final AtomicInteger seqFila = new AtomicInteger();

    @Override
    public String getProvedor() {
        return "Aws";
    }

    @Override
    public MaquinaVirtual criarMaquina() {
        return new MaquinaVirtualAws(seqMaquina.incrementAndGet());
    }

    @Override
    public Armazenamento criarArmazenamento(int gb) {
        return new ArmazenamentoAws(seqArmazenamento.incrementAndGet(), gb);
    }

    @Override
    public FilaMensagens criarFila() {
        return new FilaAws(seqFila.incrementAndGet());
    }

    @Override
    public double getCustoHoraMaquina() {
        return 0.10;
    }

    @Override
    public double getCustoGb() {
        return 0.023;
    }

    @Override
    public double getCustoFila() {
        return 0.40;
    }
}
