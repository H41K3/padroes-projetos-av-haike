public class ComissaoVeiculos implements RegraComissao {
    private static final double LIMITE = 5000.00;

    @Override
    public String getNome() {
        return "Veiculos (8%, limite de R$ 5.000,00)";
    }

    @Override
    public double calcular(double valorVenda) {
        return Math.min(valorVenda * 0.08, LIMITE);
    }
}
