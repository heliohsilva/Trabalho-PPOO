import java.util.ArrayList;

public class Comando {
    private ArrayList<String> comando;

    public Comando(ArrayList<String> comando) {
        this.comando = comando;
    }

    public String getPalavraDeComando() {
        return comando.get(0);
    }

    public String comandoRestante() {
        String comandoRestante = "";

        for (int i = 1; i < comando.size(); i++) {
            comandoRestante += comando.get(i) + " ";
        }

        return comandoRestante;
    }

    public boolean ehDesconhecido() {
        return (getPalavraDeComando() == null);
    }

    public boolean temSegundaPalavra() {
        return (comandoRestante() != null);
    }
}
