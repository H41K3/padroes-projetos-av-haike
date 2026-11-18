import java.util.ArrayList;
import java.util.List;

public class FaturaLote implements Fatura {
    private final String nomeLote;
    private final double valorVenda;

    public FaturaLote(Lote lote) {
        if (!lote.isVendido()) {
            throw new IllegalStateException("so existe fatura para lote vendido");
        }
        this.nomeLote = lote.getNome();
        this.valorVenda = lote.getLanceAtual();
    }

    @Override
    public String getNomeLote() {
        return nomeLote;
    }

    @Override
    public double getValorVenda() {
        return valorVenda;
    }

    @Override
    public List<String> getItens() {
        return new ArrayList<>();
    }

    @Override
    public double getTotal() {
        return valorVenda;
    }
}
