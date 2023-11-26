
public class CorpoCeleste {
    private String nome;
    private AmbienteInterno ambienteInterno;
    private String descricao;
    private String tipo;

    public CorpoCeleste(String nome, String descricao, String tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        ambienteInterno = new AmbienteInterno("Ambiente interno do " + tipo + " " + nome);
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
        return ambienteInterno.getIndexofCenarioAtual();
    }

    public AmbienteInterno getAmbiente() {
        return ambienteInterno;
    }
}
