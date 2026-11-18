import java.util.List;

public interface Fatura {
    String getNomeLote();

    double getValorVenda();

    List<String> getItens();

    double getTotal();
}
