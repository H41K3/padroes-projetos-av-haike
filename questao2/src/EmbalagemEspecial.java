public class EmbalagemEspecial extends ServicoAdicional {
    public EmbalagemEspecial(Fatura fatura) {
        super(fatura);
    }

    @Override
    protected String getDescricao() {
        return "Embalagem especial";
    }

    @Override
    protected double getCusto() {
        return 180.00;
    }
}
