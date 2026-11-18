public class PainelLeiloeiro implements Observador {
    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.println("  [Painel] " + lote.getNome() + ": maior lance " + Moeda.formatar(lote.getLanceAtual())
                + ", " + lote.getTotalLances() + " lance(s) recebido(s)");
    }
}
