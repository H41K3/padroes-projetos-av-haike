import java.util.ArrayList;
import java.util.List;

public class Ambiente {
    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas;
    private final Armazenamento armazenamento;
    private final FilaMensagens fila;
    private final double custoMensal;

    public Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas,
                    Armazenamento armazenamento, FilaMensagens fila, double custoMensal) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = new ArrayList<>(maquinas);
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public void imprimirResumo() {
        List<String> ids = new ArrayList<>();
        for (MaquinaVirtual maquina : maquinas) {
            ids.add(maquina.getId());
        }
        // monta tudo e imprime de uma vez pra nao misturar com outra thread
        String resumo = "Ambiente " + nome + " (" + provedor + ", " + regiao + ")\n"
                + "  maquinas: " + String.join(", ", ids) + "\n"
                + "  armazenamento: " + armazenamento.getId() + " (" + armazenamento.getGb() + " GB)\n"
                + "  fila: " + fila.getId() + "\n"
                + "  custo mensal estimado: " + Moeda.formatar(custoMensal);
        System.out.println(resumo);
    }
}
