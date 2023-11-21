
import java.util.HashMap;
import java.util.Random;

//ambiente interno de um planeta. contem sessoes exploraveis(mapa interno)
public class AmbienteInterno {
    private String descricao;
    private HashMap<String, SessaoExploravel> sessoesExploraveis;
    private Random random;

    public AmbienteInterno(String descricao) {
        this.descricao = descricao;
        sessoesExploraveis = new HashMap<String, SessaoExploravel>();
        random = new Random();
    }

    public void ajustarSaidas(String direcao, SessaoExploravel sessaoExploravel) {
        sessoesExploraveis.put(direcao, sessaoExploravel);
    }

    public String getDescricao() {
        return descricao;
    }

    public SessaoExploravel getSaida(String direcao) {
        return sessoesExploraveis.get(direcao);
    }

    public String direcoesDeSaida() {
        String direcoes = "Saidas: ";
        for (String direcao : this.sessoesExploraveis.keySet()) {
            direcoes += direcao + " ";
        }
        return direcoes;
    }

    public SessaoExploravel getSessaoExploravelAleatoria() {
        int numeroAleatorio = random.nextInt(sessoesExploraveis.size());
        int i = 0;
        for (SessaoExploravel sessaoExploravel : sessoesExploraveis.values()) {
            if (i == numeroAleatorio) {
                return sessaoExploravel;
            }
            i++;
        }
        return null;
    }
}
