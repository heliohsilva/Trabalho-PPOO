public class Planeta {
    private String nome;
    private String tipo;
    private String descricao;
    AmbienteInterno ambienteInterno;

    public Planeta(String nome, String tipo, String descricao) { // tipo 1 = planeta, tipo 2 = lua
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;

        ambienteInterno = new AmbienteInterno("Ambiente interno do planeta " + nome);
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }
}
