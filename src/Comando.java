import java.util.ArrayList;

public class Comando {
    private String palavraDeComando;
    private ArrayList<String> comandoRestante;

    public Comando(String primeiraPalavra, ArrayList<String> comandoRestante) {
        palavraDeComando = primeiraPalavra;
        this.comandoRestante = comandoRestante;
    }

    public String getPalavraDeComando() {
        return palavraDeComando;
    }

    public String comandoRestante() {
        return comandoRestante();
    }

    public boolean ehDesconhecido() {
        return (palavraDeComando == null);
    }

    public boolean temSegundaPalavra() {
        return (!comandoRestante.isEmpty());
    }
}
