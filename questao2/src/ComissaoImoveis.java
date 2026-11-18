public class ComissaoImoveis implements RegraComissao {
    private static final double TAXA_FIXA = 1500.00;

    @Override
    public String getNome() {
        return "Imoveis (3% + R$ 1.500,00)";
    }

    @Override
    public double calcular(double valorVenda) {
        return valorVenda * 0.03 + TAXA_FIXA;
    }
}
