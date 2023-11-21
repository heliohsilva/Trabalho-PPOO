import java.util.HashMap;

public class SessaoExploravel {
    String descricao;
    HashMap<String, SessaoExploravel> direcoes;

    public SessaoExploravel(String descricao) {
        this.descricao = descricao;
        direcoes = new HashMap<String, SessaoExploravel>();
    }

    public void ajustarSaidas(String direcao, SessaoExploravel sessaoExploravel) {
        direcoes.put(direcao, sessaoExploravel);
    }

    public String getDescricao() {
        return descricao;
    }

    public SessaoExploravel getSaida(String direcao) {
        return direcoes.get(direcao);
    }

    public String direcoesDeSaida() {
        String direcoes = "Saidas: ";
        for (String direcao : this.direcoes.keySet()) {
            direcoes += direcao + " ";
        }
        return direcoes;
    }
}
