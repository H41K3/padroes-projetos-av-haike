public class FilaAzure implements FilaMensagens {
    private final String id;

    public FilaAzure(int numero) {
        this.id = "sb-" + numero;
    }

    @Override
    public String getId() {
        return id;
    }
}
