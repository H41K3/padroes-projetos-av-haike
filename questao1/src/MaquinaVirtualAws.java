public class MaquinaVirtualAws implements MaquinaVirtual {
    private final String id;

    public MaquinaVirtualAws(int numero) {
        this.id = "i-" + numero;
    }

    @Override
    public String getId() {
        return id;
    }
}
