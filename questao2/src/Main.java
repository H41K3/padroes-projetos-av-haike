public class Main {
    public static void main(String[] args) {
        Categoria arte = new Categoria("Arte", new ComissaoArte());
        Categoria veiculos = new Categoria("Veiculos", new ComissaoVeiculos());

        Lote quadro = new Lote("Tela Abstrato 1958", arte, 5000.00, 6000.00);
        Lote fusca = new Lote("Fusca 1975", veiculos, 20000.00, 30000.00);

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carlos = new Participante("Carlos");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        for (Lote lote : new Lote[] {quadro, fusca}) {
            ana.acompanhar(lote);
            bruno.acompanhar(lote);
            carlos.acompanhar(lote);
            lote.adicionarObservador(painel);
            lote.adicionarObservador(auditor);
        }

        System.out.println("=== Lote 1: " + quadro.getNome() + " ===");
        ana.darLance(quadro, 5300.00);
        bruno.darLance(quadro, 5400.00);
        bruno.darLance(quadro, 5600.00);

        System.out.println("\nCarlos deixou de acompanhar o lote " + quadro.getNome());
        carlos.deixarDeAcompanhar(quadro);
        ana.darLance(quadro, 6000.00);

        System.out.println("\nCampanha: comissao do lote " + quadro.getNome() + " passa para a regra de Eletronicos");
        quadro.setRegraComissao(new ComissaoEletronicos());

        quadro.encerrar();
        mostrarResultado(quadro);
        bruno.darLance(quadro, 7000.00);

        System.out.println("\n=== Lote 2: " + fusca.getNome() + " ===");
        bruno.darLance(fusca, 21000.00);
        carlos.darLance(fusca, 22000.00);
        ana.darLance(fusca, 23000.00);
        fusca.encerrar();
        mostrarResultado(fusca);

        System.out.println();
        new AcertoVendedor(quadro).imprimir();

        System.out.println();
        Fatura fatura = new FaturaLote(quadro);
        fatura = new SeguroTransporte(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EntregaExpressa(fatura);
        fatura = new EmbalagemEspecial(fatura);
        new ImpressoraFatura().imprimir(fatura);

        System.out.println();
        auditor.imprimirRegistros();
    }

    private static void mostrarResultado(Lote lote) {
        if (lote.isVendido()) {
            System.out.println("Lote " + lote.getNome() + " encerrado: vendido para "
                    + lote.getMaiorLance().getAutor().getNome() + " por " + Moeda.formatar(lote.getLanceAtual()));
        } else {
            System.out.println("Lote " + lote.getNome() + " encerrado: nao vendido (maior lance "
                    + Moeda.formatar(lote.getLanceAtual()) + ", reserva " + Moeda.formatar(lote.getPrecoReserva()) + ")");
        }
    }
}
