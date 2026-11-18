public class CertificadoAutenticidade extends ServicoAdicional {
    public CertificadoAutenticidade(Fatura fatura) {
        super(fatura);
    }

    @Override
    protected String getDescricao() {
        return "Certificado de autenticidade";
    }

    @Override
    protected double getCusto() {
        return 300.00;
    }
}
