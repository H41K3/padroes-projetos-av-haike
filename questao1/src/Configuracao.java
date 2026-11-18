import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Configuracao {
    private static Configuracao instancia;

    private final String regiaoPadrao;
    private final double orcamentoMaximo;

    private Configuracao() {
        Path arquivo = localizarArquivo();
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(arquivo)) {
            props.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("Erro ao ler " + arquivo, e);
        }
        this.regiaoPadrao = props.getProperty("regiao.padrao");
        this.orcamentoMaximo = Double.parseDouble(props.getProperty("orcamento.mensal.maximo"));
        System.out.println("Configuracao carregada de " + arquivo);
    }

    public static synchronized Configuracao getInstancia() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }

    // aceita rodar de dentro de src, de questao1 ou da raiz do repositorio
    private static Path localizarArquivo() {
        String[] candidatos = {
            "config.properties",
            "src/config.properties",
            "questao1/src/config.properties"
        };
        for (String candidato : candidatos) {
            Path caminho = Paths.get(candidato);
            if (Files.exists(caminho)) {
                return caminho;
            }
        }
        throw new IllegalStateException("config.properties nao encontrado");
    }

    public String getRegiaoPadrao() {
        return regiaoPadrao;
    }

    public double getOrcamentoMaximo() {
        return orcamentoMaximo;
    }
}
