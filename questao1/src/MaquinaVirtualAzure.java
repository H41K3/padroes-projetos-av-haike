public class MaquinaVirtualAzure implements MaquinaVirtual {
    private final String id;

    public MaquinaVirtualAzure(int numero) {
        this.id = "vm-" + numero;
    }

    @Override
    public String getId() {
        return id;
    }
}
