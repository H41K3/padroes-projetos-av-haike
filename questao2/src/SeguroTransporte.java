public class SeguroTransporte extends ServicoAdicional {
    public SeguroTransporte(Fatura fatura) {
        super(fatura);
    }

    @Override
    protected String getDescricao() {
        return "Seguro de transporte (1,5% do valor de venda)";
    }

    @Override
    protected double getCusto() {
        return getValorVenda() * 0.015;
    }
}
