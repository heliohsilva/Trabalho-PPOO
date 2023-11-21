
public class Ambiente {
    private int tipo;
    private String descricao;

    public Ambiente(int tipo, String descricao) { // 0 = planeta, 1 = lua
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public int getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

}
