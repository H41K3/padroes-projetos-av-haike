import java.util.ArrayList;
import java.util.List;

public abstract class ServicoAdicional implements Fatura {
    private final Fatura fatura;

    protected ServicoAdicional(Fatura fatura) {
        this.fatura = fatura;
    }

    protected abstract String getDescricao();

    protected abstract double getCusto();

    @Override
    public String getNomeLote() {
        return fatura.getNomeLote();
    }

    @Override
    public double getValorVenda() {
        return fatura.getValorVenda();
    }

    @Override
    public List<String> getItens() {
        List<String> itens = new ArrayList<>(fatura.getItens());
        itens.add(getDescricao() + ": " + Moeda.formatar(getCusto()));
        return itens;
    }

    @Override
    public double getTotal() {
        return fatura.getTotal() + getCusto();
    }
}
