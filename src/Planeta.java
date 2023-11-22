import java.util.ArrayList;

public class Planeta {
    private String nome;
    private String tipo; // planeta ou lua
    private String descricao;
    AmbienteInterno ambienteInterno;

    public Planeta(String nome, String tipo, String descricao) { // tipo 1 = planeta, tipo 2 = lua
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;

        ambienteInterno = new AmbienteInterno("Ambiente interno do planeta");
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public int getPosicao() {
        return ambienteInterno.getCenarioAtual();
    }

    public void avancarCenario() {
        ambienteInterno.avancarCenario();
    }

    public void retrocederCenario() {
        ambienteInterno.retrocederCenario();
    }

    public String getItem() {
        return ambienteInterno.getItem();
    }

    public ArrayList<String> getSaida() {
        return ambienteInterno.getSaida();
    }
}
