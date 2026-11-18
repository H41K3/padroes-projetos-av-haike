public class Participante implements Observador, Proponente {
    private final String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void acompanhar(Lote lote) {
        lote.adicionarObservador(this);
    }

    public void deixarDeAcompanhar(Lote lote) {
        lote.removerObservador(this);
    }

    public void darLance(Lote lote, double valor) {
        System.out.println(nome + " da um lance de " + Moeda.formatar(valor) + " no lote " + lote.getNome());
        try {
            lote.receberLance(this, valor);
        } catch (LanceRecusadoException e) {
            System.out.println("  lance recusado: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.println("  [" + nome + "] o lote " + lote.getNome() + " recebeu um lance de "
                + Moeda.formatar(lance.getValor()));
    }
}
