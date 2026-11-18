public interface FabricaRecursos {
    String getProvedor();

    MaquinaVirtual criarMaquina();

    Armazenamento criarArmazenamento(int gb);

    FilaMensagens criarFila();

    // precos usados na estimativa, antes de criar qualquer recurso
    double getCustoHoraMaquina();

    double getCustoGb();

    double getCustoFila();
}
