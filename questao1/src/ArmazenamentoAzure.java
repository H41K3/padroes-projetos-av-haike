public class ArmazenamentoAzure implements Armazenamento {
    private final String id;
    private final int gb;

    public ArmazenamentoAzure(int numero, int gb) {
        this.id = "blob://" + numero;
        this.gb = gb;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getGb() {
        return gb;
    }
}
