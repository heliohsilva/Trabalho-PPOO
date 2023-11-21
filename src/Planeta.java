public class Planeta {
    private String nome;
    private int tipo;
    AmbienteInterno ambienteInterno;

    public Planeta(String nome, int tipo) { // tipo 1 = planeta, tipo 2 = lua
        this.nome = nome;
        this.tipo = tipo;

        ambienteInterno = new AmbienteInterno("Ambiente interno do planeta " + nome);
    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }
}
