public class ImpressoraFatura {
    public void imprimir(Fatura fatura) {
        System.out.println("Fatura do comprador");
        System.out.println("  Lote: " + fatura.getNomeLote());
        System.out.println("  Valor de venda: " + Moeda.formatar(fatura.getValorVenda()));
        for (String item : fatura.getItens()) {
            System.out.println("  " + item);
        }
        System.out.println("  Total a pagar: " + Moeda.formatar(fatura.getTotal()));
    }
}
