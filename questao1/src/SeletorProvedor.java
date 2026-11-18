// unica classe que conhece as fabricas concretas
public class SeletorProvedor {
    private static final FabricaRecursos AWS = new FabricaAws();
    private static final FabricaRecursos AZURE = new FabricaAzure();

    public static FabricaRecursos escolher(String provedor) {
        switch (provedor.toLowerCase()) {
            case "aws" -> {
                return AWS;
            }
            case "azure" -> {
                return AZURE;
            }
            default -> throw new IllegalArgumentException("Provedor desconhecido: " + provedor);
        }
    }
}
