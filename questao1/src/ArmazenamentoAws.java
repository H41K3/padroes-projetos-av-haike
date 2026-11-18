public class ArmazenamentoAws implements Armazenamento {
    private final String id;
    private final int gb;

    public ArmazenamentoAws(int numero, int gb) {
        this.id = "s3://" + numero;
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
