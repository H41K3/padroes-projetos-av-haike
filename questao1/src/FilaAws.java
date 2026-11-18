public class FilaAws implements FilaMensagens {
    private final String id;

    public FilaAws(int numero) {
        this.id = "sqs-" + numero;
    }

    @Override
    public String getId() {
        return id;
    }
}
