public class Planeta {
    private String nome;
    private int tipo;

    public Planeta(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;

        AmbienteInterno ambienteInterno = new AmbienteInterno("Ambiente interno do planeta " + nome);
    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }
}
