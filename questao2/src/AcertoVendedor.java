public class AcertoVendedor {
    private final Lote lote;

    public AcertoVendedor(Lote lote) {
        if (!lote.isVendido()) {
            throw new IllegalStateException("so existe acerto para lote vendido");
        }
        this.lote = lote;
    }

    public void imprimir() {
        double valorVenda = lote.getLanceAtual();
        double comissao = lote.calcularComissao();
        System.out.println("Acerto do vendedor - " + lote.getNome() + " (" + lote.getCategoria().getNome() + ")");
        System.out.println("  Valor de venda: " + Moeda.formatar(valorVenda));
        System.out.println("  Comissao cobrada: " + Moeda.formatar(comissao) + " [" + lote.getRegraComissao().getNome() + "]");
        System.out.println("  Valor liquido a repassar: " + Moeda.formatar(valorVenda - comissao));
    }
}
