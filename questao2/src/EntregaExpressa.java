public class EntregaExpressa extends ServicoAdicional {
    public EntregaExpressa(Fatura fatura) {
        super(fatura);
    }

    @Override
    protected String getDescricao() {
        return "Entrega expressa";
    }

    @Override
    protected double getCusto() {
        return 450.00;
    }
}
