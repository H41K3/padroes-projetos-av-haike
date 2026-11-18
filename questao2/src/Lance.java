import java.time.LocalDateTime;

public class Lance {
    private final Proponente autor;
    private final double valor;
    private final LocalDateTime dataHora;

    public Lance(Proponente autor, double valor) {
        this.autor = autor;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    public Proponente getAutor() {
        return autor;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
