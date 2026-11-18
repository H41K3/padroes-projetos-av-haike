import java.util.ArrayList;
import java.util.List;

public class Lote {
    private final String nome;
    private final Categoria categoria;
    private final double precoInicial;
    private final double precoReserva;

    private final List<Lance> lances = new ArrayList<>();
    private final List<Observador> observadores = new ArrayList<>();
    private RegraComissao regraComissao;
    private boolean encerrado;
    private boolean vendido;

    public Lote(String nome, Categoria categoria, double precoInicial, double precoReserva) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.regraComissao = categoria.getRegraPadrao();
    }

    public void adicionarObservador(Observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void receberLance(Proponente autor, double valor) throws LanceRecusadoException {
        if (encerrado) {
            throw new LanceRecusadoException("o lote ja foi encerrado");
        }
        double minimo = getLanceMinimo();
        if (valor < minimo) {
            throw new LanceRecusadoException("o lance precisa ser pelo menos 5% maior que o atual ("
                    + Moeda.formatar(getLanceAtual()) + "), ou seja, no minimo " + Moeda.formatar(minimo));
        }
        Lance lance = new Lance(autor, valor);
        lances.add(lance);
        notificar(lance);
    }

    private void notificar(Lance lance) {
        // copia da lista, caso alguem saia do lote durante a notificacao
        for (Observador observador : new ArrayList<>(observadores)) {
            // quem deu o lance nao precisa ser avisado
            if (observador != lance.getAutor()) {
                observador.atualizar(this, lance);
            }
        }
    }

    public void encerrar() {
        if (encerrado) {
            return;
        }
        encerrado = true;
        vendido = !lances.isEmpty() && getLanceAtual() >= precoReserva;
    }

    public void setRegraComissao(RegraComissao regra) {
        if (encerrado) {
            throw new IllegalStateException("a regra nao pode mais ser trocada, o lote ja foi encerrado");
        }
        this.regraComissao = regra;
    }

    public double calcularComissao() {
        if (!vendido) {
            throw new IllegalStateException("o lote nao foi vendido");
        }
        return regraComissao.calcular(getLanceAtual());
    }

    public double getLanceAtual() {
        if (lances.isEmpty()) {
            return precoInicial;
        }
        return lances.get(lances.size() - 1).getValor();
    }

    // arredonda pra centavos pra evitar erro de ponto flutuante (10000 * 1.05)
    private double getLanceMinimo() {
        return Math.round(getLanceAtual() * 1.05 * 100) / 100.0;
    }

    public Lance getMaiorLance() {
        if (lances.isEmpty()) {
            return null;
        }
        return lances.get(lances.size() - 1);
    }

    public int getTotalLances() {
        return lances.size();
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoReserva() {
        return precoReserva;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public RegraComissao getRegraComissao() {
        return regraComissao;
    }

    public boolean isEncerrado() {
        return encerrado;
    }

    public boolean isVendido() {
        return vendido;
    }
}
